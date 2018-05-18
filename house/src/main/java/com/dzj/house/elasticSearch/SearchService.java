package com.dzj.house.elasticSearch;

import java.util.List;

import com.dzj.house.dto.SearchDto;

public interface SearchService {

	/**
	 * 索引目標房源（创建索引）
	 * @param houseId
	 */
	public void index(long houseId);
	
	public void remove(long houseId);
	
	
	EsResponse query(SearchDto searchDto);
	/**
	 * 补全信息
	 * @param prefix
	 * @return
	 */
	List<String> suggest(String prefix);
}
