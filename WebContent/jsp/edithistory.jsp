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
	<title><fmt:message key="text.edithistory.title" /></title>
	<link href="${contextPath}/css/medichistory.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<jsp:include page="${cons.MY_HISTORY_PATH}" /> 
	<div id="editBtn">
		<c:set var="ajaxQueryHist" value="AjaxGet('${cons.JS_REQ}', ${cons.JS_FUNC}, '${cons.HISTORY_NOTE_REQ}', '${cons.HIST_ID}', '${cons.MY_HISTORY_NOTES}')"/>
		
		<c:set var="ajaxQueryProc" value="AjaxGet('${cons.JS_REQ}', ${cons.JS_FUNC}, '${cons.PROCEDURE_REQ}', '${cons.HIST_ID}', '${cons.MY_HISTORY_NOTES}')"/>
		
		<c:set var="ajaxQueryOut" value="AjaxGet('${cons.JS_REQ}', ${cons.JS_FUNC}, '${cons.OUT_REQ}', '${cons.HIST_ID}', '${cons.MY_HISTORY_NOTES}')"/>
	
		<button class="button middle" onclick="${ajaxQueryHist}">
			<fmt:message key="text.edithistory.addnote" />
		</button>
		
		<button class="button left" onclick="${ajaxQueryProc}">
			<fmt:message key="text.edithistory.addprocedure" />
		</button>	
		
		<button class="button right" onclick="${ajaxQueryOut}">
			<fmt:message key="text.edithistory.outpatient" />
		</button>	
	</div>
	
	<input type="hidden" id="${cons.HIST_ID}" value="${requestScope[cons.HIST_ID]}" />
	<input type ="hidden" id="${cons.MY_HISTORY_NOTES}"  value = "${requestScope[cons.MY_HISTORY_NOTES]}" />
</body>
</html>