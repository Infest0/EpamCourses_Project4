<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="controller.ControllerParamHandler"%>

<jsp:useBean id="cons" class="controller.ControllerParamHandler"
	scope="session" />
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="procedures"
	value="${requestScope[cons.ADD_PROCEDURE_PROCEDURES]}" />

<fmt:setLocale value="${sessionScope[cons.SESSION_LANGUAGE]}" />
<fmt:setBundle basename="${cons.PARAM_PATH}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${contextPath}/css/procedureadd.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="${contextPath}/js/jquery-3.1.0.js"></script>
<script type="text/javascript" src="${contextPath}/js/DisplayContent.js"></script>
<title><fmt:message key="text.addprocedure.title" /></title>
</head>
<body>
	<div class="maindiv">
		<span class="headtitle"> <fmt:message
				key="text.addprocedure.select" />
		</span>

		<div>
			<select id="${cons.ADD_PROCEDURE_SELECTED}">
				<c:forEach var="procedure" items="${procedures}">
					<option value="${procedure}">
						<fmt:message key="text.${procedure}" />
					</option>
				</c:forEach>
			</select>
		</div>
		
		<span class="headtitle">
			<fmt:message key="text.addprocedure.description" />
		</span>
		
		<TEXTAREA class="text" id="${cons.ADD_PROCEDURE_DETAIL}" ROWS="5"> </TEXTAREA>

		<c:set var="ajaxQuery" value="AjaxGet('${cons.JS_REQ}', ${cons.JS_FUNC},  '${cons.ADD_PROCEDURE_REQ}',  '${cons.ADD_PROCEDURE_SELECTED}', 
			'${cons.HIST_ID}', '${cons.ADD_PROCEDURE_DETAIL}')" />

		<button class="submit" onclick="${ajaxQuery}">
			<fmt:message key="text.addprocedure.add" />
		</button>
	</div>

	<input type="hidden" id="${cons.HIST_ID}" value="${requestScope[cons.HIST_ID]}" />
</body>
</html>