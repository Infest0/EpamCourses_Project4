<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="controller.ControllerParamHandler" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<jsp:useBean id="cons" class="controller.ControllerParamHandler" scope="session"/>

<fmt:setLocale value="${sessionScope[cons.SESSION_LANGUAGE]}" />
<fmt:setBundle basename="${cons.PARAM_PATH}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>+</title>
	<link href="${contextPath}/css/result.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<h1><fmt:message key="${requestScope[cons.ADD_RESULT_MSG]}" /></h1>
</body>
</html>