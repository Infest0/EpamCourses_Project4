<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="controller.ControllerParamHandler"%>

<jsp:useBean id="cons" class="controller.ControllerParamHandler"
	scope="session" />
<fmt:setLocale value="${sessionScope[cons.SESSION_LANGUAGE]}" />
<fmt:setBundle basename="params.text" />
<c:set var="patients" value="${requestScope[cons.FREE_PATIENTS]}" />
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><fmt:message key="text.addpatienttitle" /></title>

<link href="${contextPath}/css/result.css" rel="stylesheet"
	type="text/css" />


<link href="${contextPath}/css/addpatients.css" rel="stylesheet"
	type="text/css" />

</head>
<body>
	<c:set var="ajaxQuery" value="AjaxGet('${cons.JS_REQ}', ${cons.JS_FUNC}, '${cons.SUBMIT_PATHIST}', '${cons.COMPLAINTS}', 
		'${cons.SELECTED_PATIENT}')" />
		
	<div class="maindiv">
		<c:choose>
			<c:when test="${not empty patients}">
				<span class="headname"><fmt:message key="text.choostpat" /></span>
				<select id="${cons.SELECTED_PATIENT}" class="patchooser">
					<c:forEach var="patient" items="${patients}">
						<option value="${patient.id}">
							${patient.fname} ${patient.sname}
						</option>
					</c:forEach>
				</select>
				<span class="headname"><fmt:message key="text.complaints" /></span>
				<TEXTAREA id="${cons.COMPLAINTS}" ROWS="5" class="complaints"></TEXTAREA>
				<button onclick="${ajaxQuery}" class="addpatient">
					<fmt:message key="text.addpathist" />
				</button>
			</c:when>
			<c:otherwise>
				<h1>
					<fmt:message key="text.nopatients" />
				</h1>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>