<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="controller.ControllerParamHandler"%>

<jsp:useBean id="cons" class="controller.ControllerParamHandler"
	scope="session" />
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<fmt:setLocale value="${sessionScope[cons.SESSION_LANGUAGE]}" />
<fmt:setBundle basename="${cons.PARAM_PATH}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${contextPath}/css/submithistorynote.css" rel="stylesheet"
	type="text/css" />
<title><fmt:message key="text.addnewnote.title" /></title>
</head>
<body>
	<div id="inputForm">
		<input type="hidden" id="${cons.HIST_ID}" value="${requestScope[cons.HIST_ID]}" /> 
		<span class="headerTheme">
			<fmt:message key="text.addnewnote.theme" />
		</span> 
		<input type="text" id="${cons.ADD_HISTORY_THEME}" />
		<span class="headerTheme"><fmt:message key="text.addnewnote.text" /></span>
		<TEXTAREA id="${cons.ADD_HISTORY_TEXT}" ROWS="5"></TEXTAREA>
		<c:set var="ajaxQuery" value="AjaxGet('${cons.JS_REQ}', ${cons.JS_FUNC}, '${cons.ADD_HISTORY_NOTE_REQ}',  
			'${cons.HIST_ID}', '${cons.ADD_HISTORY_THEME}', '${cons.ADD_HISTORY_TEXT}')" />
		<button class="submit" onclick="${ajaxQuery}">
			<fmt:message key="text.addnewnote.add" />
		</button>
	</div>
</body>
</html>