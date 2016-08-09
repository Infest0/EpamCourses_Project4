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
<title><fmt:message key="text.managinghistory.title" /></title>

<link href="${contextPath}/css/result.css" rel="stylesheet"
	type="text/css" />


<link href="${contextPath}/css/managehistory.css" rel="stylesheet"
	type="text/css" />
	

<link href="${contextPath}/css/multrowdata.css" rel="stylesheet"
	type="text/css" />

</head>
<body>
	<c:set var="addMedic"
		value="AjaxGet('${cons.JS_REQ}', ${cons.JS_FUNC}, '${cons.ADD_MEDIC_TO_HISTORY}', '${cons.SELECTED_MEDIC}', '${cons.HIST_ID}')" />
		
	<c:set var="ajaxQueryOut"
		value="AjaxGet('${cons.JS_REQ}', ${cons.JS_FUNC}, '${cons.OUT_PATIENT_BY_ADMIN}', '${cons.HIST_ID}')" />
	
	<div class="maindiv">
		<table class="tabledata">
			<c:forEach var="medic" items="${medics}">
				<tr class="tritem">
					<td class="tditem tddata2col"><fmt:message key="text.managinghistory.drname" /></td>
					<td class="tditem tddata2col">${medic.fname} ${medic.sname}</td>
				</tr>
			</c:forEach>
		</table>

		<div>
			<c:choose>
				<c:when test="${not empty availableMedics}">
					<span class="headname">Choose patient to add</span>
					<select id="${cons.SELECTED_MEDIC}">
						<c:forEach var="availableMedic" items="${availableMedics}">
							<option value="${availableMedic.id}">
								${availableMedic.fname} ${availableMedic.sname}
							</option>
						</c:forEach>
					</select>
		
					<button  onclick="${addMedic}" class="singlebtn">Add Medic</button>
				</c:when>
				<c:otherwise>
					<h1><fmt:message key="text.managinghistory.nodoctors" /></h1>
				</c:otherwise>
			</c:choose>
	
			<button onclick = "${ajaxQueryOut}" class="centerbtn"><fmt:message key="text.managinghistory.dischange" /></button>
		</div>

	 <input type="hidden" id="${cons.HIST_ID}" value="${requestScope[cons.HIST_ID]}" />
    </div>
</body>
</html>