<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="controller.ControllerParamHandler"%>

<jsp:useBean id="cons" class="controller.ControllerParamHandler"
	scope="session" />
<fmt:setLocale value="${sessionScope[cons.SESSION_LANGUAGE]}" />
<fmt:setBundle basename="params.text" />
<c:set var="historiess" value="${requestScope[cons.HISTORIES_LIST]}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title><fmt:message key="text.medicstories.title" /></title>
	<link href="${pageContext.request.contextPath}/css/multrowdata.css"
		rel="stylesheet" type="text/css" />
</head>
<body>
	<c:set var="ajaxQuery" value="AjaxGet('${cons.JS_REQ}', ${cons.JS_FUNC}, '${requestScope[cons.OPEN_HISTORIES_ACTION]}', '${cons.HIST_ID}')" />
	<c:set var="addPatHist" value="AjaxGet('${cons.JS_REQ}', ${cons.JS_FUNC}, '${cons.ADD_PATHIST}')" />	
		
		<c:forEach var="history" items="${historiess}">
			<div class="infoBlock">
				<table class="tabledata">
					<tr class="tritem">
						<td class="tditem tddata2col">
							<fmt:message key="text.medicstories.id" />
						</td>
						<td class="tditem tddata2col">
							${history.id}
						</td>
					</tr>
					<tr class="tritem">
						<td class="tditem tddata2col">
							<fmt:message key="text.medicstories.fname" />
						</td>
						<td class="tditem tddata2col">
							${history.patient.fname} 
						</td>
					</tr>
					<tr class="tritem">
						<td class="tditem tddata2col">
							<fmt:message key="text.medicstories.sname" />
						</td>
						<td class="tditem tddata2col">
							${history.patient.sname}
						</td>
					</tr>
					<tr class="tritem">
						<td class="tditem tddata2col">
							<fmt:message key="text.medicstories.complaints" />
						</td>
						<td class="tditem tddata2col">
							${history.complaints}
						</td>
					</tr>
					<tr class="tritem" >
						<td class="tditem tddata1col" colspan="2">
							<button class="rowbtn" id="${history.id}" value="${history.id}"
								onclick="setChosen(${history.id}, '${cons.HIST_ID}'); ${ajaxQuery}">
								<fmt:message key="text.medicstories.open" />
							</button>
						</td>
					</tr>
				</table>	
			</div>
		</c:forEach>
		
	<c:if test="${role.contains('ADD_PATIENT_HISTORY')}">
		<div>
			<button class="centerbtn" onclick=" ${addPatHist}">
				<fmt:message key="text.medicstories.addhist" />
			</button>
		</div>
	</c:if>
	<input type="hidden" id="${cons.HIST_ID}" />
</body>
</html>