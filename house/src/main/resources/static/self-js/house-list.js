
$(function(){
	
/*	//分页
	$('.table-sort').dataTable({
		
		
		
		"bStateSave": true,//状态保存
		"pading":false,	
		"scrollX": true,
		"aLengthMenu" : [ 2, 10, 15 ] 
		
		
	});
	*/
	//var houseurl='/admin/gethouseinfo/0/4';
	var houseurl='/admin/gethouseinfo/';
	getHouseInfo(houseurl,0,4);
	
	
	
	
	$("body").delegate("#picture-add","click",function(e){
		picture_add("添加图片","/admin/toaddFrontPicture?houseId="+e.currentTarget.dataset.id+"");
	});
	
	
	$("body").delegate("#pciture-show","click",function(e){
		picture_show("查看图片","/admin/topictureshow?houseId="+e.currentTarget.dataset.id+"",e.currentTarget.dataset.id);
	});
	
	
	
	$("body").delegate("#house-delete","click",function(e){
		
		house_del(e.currentTarget,e.currentTarget.dataset.id);
		
	});

	
	$("body").delegate("#house-status","click",function(e){
		
		 house_stop(e.currentTarget,e.currentTarget.dataset.id);
		
	});
	
	$("body").delegate("#house-status-stop","click",function(e){
		
		picture_start(e.currentTarget,e.currentTarget.dataset.id);
		
	});
	
	$("body").delegate("#house-edit","click",function(e){
		
		//house-edit(e.currentTarget,e.currentTarget.dataset.id);
		
		 house_edit("房屋编辑",'/admin/toeditHouse?houseId='+e.currentTarget.dataset.id,e.currentTarget.dataset.id)
		
	});
	
	
	
});



function getHouseInfo(houseurl,start,size){
	$.getJSON(houseurl+start+'/'+size,function(data){
		if(data.code == 1){
			var houseListDtoList =data.result.houseListDtoList;
			var total=data.result.count;
			
			
			var houselisthtml='';
			houseListDtoList.map(function(item,index){
				
				//var pictureSize = item.housePictureList.length;			
				var picturehtml='';
				if(item.frontPicture == null){
					picturehtml ='<span class="l"> <a class="btn btn-primary radius" data-id="'+item.houseId+'" id="picture-add" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 首页图片</a></span>';     
				}else{
					picturehtml ='<a href="javascript:;" data-id="'+item.houseId+'" id="pciture-show" onClick="picture_edit("图库编辑","picture-show.html","10001")"><img width="210" class="picture-thumb" src="'+item.frontPicture+'"></a>'
				}
				var statushtml='';
				
				 if(item.status == 1){
					 statushtml='<td class="td-status" id="status"><span class="label label-success radius">已发布</span></td>'
						 +'<td class="td-manage" >'
						  +'<a style="text-decoration:none" id="house-status" data-id="'+item.houseId+'"  href="javascript:;" title="下架"><i class="Hui-iconfont">&#xe6de;</i></a>'
						  +'<a style="text-decoration:none" id="house-edit" data-id="'+item.houseId+'" class="ml-5"  href="javascript:;" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a>'
						  +'<a style="text-decoration:none" id="house-delete" data-id="'+item.houseId+'" class="ml-5"  href="javascript:;" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a>'
						  +'</td>';
				  }else if(item.status == 0){
					  statushtml='<td class="td-status" id="status"><span class="label label-defaunt radius">已下架</span></td>'
						  +'<td class="td-manage" >'
						  +'<a style="text-decoration:none" id="house-status-stop" data-id="'+item.houseId+'"  href="javascript:;" title="发布"><i class="Hui-iconfont">&#xe603;</i></a>'
						  +'<a style="text-decoration:none" id="house-edit" data-id="'+item.houseId+'" class="ml-5"  href="javascript:;" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a>'
						  +'<a style="text-decoration:none" id="house-delete" data-id="'+item.houseId+'" class="ml-5"  href="javascript:;" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a>'
						  +'</td>';
					  
				  }else if(item.status == -1){
					  statushtml='<td class="td-status" id="status"><span class="label label-danger radius">未通过</span></td>'
					  +'<td class="td-manage" >'
					  +'<a style="text-decoration:none" id="house-edit" data-id="'+item.houseId+'" class="ml-5"  href="javascript:;" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a>'
					  +'<a style="text-decoration:none" id="house-delete" data-id="'+item.houseId+'" class="ml-5"  href="javascript:;" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a>'
					  +'</td>';
				  }else if(item.status == -2){
					  statushtml='<td class="td-status" id="status"><span class="label label-default radius">待审核</span></td>'
						  +'<td class="td-manage" >'
						  +'<a style="text-decoration:none" id="house-edit" data-id="'+item.houseId+'" class="ml-5"  href="javascript:;" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a>'
						  +'<a style="text-decoration:none" id="house-delete" data-id="'+item.houseId+'" class="ml-5"  href="javascript:;" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a>'
						  +'</td>';
				  }
				
				houselisthtml +='<tr class="text-c" >'
							  +'<td><input name="" type="checkbox" value=""></td>'
							  +'<td>'+index+'</td>'
							  +'<td>'+item.title+'</td>'
							  +'<td>'+picturehtml+'</td>'
							  +'<td >'+datetimeFormat(item.lastUpdateTime)+'</td>'
							  + statushtml
							 
							  +'</tr>';
				
				
			});
			
			$("#house-list").html(houselisthtml);
			$("#total").html(total);
			
			
			layui.use('laypage', function () {
		        var laypage = layui.laypage;

		     
		        
		       
		        //执行一个laypage实例
		        laypage.render({
		            elem: 'pageable', //注意，这里的 test1 是 ID，不用加 # 号
		            count: total, //数据总数，从服务端得到
		            limit: size,
		            curr: start / size + 1,
		            jump: function (obj, first) {
		                //obj包含了当前分页的所有参数，比如：
//		                console.log(obj.curr); //得到当前页，以便向服务端请求对应页的数据。
//		                console.log(obj.limit); //得到每页显示的条数

		                //首次不执行
		                if (!first) {
		                	getHouseInfo(houseurl,(obj.curr - 1) * obj.limit, obj.limit);
		                    //window.location.href = locate_url((obj.curr - 1) * obj.limit, obj.limit);
		                }
		            }
		        })
		    });
			
		}
	});
}   



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



