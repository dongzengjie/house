$('.xunwu-header .rent-page').addClass('on');

var data = {};
var cityEnName = getQueryString("cityEnName");

function locate_url(start, size) {
    var keywords = $('#keyword-box').val();
    if (typeof(keywords) !== 'undefined' && keywords !== null && keywords.length > 0) {
        data.keywords = keywords;
    }

    var target = '/fronthtml/houseinfo.html?cityEnName=' + cityEnName + '&';
    $.each(data, function (key, value) {
        target += key + '=' + value + '&';
    });
    target += 'start=' + start + '&size=' + size;
   // alert(target);
    return target;
}

function changeSimpleCondition(key, value) {
    switch (key) {
        case '*':
            delete data[key];
            break;
        default:
            data[key] = value;
    }
    window.location.href = locate_url(0, 5);
}

function changeSort(orderBy, direction) {
    data.orderBy = orderBy;
    data.orderDirection = direction;

    window.location.href = locate_url(0, 5);
}

	var total = 8;
	var start = 0;
	var size = 5;
	if (size < 1) {
	    size = 5;
	}

$(function () {
	
	 var priceBlock = getQueryString("priceBlock");
	 var areaBlock  = getQueryString("areaBlock");
	 var room = getQueryString("room");
	 var direction = getQueryString("direction");
	 var regionEnName = getQueryString("regionEnName");
	 var rentWay = getQueryString("rentWay");
	 var orderBy = getQueryString("orderBy");
	 var orderDirection = getQueryString("orderDirection");
	
	var subwayId =getQueryString("subwayId");
	var getiniturl='/front/getregionandsubway/'+cityEnName;
	
	$.getJSON(getiniturl,function(data){
		if(data.code==1){
			var subwayList = data.result.subwayList;
			var supportAddresseList =data.result.supportAddresseList;
			var supportAddresseListHTML='<a data-bind="*" >不限</a>';
              
			var subwayListHTML='<a data-bind="*" >不限</a>';
			
			supportAddresseList.map(function(item,index){
				
				if(regionEnName==item.cityEnName){
					supportAddresseListHTML+=' <tr>'
						   +' <a class="on" id ="regionselect" href="javascript:void(0);"data-bind="'+item.cityEnName+'" data-id="'+item.cityEnName+'">'+item.cityCnName+'</a>'
						   +' </tr>';
				}else{
					supportAddresseListHTML+=' <tr>'
						   +' <a id ="regionselect" href="javascript:void(0);"data-bind="'+item.cityEnName+'" data-id="'+item.cityEnName+'">'+item.cityCnName+'</a>'
						   +' </tr>';
				}
				
				
                                                  
			});
			
			subwayList.map(function(item,index){
				if(subwayId == item.subwayId){
					subwayListHTML+=' <tr>'
						   +' <a class="on" id="subwayselect" href="javascript:void(0);"data-bind="'+item.subwayId+'" data-id="'+item.subwayId+'">'+item.subwayName+'</a>'
						   +' </tr>';
				}else{
					subwayListHTML+=' <tr>'
						   +' <a id="subwayselect" href="javascript:void(0);"data-bind="'+item.subwayId+'" data-id="'+item.subwayId+'">'+item.subwayName+'</a>'
						   +' </tr>';
				}
				
				
			});
			
			$("#region").html(supportAddresseListHTML);
			$("#subway").html(subwayListHTML);
		}
	});
	
	
	$("body").delegate("#regionselect","click",function(e){
		
		changeSimpleCondition('regionEnName',e.currentTarget.dataset.id);
		
	});
	

	$("body").delegate("#subwayselect","click",function(e){
		
		changeSimpleCondition('subwayId',e.currentTarget.dataset.id);
		
	});
	 
	 
	 
	 if(priceBlock == ""){
		  data.priceBlock = "*";
	 }else{
		  data.priceBlock = priceBlock;
	 }
	 if(subwayId == ""){
		  data.subwayId = "*";
	 }else{
		  data.subwayId = subwayId;
	 }
	 
	 if(areaBlock == ""){
		  data.areaBlock = "*";
	 }else{
		  data.areaBlock = areaBlock;
	 }
	 
	 if(room == ""){
		  data.room = "*";
	 }else{
		  data.room = room;
	 }
	 
	 if(direction == ""){
		  data.direction = "*";
	 }else{
		  data.direction = direction;
	 }
	 
	 if(regionEnName == ""){
		  data.regionEnName = "*";
	 }else{
		  data.regionEnName = regionEnName;
		 
	 }
	 
	 if(rentWay == ""){
		  data.rentWay = "*";
	 }else{
		  data.rentWay = rentWay;
	 }
	 
	 if(orderBy == ""){
		  data.orderBy = "*";
	 }else{
		  data.orderBy = orderBy;
	 }
	 
	 if(orderDirection == ""){
		  data.orderDirection = "*";
	 }else{
		  data.orderDirection = orderDirection;
	 }
	
	 
		
	 

    $('.region-select a[data-bind="' + data.regionEnName + '"]').addClass('on');
    $('.price-select a[data-bind="' + data.priceBlock + '"]').addClass('on');
    $('.area-select a[data-bind="' + data.areaBlock + '"]').addClass('on');
    $('.room-select a[data-bind="' + data.room + '"]').addClass('on');
    $('.direction-select a[data-bind="' + data.direction+ '"]').addClass('on');
    $('.rent-way-select a[data-bind="' +  data.rentWay + '"]').addClass('on');
    $('#sort-bar').find('div[data-bind="' + data.orderBy +  '"]').addClass('on');

    if (data.orderBy === 'area') {
        var areaSpanText = '';
        if (data.orderDirection == 'desc') {
            areaSpanText = '面积从大到小';
        } else {
            areaSpanText = '面积从小到大';
        }
        $('#sort-bar').find('div[data-bind="area"] span').text(areaSpanText);
    }

    $('#searchForm').submit(function () {
        window.location.href = locate_url(start, size);
        return false;
    });
    
   

  
  

    
    

});

