var xmlHttpRequestxmb; 
var xmlHttpRequestzyd; 
var xmlHttpRequestbhz; 
var xmlHttpRequestgcmc; 
var xmlHttpRequestjzbw;
var webroot="/zgjjmss";

function createXmlHttpRequest() {
	var tmp;
	if(window.XMLHttpRequest) {  
            	try {  
                	tmp = new XMLHttpRequest();  
                	if(tmp.overrideMimeType) {  
                    	tmp.overrideMimeType("text/html;charset=UTF-8");  
                }  
            	}catch (e) {}  
        	}else if(window.ActiveXObject) {  
            	try {  
                	tmp = new ActiveXObject("Microsoft.XMLHTTP");  
            	} catch (e) {  
                	try {  
                    	tmp = new ActiveXObject("Msxml2.XMLHttp");  
                	} catch (e) {  
                    try {  
                        tmp = new ActiveXObject("Msxml3.XMLHttp");  
                    } catch (e) {}  
                	}  
            	}  
        	}
   return tmp;  
}

		//用户类型变化
        function usertypechange(usertype) {         	
       	    xmlHttpRequestuser = createXmlHttpRequest();
            xmlHttpRequestuser.onreadystatechange = userDeal; 
            xmlHttpRequestuser.open("GET", webroot+"/system/usertypechange?usertype=" + usertype, "false"); 
            xmlHttpRequestuser.send(null);   
        } 
        
        function limitusertypechange(usertype) {         	
       	    xmlHttpRequestuser = createXmlHttpRequest();
            xmlHttpRequestuser.onreadystatechange = userDeal; 
            xmlHttpRequestuser.open("GET", webroot+"/system/limitusertypechange?usertype=" + usertype, "false"); 
            xmlHttpRequestuser.send(null);   
        } 
        
        function userDeal() { 
                if (xmlHttpRequestuser.readyState == 4) { 
                     //接收服务端返回的数据 
                     var ret = xmlHttpRequestuser.responseText;                 
							//处理数据 
                        var obj = document.getElementById("museradd_muser_biaoshiid"); 
                        if (empty(obj)) {
                        	obj = document.getElementById("limitmuseradd_muser_biaoshiid");
                        }                        
                        while(obj.options.length != 0) { obj.options[0] = null; }         
                        if (!empty(ret)) {
                        var ops = ret.split("|");                         
                        for (var i = 0; i < ops.length; i++) { 
                                var op = ops[i]; 
                                var ss = op.split(","); 
                                //var oOption = document.createElement("OPTION"); //创建一个OPTION节点                                
                                //oOption.innerText = ss[1];    //设置选择展示的信息 
                                //oOption.value = ss[0];         //设置选项的值 
                                var oOption =  new Option(ss[1], ss[0]); 
                                obj.options.add(oOption);    //将节点加入选项中
                        } 
						}
                } 
        } 
        
	//更新混凝土设计生产量
	function updatehntsj(value, shejiid) {
		xmlHttpRequestsjz = createXmlHttpRequest();
		xmlHttpRequestsjz.open("GET", webroot+"/query/updatehntshejizhi?shejiid=" + shejiid+"&sjvalue="+value, "true"); 
        xmlHttpRequestsjz.send(null); 
	}
	
	//更新超标处理结果
	function updatecljieguo(value, xxbianhao) {
		xmlHttpRequestcl = createXmlHttpRequest();
		xmlHttpRequestcl.open("GET", webroot+"/query/updatecljieguo?refresh="+new Date().getTime()+"&xxbianhao=" + xxbianhao+"&clvalue="+encodeURI(encodeURI(value)), "true"); 
        xmlHttpRequestcl.send(null); 
	}
	


		//标段选择变化
        function bdchange(bdname) { 
        	xmlHttpRequestxmb = createXmlHttpRequest();
        	xmlHttpRequestbhz = createXmlHttpRequest();
        	xmlHttpRequestgcmc = createXmlHttpRequest();
        	xmlHttpRequestjzbw = createXmlHttpRequest();
        	xmlHttpRequestzyd = createXmlHttpRequest();
            var biaoduan = document.getElementById(bdname).value;             
            xmlHttpRequestxmb.onreadystatechange = xmbDeal; 
            xmlHttpRequestxmb.open("GET", webroot+"/query/hntclbdchange?biaoduan=" + biaoduan, "true"); 
            xmlHttpRequestxmb.send(null);   
            
            xmlHttpRequestzyd.onreadystatechange = zydDeal; 
            xmlHttpRequestzyd.open("GET", webroot+"/query/userchangezyd?biaoduan=" + biaoduan, "false"); 
            xmlHttpRequestzyd.send(null);
            
            xmlHttpRequestbhz.onreadystatechange = bhzDeal; 
            xmlHttpRequestbhz.open("GET", webroot+"/query/hntclchangebhz?biaoduan=" + biaoduan, "true"); 
            xmlHttpRequestbhz.send(null);  
              
            
            //xmlHttpRequestgcmc.onreadystatechange = gcmcDeal; 
            //xmlHttpRequestgcmc.open("GET", webroot+"/query/hntclchangegcmc?biaoduan=" + biaoduan, "true"); 
            //xmlHttpRequestgcmc.send(null);  
            
            //xmlHttpRequestjzbw.onreadystatechange = jzbwDeal; 
            //xmlHttpRequestjzbw.open("GET", webroot+"/query/hntclchangejzbw?biaoduan=" + biaoduan, "true"); 
            //xmlHttpRequestjzbw.send(null);         
        } 
        
        //项目部选择变化
        function xmbchange(xmbname) { 
        	xmlHttpRequestbhz = createXmlHttpRequest();
        	xmlHttpRequestgcmc = createXmlHttpRequest();
        	xmlHttpRequestjzbw = createXmlHttpRequest();
        	xmlHttpRequestzyd = createXmlHttpRequest();
            var xmbmc = document.getElementById(xmbname).value;
            
            xmlHttpRequestzyd.onreadystatechange = zydDeal; 
            xmlHttpRequestzyd.open("GET", webroot+"/query/userxmbchangezyd?xmbmc=" + xmbmc, "false"); 
            xmlHttpRequestzyd.send(null);
            
            xmlHttpRequestbhz.onreadystatechange = bhzDeal; 
            xmlHttpRequestbhz.open("GET", webroot+"/query/hntclxmbchangebhz?xmbmc=" + xmbmc, "true"); 
            xmlHttpRequestbhz.send(null);  
            
            //xmlHttpRequestgcmc.onreadystatechange = gcmcDeal; 
            //xmlHttpRequestgcmc.open("GET", webroot+"/query/hntclxmbchangegcmc?xmbmc=" + xmbmc, "true"); 
            //xmlHttpRequestgcmc.send(null);  
            
            //xmlHttpRequestjzbw.onreadystatechange = jzbwDeal; 
            //xmlHttpRequestjzbw.open("GET", webroot+"/query/hntclxmbchangejzbw?xmbmc=" + xmbmc, "true"); 
            //xmlHttpRequestjzbw.send(null);         
        } 
        
        //拌和站选择变化
        function bhzchange(bhzname) { 
        	//xmlHttpRequestgcmc = createXmlHttpRequest();
        	//xmlHttpRequestjzbw = createXmlHttpRequest();
            //var bhzmc = document.getElementById(bhzname).value;            
            
            //xmlHttpRequestgcmc.onreadystatechange = gcmcDeal; 
            //xmlHttpRequestgcmc.open("GET", webroot+"/query/hntclbhzchangegcmc?bhzmc=" + bhzmc, "true"); 
            //xmlHttpRequestgcmc.send(null);  
            
            //xmlHttpRequestjzbw.onreadystatechange = jzbwDeal; 
            //xmlHttpRequestjzbw.open("GET", webroot+"/query/hntclbhzchangejzbw?bhzmc=" + bhzmc, "true"); 
            //xmlHttpRequestjzbw.send(null);         
        }
        
		//产能分析标段选择变化
        function cnfxbdchange(bdname) { 
        	xmlHttpRequestxmb = createXmlHttpRequest();
        	xmlHttpRequestbhz = createXmlHttpRequest();
            var biaoduan = document.getElementById(bdname).value;             
            xmlHttpRequestxmb.onreadystatechange = xmbDeal; 
            xmlHttpRequestxmb.open("GET", webroot+"/query/hntclbdchange?biaoduan=" + biaoduan, "true"); 
            xmlHttpRequestxmb.send(null);   
            
            xmlHttpRequestbhz.onreadystatechange = bhzDeal; 
            xmlHttpRequestbhz.open("GET", webroot+"/query/hntclchangebhz?biaoduan=" + biaoduan, "true"); 
            xmlHttpRequestbhz.send(null);            
        } 
        
        //产能分析项目部选择变化
        function cnfxxmbchange(xmbname) { 
        	xmlHttpRequestbhz = createXmlHttpRequest();
            var xmbmc = document.getElementById(xmbname).value;         
            xmlHttpRequestbhz.onreadystatechange = bhzDeal; 
            xmlHttpRequestbhz.open("GET", webroot+"/query/hntclxmbchangebhz?xmbmc=" + xmbmc, "true"); 
            xmlHttpRequestbhz.send(null);          
        } 
        
		//用户管理标段选择变化
        function userbdchange(bdname) { 
        	xmlHttpRequestxmb = createXmlHttpRequest();
        	xmlHttpRequestzyd = createXmlHttpRequest();
        	xmlHttpRequestbhz = createXmlHttpRequest();
            var biaoduan = document.getElementById(bdname).value;             
            xmlHttpRequestxmb.onreadystatechange = xmbDeal; 
            xmlHttpRequestxmb.open("GET", webroot+"/query/hntclbdchange?biaoduan=" + biaoduan, "false"); 
            xmlHttpRequestxmb.send(null);
            
            xmlHttpRequestzyd.onreadystatechange = zydDeal; 
            xmlHttpRequestzyd.open("GET", webroot+"/query/userchangezyd?biaoduan=" + biaoduan, "false"); 
            xmlHttpRequestzyd.send(null);
            
            xmlHttpRequestbhz.onreadystatechange = bhzDeal; 
            xmlHttpRequestbhz.open("GET", webroot+"/query/userchangebhz?biaoduan=" + biaoduan, "false"); 
            xmlHttpRequestbhz.send(null);           
        } 
        
        //用户管理项目部选择变化
        function userxmbchange(xmbname) { 
        	xmlHttpRequestzyd = createXmlHttpRequest();
        	xmlHttpRequestbhz = createXmlHttpRequest();
            var xmbmc = document.getElementById(xmbname).value; 
            xmlHttpRequestzyd.onreadystatechange = zydDeal; 
            xmlHttpRequestzyd.open("GET", webroot+"/query/userxmbchangezyd?xmbmc=" + xmbmc, "false"); 
            xmlHttpRequestzyd.send(null);
            
            xmlHttpRequestbhz.onreadystatechange = bhzDeal; 
            xmlHttpRequestbhz.open("GET", webroot+"/query/userxmbchangebhz?xmbmc=" + xmbmc, "false"); 
            xmlHttpRequestbhz.send(null);             
        } 
        
      //用户管理拌和站选择变化
        
        function userzydchange(zydname) { 
        	xmlHttpRequestbhz = createXmlHttpRequest();
            var zydmc = document.getElementById(zydname).value;         
            xmlHttpRequestbhz.onreadystatechange = bhzDeal; 
            xmlHttpRequestbhz.open("GET", webroot+"/query/userzydchangebhz?zydmc=" + zydmc, "false"); 
            xmlHttpRequestbhz.send(null);          
        } 
        //拌和站管理标段选择变化
        function bhzlistbdchange(bdname) { 
        	xmlHttpRequestxmb = createXmlHttpRequest();    
            var biaoduan = document.getElementById(bdname).value;             
            xmlHttpRequestxmb.onreadystatechange = xmbDeal; 
            xmlHttpRequestxmb.open("GET", webroot+"/query/hntclbdchange?biaoduan=" + biaoduan, "true"); 
            xmlHttpRequestxmb.send(null);  
        } 
        
        function empty(v){ 
			switch (typeof v){ 
			case 'undefined' : return true; 
			case 'string' : if(v.length == 0) return true; break; 
			case 'boolean' : if(!v) return true; break; 
			case 'number' : if(0 == v) return true; break; 
			case 'object' : 
				if(null == v) return true; 
				if(undefined != v.length && v.length==0) return true; 
				for(var k in v){return false;} return true; 
				break; 
			} 
			return false; 
		}

        function xmbDeal() { 
                if (xmlHttpRequestxmb.readyState == 4) { 
                     //接收服务端返回的数据 
                     var ret = xmlHttpRequestxmb.responseText;                 
							//处理数据 
                        var obj = document.getElementById("xiangmubu");                        
                        while(obj.options.length > 1) { obj.options[1] = null; }               
                        if (!empty(ret)) {
                        var ops = ret.split("|"); 
                        for (var i = 0; i < ops.length; i++) { 
                                var op = ops[i]; 
                                var ss = op.split(",");                                 
                                var oOption =  new Option(ss[1], ss[0]); 
                                obj.options.add(oOption); 
                        } 
						}
                } 
        } 
        function zydDeal() { 
            if (xmlHttpRequestzyd.readyState == 4) { 
                 //接收服务端返回的数据 
                 var ret = xmlHttpRequestzyd.responseText;                 
						//处理数据 
                    var obj = document.getElementById("zuoyedui"); 
                    while(obj.options.length > 1) { obj.options[1] = null; }           
                    if (!empty(ret)) {
                    var ops = ret.split("|"); 
                    for (var i = 0; i < ops.length; i++) { 
                            var op = ops[i]; 
                            var ss = op.split(","); 
                            var oOption =  new Option(ss[1], ss[0]);
                            obj.options.add(oOption);    //将节点加入选项中
                    } 
					}
            } 
        } 
        
        function bhzDeal() { 
                if (xmlHttpRequestbhz.readyState == 4) { 
                     //接收服务端返回的数据 
                     var ret = xmlHttpRequestbhz.responseText;                 
							//处理数据 
                        var obj = document.getElementById("shebeibianhao"); 
                        while(obj.options.length > 1) { obj.options[1] = null; }           
                        if (!empty(ret)) {
                        var ops = ret.split("|"); 
                        for (var i = 0; i < ops.length; i++) { 
                                var op = ops[i]; 
                                var ss = op.split(","); 
                                var oOption =  new Option(ss[1], ss[0]);
                                obj.options.add(oOption);    //将节点加入选项中                                 
                        } 
						}
                } 
        }
        