/*图片-下架*/
function house_stop(obj,id){
	layer.confirm('确认要下架吗？',function(index){
		var house={};
		house.status="0";
		house.houseId=id;
		$.ajax({
			url:'/admin/updatehousestatus',
			type:'post',
			data:JSON.stringify(house),
			contentType:'application/json',
			cache: false,
			success:function(data){
				if(data.code == 1){
					$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="picture_start(this,'+id+')" href="javascript:;" title="发布"><i class="Hui-iconfont">&#xe603;</i></a>');
					$(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已下架</span>');
					$(obj).remove();
					layer.msg('已下架!',{icon: 5,time:1000});
				}
			}
			
		});
		
		
	});
}

/*图片-发布*/
function picture_start(obj,id){
	layer.confirm('确认要发布吗？',function(index){
		layer.closeAll();
		layer.load(0);
		//layer.openMask("正在发布中，请稍等..."); //开始给出提示  
		var house={};
		house.status=1;
		house.houseId=id;
		$.ajax({
			url:'/admin/updatehousestatus',
			type:'post',
			data:JSON.stringify(house),
			contentType:'application/json',
			cache: false,
			success:function(data){
				if(data.code ==1){
					$(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="house_stop(this,'+id+')" href="javascript:;" title="下架"><i class="Hui-iconfont">&#xe6de;</i></a>');
					$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已发布</span>');
					$(obj).remove();
					 // layer.closeMask(); //执行完关闭     
					layer.closeAll();
					layer.msg('已发布!',{icon: 6,time:1000});
				}
			}
		});
		
		
	});
}

/*图片-申请上线*/
function picture_shenqing(obj,id){
	$(obj).parents("tr").find(".td-status").html('<span class="label label-default radius">待审核</span>');
	$(obj).parents("tr").find(".td-manage").html("");
	layer.msg('已提交申请，耐心等待审核!', {icon: 1,time:2000});
}

/*图片-编辑*/
function house_edit(title,url,id){
	var index = layer.open({
		type: 2,
		title: title,
		content: url
	});
	layer.full(index);
}

/*图片-删除*/
function house_del(obj,id){
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