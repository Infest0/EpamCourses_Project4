<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="controller.ControllerParamHandler"%>
<%@ taglib uri="tags.JSExecuteTag" prefix="js"%>

<fmt:setLocale value="${sessionScope[cons.SESSION_LANGUAGE]}" />
<fmt:setBundle basename="${cons.PARAM_PATH}" />

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<jsp:useBean id="cons" class="controller.ControllerParamHandler"
	scope="session" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title><fmt:message key="text.medicstories.title" /></title>
	<link href="${contextPath}/css/main.css" rel="stylesheet"
		type="text/css" />
	<script type="text/javascript" src="${contextPath}/js/jquery-3.1.0.js"></script>
	<script type="text/javascript" src="${contextPath}/js/DisplayContent.js"></script>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<div id="logo">
				<img src="${pageContext.request.contextPath}/img/menuLogo.png"
					alt="Hospital" id="logoid" />
			</div>
			<div id="menu">
				<ul>
					<li><a href="#"><fmt:message key="text.index.systemname" /></a></li>
					<c:if test="${role.contains('SHOW_INFO_ABOUT_ME')}">
						<li>
							<js:jslink jsMain="AjaxGet" jsExecute="${cons.JS_FUNC}"
								javaHandler="${cons.JS_REQ}" command="${cons.ME_INFO_REQ}">
								<fmt:message key="text.index.me" />
							</js:jslink>
						</li>
					</c:if>
					<c:if test="${role.contains('SHOW_PATIENT_HISTORY')}">
						<li>
							<js:jslink jsMain="AjaxGet" jsExecute="${cons.JS_FUNC}"
								javaHandler="${cons.JS_REQ}" command="${cons.PAT_HIST_REQ}">
								<fmt:message key="text.index.ill" />
							</js:jslink>
						</li>
					</c:if>
					<c:if test="${role.contains('SHOW_USER_HISTORIES')}">
						<li>
							<js:jslink jsMain="AjaxGet" jsExecute="${cons.JS_FUNC}"
								javaHandler="${cons.JS_REQ}" command="${cons.HISTORIES_REQ}">
								<fmt:message key="text.index.histories" />
							</js:jslink>
						</li>
					</c:if>
					<c:if test="${role.contains('SHOW_NOT_DISCHANGED_HISTORIES')}">
						<li>
							<js:jslink jsMain="AjaxGet" jsExecute="${cons.JS_FUNC}"
								javaHandler="${cons.JS_REQ}" command="${cons.SHOW_NOT_DISCHANGED}">
								<fmt:message key="text.index.managehistories" />
							</js:jslink>
						</li>
					</c:if>
					<li>
						<a href="${pageContext.request.contextPath}/LogoutServlet">
							<fmt:message key="text.index.logout" />
						</a>
					</li>
				</ul>
			</div>
		</div>
		<div id="body"></div>
	</div>
</body>
</html>