<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="controller.ControllerParamHandler"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<jsp:useBean id="cons" class="controller.ControllerParamHandler"
	scope="session" />

<fmt:setLocale value="${sessionScope[cons.SESSION_LANGUAGE]}" />
<fmt:setBundle basename="params.text" />
<c:set var="medics" value="${requestScope[cons.HISTORY_MEDICS]}" />
<c:set var="availableMedics"
	value="${requestScope[cons.HISTORY_AVAILABLE_MEDICS]}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:set var="addMedic"
		value="AjaxGet('${cons.JS_REQ}', ${cons.JS_FUNC}, '${cons.ADD_MEDIC_TO_HISTORY}', '${cons.SELECTED_MEDIC}', '${cons.HIST_ID}')" />

	<table>
		<c:forEach var="medic" items="${medics}">
			<tr>
				<td>NAME</td>
				<td>${medic.fname}</td>
				<td>FNAME</td>
				<td>${medic.sname}</td>
			</tr>
		</c:forEach>
	</table>

	<div>
		<select id="${cons.SELECTED_MEDIC}">
			<c:forEach var="availableMedic" items="${availableMedics}">
				<option value="${availableMedic.id}">
					${availableMedic.fname} ${availableMedic.sname}
				</option>
			</c:forEach>
		</select>

		<button class="button left" onclick="${addMedic}">Add Medic</button>

		<%-- 		<button class="button right" onclick="${ajaxQueryOut}">Dischange</button> --%>

	</div>

	<input type="hidden" id="${cons.HIST_ID}"
		value="${requestScope[cons.HIST_ID]}" />
</body>
</html>