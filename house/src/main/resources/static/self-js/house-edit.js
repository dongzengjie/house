$(function(){
	var getcityurl ='/admin/getcity';
	var getregionurl='/admin/getregion/';
	var getsubwayurl = '/admin/getsubway/';
	var getstationurl = '/admin/getstation/';
//	var addhouseinfourl = '/admin/addHouseInfo'
	var houseId = getQueryString("houseId");
	var gethousedto='/admin/gethousedto/'+houseId;
	
	$.getJSON(getcityurl,function(data){
		var cityselectHTML='<option value="0">请选择市</option>';
		data.result.map(function(item,index){
			cityselectHTML +='<option value="'+item.cityEnName+'">'+item.cityCnName+'</option>'
		});
		$("#city-select").html(cityselectHTML);
		
		
		
	});
	
	
	$("#city-select").change(function(){
		var belongto =$("#city-select").val();
		//alert($("#city-select").find("option:selected").text());
		$.getJSON(getregionurl+belongto,function(data){
			var regionselectHTML='';
			data.result.map(function(item,index){
				regionselectHTML +='<option value="'+item.cityEnName+'">'+item.cityCnName+'</option>'
			});
			
			$("#region-select").html(regionselectHTML);
				
			
		});
		
		$.getJSON(getsubwayurl+belongto,function(data){
			var subwayselectHTML='';
			data.result.map(function(item,index){
				subwayselectHTML +='<option value="'+item.subwayId+'">'+item.subwayName+'</option>'
			});
			
			$("#subway-select").html(subwayselectHTML);
				
			
		});
	});
	

	
	
	$("#subway-select").change(function(){
		var subWayId =$("#subway-select").val();
		$.getJSON(getstationurl+subWayId,function(data){
			var stationselectHTML='';
			data.result.map(function(item,index){
				stationselectHTML +='<option value="'+item.subwayStationId+'">'+item.subwayStationName+'</option>'
			});
			
			$("#station-select").html(stationselectHTML);
			
		});
		
	});
	
	$.getJSON(gethousedto,function(data){
		if(data.code == 1){
			var houseDto = data.result;
			$("#city-select option[value='"+houseDto.cityEnName+"']").attr('selected','selected');
			$("#region-select option[value='"+houseDto.regionEnName+"']").attr('selected','selected');
			$("#subway-select option[value='"+houseDto.subwayId+"']").attr('selected','selected');
		}
	});
	
	
	$("#submit").click(function(){
		
		var houseDto={};
		houseDto.cityCnName=$("#city-select").find("option:selected").text();
		houseDto.title=$("#title").val();
		houseDto.cityEnName=$("#city-select").val();
		houseDto.regionEnName=$("#region-select").val();
		houseDto.street=$("#street").val();
		houseDto.district=$("#district").val();
		houseDto.address=$("#address").val();
		houseDto.room=$("#room").val();
		houseDto.parlour=$("#parlour").val();
		houseDto.direction=$("#direction").val();
		houseDto.buildYear=$("#buildYear").val();
		houseDto.floor=$("#floor").val();
		houseDto.totalFloor=$("#totalFloor").val();
		houseDto.area=$("#area").val();
		houseDto.price=$("#price").val();
		houseDto.rentWay=$("#rentWay").val();
		houseDto.subwayId=$("#subway-select").val();
		houseDto.subwayName=$("#subway-select").find("option:selected").text();
		houseDto.distanceToSubway=$("#distanceToSubway").val();
		houseDto.subwayStationId=$("#station-select").val();
		houseDto.subwayStationName=$("#station-select").find("option:selected").text();
		houseDto.layoutDesc=$("#layoutDesc").val();
		houseDto.traffic=$("#traffic").val();
		houseDto.roundService=$("#roundService").val();
		houseDto.description=$("#description").val();
		
		
		
		$.ajax({
			
			url:addhouseinfourl,
			type:'POST',
			data:JSON.stringify(houseDto),
			contentType : 'application/json',
			cache : false,
			success:function(data){
				if(data.code==1){
					
					alert("提交成功");
				}
			}
		});
		
	});
		
		
});



