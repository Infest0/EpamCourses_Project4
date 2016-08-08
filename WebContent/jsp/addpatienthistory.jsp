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

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:set var="ajaxQuery"
		value="AjaxGet('${cons.JS_REQ}', ${cons.JS_FUNC}, '${cons.SUBMIT_PATHIST}', '${cons.COMPLAINTS}')" />

	<select id="${cons.SELECTED_PATIENT}">
		<c:forEach var="patient" items="${patients}">
			<option value="${patient.id}">${patient.fname}
				${patient.sname}</option>
		</c:forEach>
	</select>
	<TEXTAREA id="${cons.COMPLAINTS}" ROWS="5"></TEXTAREA>
	<button>submit</button>
</body>
</html>