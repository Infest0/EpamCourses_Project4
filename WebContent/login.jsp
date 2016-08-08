<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="controller.ControllerParamHandler" %>

<c:set var="language"
	value="${not empty param.language 
				? param.language 
				: not empty language 
					? language 
					: pageContext.request.locale}"
	scope="session" />

<jsp:useBean id="cons" class="controller.ControllerParamHandler" scope="session"/>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<fmt:setLocale value="${sessionScope[cons.SESSION_LANGUAGE]}" />
<fmt:setBundle basename="${cons.PARAM_PATH}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="${contextPath}/css/login.css" />
	<script type="text/javascript" src="${contextPath}/js/jquery-3.1.0.js"></script>
	<script type="text/javascript" src="${contextPath}/js/DisplayContent.js"></script>
	<title><fmt:message key="text.login.title" /></title>
</head>
<body>
	<div class="formdiv">
		<div class="formhead">
			<span class="headtext"><fmt:message key="text.login.header" /></span>
		</div>
		<form class="form" action="./LoginServlet" method="post">
			<span class="formline"> 
				<span class="fieldname"> 
					<fmt:message key="text.login.username" />
				</span> 
				<input class="inputinfo" type="text" name="${cons.LOGIN_USNAME}" />
			</span>
			 <span class="formline">
			 	 <span class="fieldname">
					  <fmt:message key="text.login.password" />
				</span> 
				<input class="inputinfo" type="password" name="${cons.LOGIN_PASS}" />
			</span> 
			 <span class="formline"> 
				<input type="submit" value="<fmt:message key="text.login.button" />" />
			</span>
		</form>
		<form class="langpicker">
			<select id="language" name="${cons.SESSION_LANGUAGE}" onchange="submit()">
				<option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
				<option value="ru" ${language == 'ru' ? 'selected' : ''}>Russian</option>
			</select>
		</form>
	</div>
</body>
</html>