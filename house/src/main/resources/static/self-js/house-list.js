
$(function(){
	
	//分页
	$('.table-sort').dataTable({
		
		
		
		"bStateSave": true,//状态保存
		"pading":false,	
		"scrollX": true,
		"aLengthMenu" : [ 5, 10, 15 ] 
		
		
	});
	
	var houseurl='/admin/gethouseinfo/0/100';
	$.getJSON(houseurl,function(data){
		if(data.code == 1){
			var houseListDtoList =data.result.houseListDtoList;
			var totalhtml=data.result.count;
			
			
			var houselisthtml='';
			houseListDtoList.map(function(item,index){
				var pictureSize = item.housePictureList.length;			
				var picturehtml='';
				if(pictureSize == 0){
					picturehtml ='<span class="l"> <a class="btn btn-primary radius" onclick="picture_add("添加图片","picture-add.html")" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加图片</a></span>';     
				}else{
					picturehtml ='<a href="javascript:;" onClick="picture_edit("图库编辑","picture-show.html","10001")"><img width="210" class="picture-thumb" src="temp/200x150.jpg"></a>'
				}
				
				houselisthtml +='<tr class="text-c">'
							  +'<td><input name="" type="checkbox" value=""></td>'
							  +'<td>'+index+'</td>'
							  +'<td>'+item.title+'</td>'
							  +'<td>'+picturehtml+'</td>'
							  +'<td >'+item.lastUpdateTime+'</td>'
							  +'<td class="td-status"><span class="label label-success radius">已发布</span></td>'
							  +'<td class="td-manage">'
							  +'<a style="text-decoration:none" onClick="picture_stop(this,"10001")" href="javascript:;" title="下架"><i class="Hui-iconfont">&#xe6de;</i></a>'
							  +'<a style="text-decoration:none" class="ml-5" onClick="picture_edit("图库编辑","picture-add.html","10001")" href="javascript:;" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a>'
							  +'<a style="text-decoration:none" class="ml-5" onClick="picture_del(this,"10001")" href="javascript:;" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a>'
							  +'</td>'
							  +'</tr>'
				
				
			});
			
			$("#house-list").html(houselisthtml);
			$("#total").html(totalhtml);
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

/*图片-查看*/
function picture_show(title,url,id){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}

/*图片-审核*/
function picture_shenhe(obj,id){
	layer.confirm('审核文章？', {
		btn: ['通过','不通过'], 
		shade: false
	},
	function(){
		$(obj).parents("tr").find(".td-manage").prepend('<a class="c-primary" onClick="picture_start(this,id)" href="javascript:;" title="申请上线">申请上线</a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已发布</span>');
		$(obj).remove();
		layer.msg('已发布', {icon:6,time:1000});
	},
	function(){
		$(obj).parents("tr").find(".td-manage").prepend('<a class="c-primary" onClick="picture_shenqing(this,id)" href="javascript:;" title="申请上线">申请上线</a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-danger radius">未通过</span>');
		$(obj).remove();
    	layer.msg('未通过', {icon:5,time:1000});
	});	
}

/*图片-下架*/
function picture_stop(obj,id){
	layer.confirm('确认要下架吗？',function(index){
	
		$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="picture_start(this,id)" href="javascript:;" title="发布"><i class="Hui-iconfont">&#xe603;</i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已下架</span>');
		$(obj).remove();
		layer.msg('已下架!',{icon: 5,time:1000});
	});
}

/*图片-发布*/
function picture_start(obj,id){
	layer.confirm('确认要发布吗？',function(index){
		$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="picture_stop(this,id)" href="javascript:;" title="下架"><i class="Hui-iconfont">&#xe6de;</i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已发布</span>');
		$(obj).remove();
		layer.msg('已发布!',{icon: 6,time:1000});
	});
}

/*图片-申请上线*/
function picture_shenqing(obj,id){
	$(obj).parents("tr").find(".td-status").html('<span class="label label-default radius">待审核</span>');
	$(obj).parents("tr").find(".td-manage").html("");
	layer.msg('已提交申请，耐心等待审核!', {icon: 1,time:2000});
}

/*图片-编辑*/
function picture_edit(title,url,id){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}

/*图片-删除*/
function picture_del(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		$.ajax({
			type: 'POST',
			url: '',
			dataType: 'json',
			success: function(data){
				$(obj).parents("tr").remove();
				layer.msg('已删除!',{icon:1,time:1000});
			},
			error:function(data) {
				console.log(data.msg);
			},
		});		
	});
}