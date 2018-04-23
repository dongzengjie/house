$(function(){
	var getcityurl ='/admin/getcity';
	var getregionurl='/admin/getregion/';
	var getsubwayurl = '/admin/getsubway/';
	var getstationurl = '/admin/getstation/';
	
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
				subwayselectHTML +='<option value="'+item.subwayId+'">'+item.name+'</option>'
			});
			
			$("#subway-select").html(subwayselectHTML);
				
			
		});
	});
	
	
	$("#subway-select").change(function(){
		var subWayId =$("#subway-select").val();
		$.getJSON(getstationurl+subWayId,function(data){
			var stationselectHTML='';
			data.result.map(function(item,index){
				stationselectHTML +='<option value="'+item.subwayStationId+'">'+item.name+'</option>'
			});
			
			$("#station-select").html(stationselectHTML);
			
		});
		
	});
		
		
});