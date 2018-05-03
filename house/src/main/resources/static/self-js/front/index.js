$(function(){
	var getcityurl='/front/getcity';
	
	
	$.getJSON(getcityurl,function(data){
		if(data.code==1){
			var cityList = data.result;
			var json = JSON.stringify(cityList);
			
			var cityHTML='';
			
			$.each(cityList,function(key,value){
				
				$.each(value,function(key,value){
					
					var cityListHTML='';
					value.map(function(item,index){
						cityListHTML +=' <div class="city-enum fl"><a href="/fronthtml/houseinfo.html?cityEnName='+item.cityEnName+'" title="'+item.cityCnName+'租房">'+item.cityCnName+'</a></div>';
					});
					cityHTML+=' <li class="clear">'
						+' <span class="code-title fl">'+key.toUpperCase()+'</span>'
						+cityListHTML
						+'</li>';
							
				});
			});
			
			$("#city-left").html(cityHTML);

		}
	});
	
});