/*        function gcmcDeal() { 
                if (xmlHttpRequestgcmc.readyState == 4) { 
                     //接收服务端返回的数据 
                     var ret = xmlHttpRequestgcmc.responseText;                 
							//处理数据 
                        var obj = document.getElementById("gongdanhao");                         
                        while(obj.options.length > 1) { obj.options[1] = null; }           
                        if (!empty(ret)) {
                        var ops = ret.split("|"); 
                        for (var i = 0; i < ops.length; i++) { 
                                var op = ops[i]; 
                                var ss = op.split(","); 
                                var oOption =  new Option(ss[1], ss[0]);
                                obj.options.add(oOption);    //将节点加入选项中                                
                        } 
						}
                } 
        }
        
        
        function jzbwDeal() { 
                if (xmlHttpRequestjzbw.readyState == 4) { 
                     //接收服务端返回的数据 
                     var ret = xmlHttpRequestjzbw.responseText;                 
							//处理数据 
                        var obj = document.getElementById("jiaozhubuwei"); 
                        while(obj.options.length > 1) { obj.options[1] = null; }          
                        if (!empty(ret)) {
                        var ops = ret.split("|"); 
                        for (var i = 0; i < ops.length; i++) { 
                                var op = ops[i]; 
                                var ss = op.split(","); 
                                var oOption =  new Option(ss[1], ss[0]);
                                obj.options.add(oOption);    //将节点加入选项中                                
                        } 
						}
                } 
        }  */
        function tijiao_jianli(bianhao) {
        	xmlHttpRequestchuli = createXmlHttpRequest();
            var wentiyuanyin = document.getElementById("wentiyuanyin").value;
            var chulijieguo=document.getElementById("chulijieguo").value;
            var chulifangshi=document.getElementById("chulifangshi").value;
            var	jianlishenpi=document.getElementById("jianlishenpi").value;           	
            var shenpidate=document.getElementById("shenpidate").value;
            var jianliresult=document.getElementById("jianliresult").value;
            var confirmdate=document.getElementById("confirmdate").value;
            var beizhu=document.getElementById("beizhu").value;
            var chulishijian=document.getElementById("chulishijian").value;
            xmlHttpRequestchuli.onreadystatechange = chuliDeal; 
            xmlHttpRequestchuli.open("GET", webroot+"/query/updatejieguo?bianhao=" + bianhao+"&wentiyuanyin="+encodeURIComponent(encodeURIComponent(wentiyuanyin))+"&chulijieguo="+encodeURIComponent(encodeURIComponent(chulijieguo))+"&chulifangshi="+encodeURIComponent(encodeURIComponent(chulifangshi))+"&chulishijian="+encodeURIComponent(encodeURIComponent(chulishijian))+"&beizhu="+encodeURIComponent(encodeURIComponent(beizhu))+"&jianlishenpi="+encodeURIComponent(encodeURIComponent(jianlishenpi))+"&shenpidate="+encodeURIComponent(encodeURIComponent(shenpidate))+"&jianliresult="+encodeURIComponent(encodeURIComponent(jianliresult))+"&confirmdate="+encodeURIComponent(encodeURIComponent(confirmdate)), "true"); 
            xmlHttpRequestchuli.send(null);  
		}
		
		function tijiao(bianhao) {
        	xmlHttpRequestchuli = createXmlHttpRequest();
            var wentiyuanyin = document.getElementById("wentiyuanyin").value;
            alert(bianhao);
            var chulijieguo=document.getElementById("chulijieguo").value;
            var chulifangshi=document.getElementById("chulifangshi").value;
            var beizhu=document.getElementById("beizhu").value;
//            var chulishijian=document.getElementById("chulishijian").value;
            xmlHttpRequestchuli.onreadystatechange = chuliDeal; 
//            xmlHttpRequestchuli.open("GET", webroot+"/query/updatejieguo?bianhao=" + bianhao+"&wentiyuanyin="+encodeURIComponent(encodeURIComponent(wentiyuanyin))+"&chulijieguo="+encodeURIComponent(encodeURIComponent(chulijieguo))+"&chulifangshi="+encodeURIComponent(encodeURIComponent(chulifangshi))+"&chulishijian="+encodeURIComponent(encodeURIComponent(chulishijian))+"&beizhu="+encodeURIComponent(encodeURIComponent(beizhu)), "true"); 
            xmlHttpRequestchuli.open("GET", webroot+"/query/updatejieguo?bianhao=" + bianhao+"&wentiyuanyin="+encodeURIComponent(encodeURIComponent(wentiyuanyin))+"&chulijieguo="+encodeURIComponent(encodeURIComponent(chulijieguo))+"&chulifangshi="+encodeURIComponent(encodeURIComponent(chulifangshi))+"&beizhu="+encodeURIComponent(encodeURIComponent(beizhu)), "true"); 
            xmlHttpRequestchuli.send(null);  
		}
		
        function chuliDeal() { 
            if (xmlHttpRequestchuli.readyState == 4) { 
                 //接收服务端返回的数据 
                 var ret = xmlHttpRequestchuli.responseText;    
						if(ret=="success"){
							alert("提交成功");
							window.location.reload();
						}
                  
            } 
    }
        
    	//更新拌和机的排序
    	function updatebhzorder(value, bhzid) {
    		xmlHttpRequestcl = createXmlHttpRequest();
    		xmlHttpRequestcl.open("GET", webroot+"/system/updatebhzorder?refresh="+new Date().getTime()+"&xxbianhao=" + bhzid+"&clvalue="+encodeURI(encodeURI(value)), "true"); 
            xmlHttpRequestcl.send(null); 
    	}