/**
 * 获取筛选后的拌和机信息
 * @param departid  当前选择所属机构编号
 * @param selectId  需要显示拌和机信息的select标签的ID
 * @param bhjtype  1:水泥混凝土 2：沥青混凝土 3：万能机 4：压力机
 */
function shiyanshixinxiSelect(departid,selectId,bhjtype){
	$.ajax({
		url:"banhezhanxinxiController.do?shiyanshiBHJSearch",
		type:'post',
		dataType:"json",
		data:{
			departid:departid,
			bhjtype:bhjtype
		},
		success:function(data){
			$('#'+selectId).html("");
			var jsonStr='<option title="-1" selected="selected" value="">--请选择拌和机--</option>';
			$.each(data.list,function(i,item){
				jsonStr+='<option value="'+item.shebeibianhao+'">'+item.shebeiname+'</option>'
			});
			$('#'+selectId).append(jsonStr);
		}
	});
}

//设备列表下拉
function shebeiSelect(departid,selectId,shebeitype){
	$.ajax({
		url:"v_ShebeiInfoController.do?shebeiSearch",
		type:'post',
		dataType:"json",
		data:{
			departid:departid,
			shebeitype:shebeitype
		},
		success:function(data){
			$('#'+selectId).html("");
			var jsonStr='<option title="-1" selected="selected" value="">--请选择设备--</option>';
			$.each(data.list,function(i,item){
				jsonStr+='<option value="'+item.shebeibianhao+'">'+item.shebeiname+'</option>'
			});
			$('#'+selectId).append(jsonStr);
		}
	});
}