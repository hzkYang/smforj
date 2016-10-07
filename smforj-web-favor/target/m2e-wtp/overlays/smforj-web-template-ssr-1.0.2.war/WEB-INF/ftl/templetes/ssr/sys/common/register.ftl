<#assign base=request.contextPath />
<!DOCTYPE html>
<html lang="zh-CN">
<head>    
  <#include "/ssr/common/common.ftl">
  <@pnotify/>
</head> 
<body>  
	<form class="form-horizontal" role="form" method="post" action="${base}/wechat/register">
		<div class="modal-header">
			<!--<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>-->
			<h4 class="modal-title" id="myModalLabel">注册</h4>
		</div> 
		<div class="modal-body">
			<div class="form-group">
				<label for="campusCardNum" class="col-md-2 control-label">借阅证号</label>
				<div class="col-md-5">
					<input type="text" name="campusCardNum" class="form-control" value="${reader.campusCardNum}" id="campusCardNum" placeholder="借阅证号">
				</div>
			</div>
			<div class="form-group">
				<label for="cellphone" class="col-md-2 control-label">手机号</label>
				<div class="col-md-5">
					<input type="text" name="cellphone" class="form-control" value="${reader.cellphone}" id="cellphone" placeholder="手机号"/>
				</div>
			</div>
		</div>
		<div class="modal-footer">
		    <button type="button" class="btn btn-success" id="scan">扫码</button>
			<button type="submit" class="btn btn-primary">注册</button>
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
			$("#campusCardNum").val(val);
		}; 
	</script> 
</body>
</html>
