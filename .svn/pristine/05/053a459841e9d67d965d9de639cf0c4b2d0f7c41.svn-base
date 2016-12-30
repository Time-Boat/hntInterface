<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title></title>
	<style>
.icon{
	background-image: url('icons/linkbutton_bg.png');
	  background-repeat: no-repeat;
	  -moz-border-radius: 5px 5px 5px 5px;
	  -webkit-border-radius: 5px 5px 5px 5px;
	  border-radius: 5px 5px 5px 5px;
	
}
</style>
</head>

<body style="margin:0px;padding: 0px;">
<div class="easyui-layout" fit="true" id="main_test_list">
	<div region="center" style="padding:1px;">
  		<div class="demo_main">  
  			<div style="width: 70%;min-height:25px">
  				<table style="width: 100%;">
  					<tr>
  						<td align="right">
  							<span>组织机构:<input id="main" type="text" value="${depart.TSPDepart.departname}" style="height:24px;width:180px;" >
							<div><input id="maindepartid" name="departid" style="display: none;" value="${depart.TSPDepart.id}"></div></span> 
						</td>
						<td align="left">   
							<span> <a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="mainList();" >查询</a></span> 
						</td>
  					</tr>
  				</table>
  			</div>
  			<div style="width: 100%;overflow:auto;height:100%;position:absolute;" id="map"></div>
    	</div>     
 	</div>
 	<div    iconCls="icon-reload"  split="true"  id="testmain11"	 data-options="region:'east',
 																							   title:'拌和站/试验室',
																							   collapsed:false,
																							   split:true,
																							   border:false,
																								onCollapse : function() {
																								    li_east = 0;
																								},
																							   onExpand : function(){
																							   		li_east = 1;
																							   }"
	style="width: 400px; overflow: hidden;">
		<div style="width:390px ;height:100%;border:0 solid navy;overflow:auto;">
			<table id="mainbhzorsys" style="width: 400px; overflow: hidden;" onscroll=""></table>
		</div>
	</div>
	
 <script type="text/javascript" src="http://api.map.baidu.com/api?v=1.5&ak=EE1599abedea46f8a6a90ea4510bd5ca"></script> 	
 <script type="text/javascript">
 
 $(function() {
		$('#main').combotree({
			url : 'departController.do?setPFunction&selfId=${depart.id}',
			onClick: function(node){
				$("#maindepartid").val(node.id);
				$("#main").val(node.name);
			}
		});
	});  
 
 	var li_east = 0; 
   var markerxixx="${toplist}"; 
   var top1="${toplist1}"; 
 var mapObj=null; 
 mapInit(markerxixx,top1);
 function  mapInit(test1,test2) { 
	 var nn = test2.split(",");
	    mapObj = new BMap.Map("map");
	    var point = new BMap.Point(nn[0],nn[1]);  // 创建点坐标  
	    mapObj.centerAndZoom(point, 13);   
	    mapObj.enableScrollWheelZoom(); 
	  //第4步：向地图中添加缩放控件  
        var ctrlNav = new window.BMap.NavigationControl({  
            anchor: BMAP_ANCHOR_TOP_LEFT,  
            type: BMAP_NAVIGATION_CONTROL_LARGE  
        });  
        mapObj.addControl(ctrlNav);  
        //第5步：向地图中添加缩略图控件  
        var ctrlOve = new window.BMap.OverviewMapControl({  
            anchor: BMAP_ANCHOR_BOTTOM_RIGHT,  
            isOpen: 1  
        });  
        mapObj.addControl(ctrlOve);  

        //第6步：向地图中添加比例尺控件  
        var ctrlSca = new window.BMap.ScaleControl({  
            anchor: BMAP_ANCHOR_BOTTOM_LEFT  
        });  
        mapObj.addControl(ctrlSca);
        mapObj.addControl(new BMap.MapTypeControl({  
            anchor : BMAP_ANCHOR_TOP_RIGHT  
        }));  
        if (test1.length>0) {
        	var ops = test1.split("|"); 
        	var point = new Array(); //存放标注点经纬信息的数组
            var maker = new Array();
            $("#mainbhzorsys").html("");
            var newRow = '';
        	for (var i = 0; i < ops.length-1; i++) {
        		 var op = ops[i]; 
        	     if(op.length>0){  
        		          var ss = op.split(","); 
        		          var p0 = ss[1];  
        	              var p1 = ss[2];
        	              maker[i] = addMarker(new window.BMap.Point(p0, p1), i,ss[9],ops.length);
        	              var label = new window.BMap.Label('<a href="#option'+i+'">'+ss[0]+'</a>', { offset: new window.BMap.Size(20, -10) }); 
        	              maker[i].setLabel(label);
        	            	newRow=newRow+'<tr ><td colspan="2">————————————————————————————————</td></tr>'; 
        	            	newRow=newRow+'<tr  id="option'+i+'"><td colspan="2" style="color:red;font-weight:bold"><font size="1">'+ss[0]+'</font></td></tr>'; 
	        	           	newRow=newRow+'<tr ><td colspan="2">共有:'+ss[6]+'</td></tr>';
	        	           	newRow=newRow+'<tr ><td >面积:'+ss[5]+'</td><td >'+ss[4]+'</td></tr>';
	        	           	var tt = ss[8].split("~");
	        	           /*&pid="+ss[7]+"  */
	        	           if(ss[3]==1){
	        	        		newRow=newRow+'<tr ><td colspan="1">拌和机名称</td><td colspan="1">出料时间</td></tr>'; 
	        	        		  for(var j=0;j<tt.length-1;j++){
	        	        			var t=tt[j].split("#");
	        	        			newRow=newRow+'<tr ><td colspan="1">'+t[2]+'</td><td colspan="1">'+t[1]+'</td></tr>';
	        	        		}  
	        	        		newRow=newRow+'<tr ><td colspan="2">———————————————————————</td></tr>'; 
	        	           	var hunnituyl="toDemo('HunnintuylcxController.do?hunnintuylcxlist&isIframe&pid="+ss[7]+"','拌和机用量查询')";
	        	           	var hunnitucbcl="toDemo('hunnintujieguoViewController.do?hntclchaobiaolist&departid="+ss[7]+"','超标数据查询')";
	        	           	var image="'"+"./webpage/main/icons/linkbutton_bg.png"+"'";
	        	           	newRow=newRow+'<tr ><td colspan="2" style="color:green;">生产数据详情: <a href="#" style="color:blue;"  onclick="'+hunnituyl+';" >详情</a></td></tr>';
	        	           	newRow=newRow+'<tr ><td colspan="2" style="color:green;">超标处置详情: <a href="#" style="color:blue;"  onclick="'+hunnitucbcl+';" >详情</a></td></tr>';
	        	           }else{
	        	        		newRow=newRow+'<tr ><td colspan="2">———————————————————————</td></tr>'; 
	        	        	   var phblilun="toDemo('lilunpeihebiController.do?lilunpeibiList&superGroup="+ss[7]+"','理论配合比查询')";
	        	        	   /* newRow=newRow+'<tr ><td colspan="2" style="color:green;">配合比详情: <a href="#" style="color:green;" onclick="'+phblilun+';" >详情</a></td></tr>'; */
	        	           }
        	     }
        		
        	}
       	 $('#mainbhzorsys').append(newRow);
        	 
        }
       /*  $('#main_test_list').layout('expand','east'); */
 }
 
 
 /* function goTotop(obj){
 		var name="'#"+obj+"'";
 		alert(name);
 		alert(obj);
		var _targetTop = $(name).offset().top;//获取位置
		alert("---2-")
		jQuery("html,body").animate({scrollTop:_targetTop},300);//跳转
		alert("--2--");
	} */
 
 function mainList() {
	 $.ajax({
	     type: 'POST',
	     url: 'loginController.do?home1',
	     data:{    
	    	 pid : $("#maindepartid").val()   
   		 },
   		 success:function(data){
   			$("#map").html("");
   			mapInit(data.toplist,data.toplist1);
   		 }
	     
	});
	 
 }   
 
 // 添加标注  
 function addMarker(point, index,s,j) {  
     var myIcon;
     if(s==1){
	     myIcon = new BMap.Icon("http://api.map.baidu.com/lbsapi/createmap/images/icon.png",  
	         new BMap.Size(23, 25), {  
	             offset: new BMap.Size(10, 25),  
	             imageOffset: new BMap.Size(-42, 3 - 1 * 25)  
	         });  
     }else{
    	 myIcon = new BMap.Icon("http://api.map.baidu.com/lbsapi/createmap/images/icon.png",  
    	         new BMap.Size(23, 25), {  
    	             offset: new BMap.Size(10, 25),  
    	             imageOffset: new BMap.Size(0, 3 - 1 * 25)  
    	         });  
     }
     var marker = new BMap.Marker(point, { icon: myIcon });  
     mapObj.addOverlay(marker);  
     
     marker.addEventListener("click",function(){
    	 var option="option"+index+"";
    	 var opti="#option"+index;
    	 for(var i=0;i<j-1;i++){
    		 var opt="option"+i+""; 
    		 var tt=document.getElementById(opt).value;
    		 alert(tt);
    		 if(tt!=null){
    			 document.getElementById(opt).style.backgroundColor="blue";
    		 }
    	 }
    	
  		document.getElementById(option).style.backgroundColor="green";
  		location.hash=opti;
  		 	$('#main_test_list').layout('expand','east');
     });
     
     return marker;  
 }  
 
 function toDemo(url,name) {
    /*  var url = "cgFormHeadController.do?cgFormHeadList"; */
     addTab(name,url,'default')
 }
 
 
  
 
 </script>
</body> 