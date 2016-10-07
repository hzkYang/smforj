<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html> 
<head><spring:message code="title"/></head>
<body>
<h2>Welcome to smforj !</h2>
<h2><a href="changelangsession?language=en_us">英文</a>&amp;nbsp&amp;nbsp<a href="./changelangsession?language=zh_cn">中文</a></h2> 
<h2><a href="admin/login"><spring:message code="adminlogin"/></a></h2> 
<h2><a href="front/login"><spring:message code="frontlogin"/></a></h2>
<h2><a href="front/signup"><spring:message code="frontsignup"/></a></h2> 
 
</body>
</html>
