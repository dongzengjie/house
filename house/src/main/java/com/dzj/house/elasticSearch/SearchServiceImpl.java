package com.dzj.house.elasticSearch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.index.reindex.BulkByScrollResponse;
import org.elasticsearch.index.reindex.DeleteByQueryAction;
import org.elasticsearch.index.reindex.DeleteByQueryRequestBuilder;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.sort.SortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dzj.house.dao.HouseDao;
import com.dzj.house.dto.SearchDto;
import com.dzj.house.entity.House;
import com.dzj.house.rabbitMQ.RabbitMQConfig;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class SearchServiceImpl implements SearchService {

	private static final Logger log = LoggerFactory.getLogger(SearchServiceImpl.class);

	private static final String INDEX_NAME = "searchhouse";
	private static final String INDEX_TYPE = "house";
	@Autowired
	private HouseDao houseDao;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private TransportClient esClient;
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private AmqpTemplate amqpTemplate;

	//消息接受
	@RabbitListener(queues = RabbitMQConfig.TOPIC_QUERY)
	public void handleMessage(String message) {
		try {
			HouseIndexMessage houseIndexMessage = objectMapper.readValue(message, HouseIndexMessage.class);
			switch (houseIndexMessage.getOperation()) {
			case HouseIndexMessage.INDEX:
				createOrUpdate(houseIndexMessage);
				break;
			case HouseIndexMessage.REMOVE:
				remove(houseIndexMessage.getHouseId());
				break;
			default:
				log.error("没有合适的条件");
				break;
			}
		} catch (IOException e) {
			log.error(e.getMessage());
		}
	}

	public void index(long houseId) {
		index(houseId, 0);
	}

	//消息发送
	public void index(long houseId, int relay) {
		if (relay > HouseIndexMessage.MAX_RELAY) {
			log.error("超过最大重发次数");
			return;
		}
		HouseIndexMessage message = new HouseIndexMessage(relay, HouseIndexMessage.INDEX, houseId);
		try {
			amqpTemplate.convertSendAndReceive(RabbitMQConfig.TOPIC_EXCHANGE, RabbitMQConfig.KEY,
					objectMapper.writeValueAsString(message));
		} catch (AmqpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void createOrUpdate(HouseIndexMessage houseIndexMessage) {
		long houseId = houseIndexMessage.getHouseId();
		HouseIndexTemple houseIndexTemple = houseDao.queryHouseIndexByHouseId(houseId);
		if (houseIndexTemple == null) {
			index(houseId, houseIndexMessage.getRelay() + 1);
			log.error("index of houseid {} is null", houseId);
		}

		SearchRequestBuilder requestBuilder = esClient.prepareSearch(INDEX_NAME).setTypes(INDEX_TYPE)
				.setQuery(QueryBuilders.termQuery(HouseIndex.HOUSE_ID, houseId));

		log.debug(requestBuilder.toString());

		boolean success;
		SearchResponse response = requestBuilder.get();
		long totalHit = response.getHits().getTotalHits();
		if (totalHit == 0) {
			// create
			success = create(houseIndexTemple);
		} else if (totalHit == 1) {
			String esId = response.getHits().getAt(0).getId();
			success = update(esId, houseIndexTemple);

		} else {
			success = deleteAndCreate(totalHit, houseIndexTemple);
		}
		if (success) {
			log.debug("success create ");
		}
	}

	public boolean create(HouseIndexTemple houseIndexTemple) {

		try {
			IndexResponse response = esClient.prepareIndex(INDEX_NAME, INDEX_TYPE)
					.setSource(objectMapper.writeValueAsBytes(houseIndexTemple), XContentType.JSON).get();
			log.debug("create index house" + houseIndexTemple.getHouseId());
			if (response.status() == RestStatus.CREATED) {
				return true;
			} else {
				return false;
			}
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			log.error("error to create house index" + e.getMessage());
			return false;

		}

	}

	public boolean update(String esId, HouseIndexTemple houseIndexTemple) {
		try {
			UpdateResponse response = esClient.prepareUpdate(INDEX_NAME, INDEX_TYPE, esId)
					.setDoc(objectMapper.writeValueAsBytes(houseIndexTemple), XContentType.JSON).get();
			log.debug("create index house" + houseIndexTemple.getHouseId());
			if (response.status() == RestStatus.OK) {
				return true;
			} else {
				return false;
			}
		} catch (JsonProcessingException e) {
			
			log.error("error to create house index" + e.getMessage());
			return false;

		}

	}

	public boolean deleteAndCreate(long totalHit, HouseIndexTemple houseIndexTemple) {

		DeleteByQueryRequestBuilder builder = DeleteByQueryAction.INSTANCE.newRequestBuilder(esClient)
				.filter(QueryBuilders.termQuery(HouseIndex.HOUSE_ID, houseIndexTemple.getHouseId())).source(INDEX_NAME);

		BulkByScrollResponse bulkByScrollResponse = builder.get();
		long deleted = bulkByScrollResponse.getDeleted();
		if (deleted != totalHit) {
			log.warn("删除数量不一致");
			return false;
		} else {
			return create(houseIndexTemple);
		}

	}

	public void remove(long houseId) {

		DeleteByQueryRequestBuilder builder = DeleteByQueryAction.INSTANCE.newRequestBuilder(esClient)
				.filter(QueryBuilders.termQuery(HouseIndex.HOUSE_ID, houseId)).source(INDEX_NAME);

		BulkByScrollResponse bulkByScrollResponse = builder.get();
		long deleted = bulkByScrollResponse.getDeleted();

	}

	public EsResponse query(SearchDto searchDto) {

		BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();

		boolQuery.filter(QueryBuilders.termQuery(HouseIndex.CITY_EN_NAME, searchDto.getCityEnName()));
		if (searchDto.getRegionEnName() != null) {
			boolQuery.filter(QueryBuilders.termQuery(HouseIndex.REGION_EN_NAME, searchDto.getRegionEnName()));
		}
		//关键词匹配
		if (searchDto.getKeywords() != null && !searchDto.getKeywords().isEmpty()) {
			boolQuery.must(QueryBuilders.multiMatchQuery(searchDto.getKeywords(), HouseIndex.TITLE, HouseIndex.TRAFFIC,
					HouseIndex.DISTRICT, HouseIndex.ROUND_SERVICE, HouseIndex.SUBWAY_NAME,
					HouseIndex.SUBWAY_STATION_NAME));
		}
		//面积范围查询
		RangeQueryBuilder areaRangeQueryBuilder =QueryBuilders.rangeQuery(HouseIndex.AREA);
		if(searchDto.getAreaMax()>0) {
			areaRangeQueryBuilder.lte(searchDto.getAreaMax());
		}
		if(searchDto.getAreaMin() >0 ) {
			areaRangeQueryBuilder.gte(searchDto.getAreaMin());
		}
		boolQuery.filter(areaRangeQueryBuilder);
		
		//价格范围查询
		RangeQueryBuilder priceRangeQueryBuilder =QueryBuilders.rangeQuery(HouseIndex.PRICE);
		if(searchDto.getPriceMax() > 0) {
			priceRangeQueryBuilder.lte(searchDto.getPriceMax());
		}
		if(searchDto.getPriceMin() > 0) {
			priceRangeQueryBuilder.gte(searchDto.getPriceMin());
		}
		boolQuery.filter(priceRangeQueryBuilder);
		//朝向查询
		if(searchDto.getDirection() != null) {
			boolQuery.filter(QueryBuilders.termQuery(HouseIndex.DIRECTION, searchDto.getDirection()));
		}
		//租凭方式查询
		if(searchDto.getRentWay() !=null) {
			boolQuery.filter(QueryBuilders.termQuery(HouseIndex.RENTWAY, searchDto.getRentWay()));
		}
		
		
		SearchRequestBuilder requestBuilder = esClient.prepareSearch(INDEX_NAME).setTypes(INDEX_TYPE)
				.setQuery(boolQuery)
				.addSort(SortBuilders.fieldSort(searchDto.getOrderBy())
						.order(SortOrder.fromString(searchDto.getOrderDirection())))
				.setFrom(searchDto.getStart()).setSize(searchDto.getSize());

		log.debug(requestBuilder.toString());
		List<Long> houseIds = new ArrayList<>();
		SearchResponse response = requestBuilder.get();
		if (response.status() != RestStatus.OK) {
			log.warn("error to query ");
			return null;
		}
		for (SearchHit hit : response.getHits()) {

			System.out.println(hit.getSource().get(HouseIndex.FRONT_PICTURE));
			houseIds.add(Long.parseLong(String.valueOf(hit.getSource().get(HouseIndex.HOUSE_ID))));
		}
		EsResponse esResponse = new EsResponse();
		esResponse.setHouseId(houseIds);
		esResponse.setTotal(Integer.parseInt(String.valueOf(response.getHits().getTotalHits())));
		log.debug("total = " + String.valueOf(response.getHits().getTotalHits()));
		return esResponse;
	}

	public List<String> suggest(String prefix) {
		
		return null;
	}

}
