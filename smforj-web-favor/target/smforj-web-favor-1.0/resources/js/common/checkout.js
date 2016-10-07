/** checkout and renew js**/
$(function(){    
    /** 扫一扫**/
    $("#scan").bind("click",function(){
    	wx.scanQRCode({  
		    needResult: 1, // 默认为0，扫描结果由微信处理，1则直接返回扫描结果， 
		    scanType: ["qrCode","barCode"], // 可以指定扫二维码还是一维码，默认二者都有 
		    success: function (res) { 
		    //var result = res.resultStr; // 当needResult 为 1 时，扫码返回的结果 
		    setScanValue(res.resultStr);
		     } 
		});
    }); 
    /**关闭**/
	$("#closeWindow").bind("click",function(){WeixinJSBridge.invoke("closeWindow",{},function(e){});});
	/**提交**/
	$("#submit").bind("click",submit);   
	
	$(document).ready(function(){
	    wx.config({  
	        debug: false,  
	        appId: '${appId}',  
	        timestamp:'${timestamp}',  
	        nonceStr:'${nonceStr}',  
	        signature:'${signature}',  
	        jsApiList : [ 'checkJsApi', 'scanQRCode' ]  
	    });//end_config  
	    wx.error(function(res) {  
	        alert("出错了：" + res.errMsg);  
	    });   
	    wx.ready(function() {  
		    wx.checkJsApi({  
		        jsApiList : ['scanQRCode'],  
		        success : function(res) {  
		        }  
	    });  
     }); 
}); 
	
/**将扫描的值赋予相应位置**/
var setScanValue = function(val)
{
	$("#bookid").val(val);
}; 
/**检测值**/
var checkNull = function()
{  
	if($("#bookid").val()== "")
	{
		$("#message").html("图书号不能为空");
		return false;
	}
	return true;
};
/**提交**/
var submit = function()
{ 
	if(!checkNull()) {return false;}   
	var jsonforminfo = $("#simple_form").serialize(); 
    $.ajax({  
        url : $("#simple_form").attr("action"),  
        type : "post", 
        data : jsonforminfo,
        dataType : "json",   
        success : function(data) {
            if(data.status == 'OK')
            	$("#bookid").val("");  
    	    $("#message").text(data.message);  
        },
        error : function(error){ 
        	alert(error); 
        }
      });
};
