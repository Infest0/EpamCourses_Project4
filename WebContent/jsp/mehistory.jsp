<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="controller.ControllerParamHandler"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<jsp:useBean id="cons" class="controller.ControllerParamHandler"
	scope="session" />

<fmt:setLocale value="${sessionScope[cons.SESSION_LANGUAGE]}" />
<fmt:setBundle basename="${cons.PARAM_PATH}" />

<c:set var="history" value="${requestScope[cons.MY_HISTORY_NOTES]}" />
<c:set var="procedures"
	value="${requestScope[cons.MY_HISTORY_PROCEDURES]}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${contextPath}/css/patientinfo.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="${contextPath}/js/jquery-3.1.0.js"></script>
<script type="text/javascript" src="${contextPath}/js/DisplayContent.js"></script>
<title><fmt:message key="text.mehistory.title" /></title>
</head>
<body>
	<div class="maindiv">
		<span class="headername"><fmt:message
				key="text.mehistory.doctornotes" /></span>
		<table>
			<tr>
				<TH><fmt:message key="text.mehistory.theme" /></TH>
				<th><fmt:message key="text.mehistory.text" /></th>
				<th><fmt:message key="text.mehistory.date" /></th>
			</tr>
			<c:forEach var="curhist" items="${history.patientHistoryNotes}">
				<tr>
					<td>${curhist.theme}</td>
					<td>${curhist.text}</td>
					<td>${curhist.date}</td>
				</tr>
			</c:forEach>
		</table>
		<span class="headername"><fmt:message
				key="text.meinfo.activeprocedures" /></span>

		<c:set var="ajaxQueryOut"
			value="AjaxGet('${cons.JS_REQ}', ${cons.JS_FUNC}, '${cons.EXECUTE_PROCEDURE}', '${cons.ADD_PROCEDURE_SELECTED}', '${cons.HIST_ID}')" />

		<table>
			<tr>
				<th><fmt:message key="text.mehistory.procid" /></th>
				<th><fmt:message key="text.mehistory.procType" /></th>
				<th><fmt:message key="text.meinfo.dateassigned" /></th>
				<th><fmt:message key="text.meinfo.medicassigned" /></th>
				<th><fmt:message key="text.meinfo.details" /></th>
				<c:if test="${role.contains('EXECUTE_APPOINTMENT')}">
					<th class="nobordertd"><fmt:message
							key="text.edithistory.execute" /></th>
				</c:if>
			</tr>
			<c:forEach var="proc" items="${history.assignedProcedures}">
				<c:if
					test="${proc.dateExecuted == null || proc.dateExecuted == '' }">
					<tr>
						<td>${proc.id}</td>
						<td><fmt:message key="text.${proc.type}" /></td>
						<td>${proc.dateAssigned}</td>
						<td>${proc.assignedMedic.sname}${proc.assignedMedic.fname}</td>
						<td>${proc.details}</td>
						<c:if
							test="${role.contains('EXECUTE_APPOINTMENT') && requestScope[cons.ADD_PROCEDURE_PROCEDURES].contains(proc.type)}">
							<td class="nobordertd">
								<button class="buttonexec" id="${proc.id}" value="${proc.id}"
									onclick="setChosen(${proc.id}, '${cons.ADD_PROCEDURE_SELECTED}'); ${ajaxQueryOut}">
									+</button>
							</td>
						</c:if>
					</tr>
				</c:if>
			</c:forEach>
		</table>
		<span class="headername"><fmt:message
				key="text.meinfo.executedprocedures" /></span>
		<table>
			<tr>
				<th><fmt:message key="text.mehistory.procid" /></th>
				<th><fmt:message key="text.mehistory.procType" /></th>
				<th><fmt:message key="text.meinfo.dateassigned" /></th>
				<th><fmt:message key="text.meinfo.dateexecuted" /></th>
				<th><fmt:message key="text.meinfo.medicassigned" /></th>
				<th><fmt:message key="text.meinfo.medicexecuted" /></th>
				<th><fmt:message key="text.meinfo.details" /></th>
			</tr>
			<c:forEach var="proc" items="${history.assignedProcedures}">
				<c:if
					test="${proc.dateExecuted != null && proc.dateExecuted != '' }">
					<tr>
						<td>${proc.id}</td>
						<td><fmt:message key="text.${proc.type}" /></td>
						<td>${proc.dateAssigned}</td>
						<td>${proc.dateExecuted}</td>
						<td>${proc.assignedMedic.sname}${proc.assignedMedic.fname}</td>
						<td>${proc.executedMedic.sname}${proc.executedMedic.fname}</td>
						<td>${proc.details}</td>
					</tr>
				</c:if>
			</c:forEach>
		</table>
	</div>
	<input type="hidden" id="${cons.ADD_PROCEDURE_SELECTED}" />
</body>
</html>