<!DOCTYPE html>
<html lang="zh-CN">
<head>
<#include "/ssr/common/common.ftl">
<@pnotify/>
<title>查询界面</title>
</head>
<body> 
	<#-- 内容开始 -->
	<div class="warpq">
		<form action="#">   
			<#-- 结果列表 -->
			<div class="panel panel-default">
				<div class="panel-heading">
					<span>借阅列表           ${(user)!}</span> 
				</div>
				<table class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th>序号</th>
							<th>图书名称</th>
							<th>条码</th>
							<th>状态</th>
							<th>借阅日期</th>
							<th>应还日期</th> 
						</tr>
					</thead>
					<#list records as result>
					<tr>
						<td> 
							<a href="#" data-toggle="modal" data-backdrop="static" data-target="#myModal">${result.crId}</a>
						</td>
						<td>${result.bookName}</td>
						<td>${result.barcode}</td>
						<td>${result.status}</td> 
						<td>${result.borrowDate}</td>
						<td>${result.needReturnDate}</td> 
					</tr>
					</#list> 
				</table>
			</div>
		</form>
	</div> 
	<@modal/>
</body>
</html>
