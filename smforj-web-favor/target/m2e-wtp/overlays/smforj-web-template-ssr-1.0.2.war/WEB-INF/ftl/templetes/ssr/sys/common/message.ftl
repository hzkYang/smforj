<#assign base=request.contextPath />
<!DOCTYPE html>
<html lang="zh-CN">
<head> 
	<#include "/ssr/common/common.ftl">  
	<@pnotify/>
</head> 
<body> 
	<div class="modal-header">
		<!--<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>-->
		<h4 class="modal-title" id="myModalLabel">消息界面</h4>
	</div> 
	<div class="modal-body">
		<div class="form-group">
			<!--<label for="campusCardNum" class="col-md-2 control-label">${message}</label>-->
			<div class="col-md-5">
				<label class="control-label" style="color:red;">${message}</label>
			</div>
		</div> 
	</div>
	<div class="modal-footer"> 
		<button type="button" class="btn btn-default" data-dismiss="modal" id="closeWindow">关闭</button>
	</div> 
	<script  type="text/javascript">   
	 	$("#closeWindow").bind("click",function(){WeixinJSBridge.invoke("closeWindow",{},function(e){})});
    </script> 
</body>
</html>
