$(function(){
	var getcityurl='/front/getcity';
	
	
	$.getJSON(getcityurl,function(data){
		if(data.code==1){
			var cityList = data.result;
			
			/*var json = JSON.stringify(cityList);
			  for (var key in json)
			    {
			        alert(key); 
			    }*/
			cityList.map(function(item,index,array){
				
			});
		}
	});
	
});