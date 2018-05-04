$(function(){
	
	var houseId=getQueryString("houseId");
	var pictureurl='/admin/getpicturelist/'+houseId;
	
	
	
	$('#picture-add').click(function(){
		picture_add("添加图片","/admin/toaddHousePicture?houseId="+houseId+"");
	});
	
	
	
	$.getJSON(pictureurl,function(data){
		if(data.code==1){
			housePictureList=data.result;
			var count =housePictureList.length;
			$("#count").html(count);
			var pictureListHTML="";
			housePictureList.map(function(item,index){
				pictureListHTML +='<li class="item">'
								+'<div class="portfoliobox">'
								+'<input class="checkbox" name="" type="checkbox" value="">'
								+'<div class="picbox"><a href="'+item.location+'" data-lightbox="gallery" data-title=""><img src="'+item.location+'"></a></div>'
								+'<div class="textbox"> </div>'
								+'</div>'
								+'</li>'
			});
			$('#picture-list').html(pictureListHTML);
			
			
		}
	});
	
	
	
	
});


function picture_add(title,url){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}