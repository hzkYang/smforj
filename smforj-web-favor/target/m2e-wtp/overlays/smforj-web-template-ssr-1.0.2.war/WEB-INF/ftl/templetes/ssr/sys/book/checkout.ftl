<#assign base=request.contextPath />
<!DOCTYPE html>
<html lang="zh-CN">
<title>金至云图书馆</title>
<head> 
<#include "/ssr/common/common.ftl">   
<@pnotify/> 
</head> 
<body> 
	<form class="form-horizontal" role="form" id="simple_form" method="post" action="${base}/wechat/book/checkout">
		<div class="modal-header">
			<!--<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>-->
			<h4 class="modal-title" id="myModalLabel">借阅</h4>
		</div> 
		<div class="modal-body">  
			<!--<div class="form-group">
				<label for="cardid" class="col-md-2 control-label">证号</label>
				<div class="col-md-5">
					<input type="text" name="cardid" class="form-control" value="${cardid}" id="cardid" placeholder="图书借阅证号">
				</div>
			</div>-->
			<div class="form-group">
				<!--<label for="bookid" class="col-md-1 control-label">图书号</label>-->
				<div class="col-md-5">
					<input type="text" name="bookid" class="form-control" value="${bookid}" id="bookid" placeholder="图书号或条码"> 
				</div> 
			</div> 
			 <div class="form-group"> 
				<div class="col-md-5">
				    <label class="control-label" style="color:red;" id="message"></label>   
				</div> 
			</div>   
		</div>
		<div class="modal-footer">
		    <button type="button" class="btn btn-success" id="scan">扫码</button>
			<button type="button" class="btn btn-primary" id="submit">借阅</button>
			<button type="button" class="btn btn-default" data-dismiss="modal" id="closeWindow">关闭</button>
		</div>
	</form>
	
    <script type="text/javascript">
        $(function(){ 
            $(document).ready(function(){
	            wx.config({  
			        debug: false,  
			        appId: '${appId}',  
			        timestamp:'${timestamp}',  
			        nonceStr:'${nonceStr}',  
			        signature:'${signature}',  
			        jsApiList : ['checkJsApi', 'scanQRCode']  
			    });//end_config   
			    wx.error(function(res) {  
			        alert("出错了：" + res.errMsg);  
			    });   
			    wx.ready(function() {  
				    wx.checkJsApi({  
				        jsApiList : ['scanQRCode'],  
				        success : function(res) {  
				        } });  
                });
             });
            /** 扫一扫**/
		    $("#scan").bind("click",function(){wx.scanQRCode({ 
				    needResult: 1, // 默认为0，扫描结果由微信处理，1则直接返回扫描结果， 
				    scanType: ["qrCode","barCode"], // 可以指定扫二维码还是一维码，默认二者都有 
				    success: function (res) { 
				    //var result = res.resultStr; // 当needResult 为 1 时，扫码返回的结果 
				    setScanValue(res.resultStr);
				}});
		    }); 
		   $("#closeWindow").bind("click",function(){WeixinJSBridge.invoke("closeWindow",{},function(e){})});
        });
        /**将扫描的值赋予相应位置**/
		var setScanValue = function(val)
		{
			$("#bookid").val(val);
		}; 
	</script>
	
    <script type="text/javascript"> 
	    $(function(){
	    	$("#submit").bind("click",submit); 
	    });
	    <!--检测值--> 
	    var checkNull = function()
	    {  
	    	if($("#bookid").val()== "")
	    	{
	    		$("#message").html("图书号不能为空");
	    		return false;
	    	}
	    	return true;
	    } 
		<!--submit--> 
		var submit = function(){ 
			if(!checkNull())
				return false;   
			var jsonforminfo = $("#simple_form").serialize();
            //alert(jsonforminfo);
	        $.ajax({  
	            url : $("#simple_form").attr("action"),  
	            type : "post", 
	            data : jsonforminfo,
	            dataType : "json",   
	            success : function(data) { 
	                if(data.status == 'OK')
	                {
	                	$("#bookid").val("");
	                	$("#message").css("color","green");
	        	    	$("#message").text(data.message);
	        	    }else
	        	    {
	        	        $("#message").css("color","red");
	        	    	$("#message").text(data.message);
	        	    }  
	            },
	            error : function(error){ 
	            	alert(error); 
	            } 
	        });    
		} 
    </script>
</body>
</html>
