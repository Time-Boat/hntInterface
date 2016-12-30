/**
 * 获取筛选后的拌和机信息
 * @param departid  当前选择所属机构编号
 * @param selectId  需要显示拌和机信息的select标签的ID
 * @param bhjtype  1:水泥混凝土 2：沥青混凝土 3：万能机、压力机
 */
function banhezhanxinxiSelect(departid,selectId,bhjtype){
	$.ajax({
		url:"banhezhanxinxiController.do?banhejiSearch",
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
				jsonStr+='<option value="'+item.gprsbianhao+'">'+item.banhezhanminchen+'</option>'
			});
			$('#'+selectId).append(jsonStr);
		}
	});
}