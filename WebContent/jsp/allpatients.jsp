<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="controller.ControllerParamHandler"%>

<jsp:useBean id="cons" class="controller.ControllerParamHandler"
	scope="session" />
<fmt:setLocale value="${sessionScope[cons.SESSION_LANGUAGE]}" />
<fmt:setBundle basename="params.text" />
<c:set var="history" value="${requestScope[cons.HISTORIES_LIST]}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<c:forEach var="history" items="${histories}">
			<div class="infoBlock">
				<span class="rowitem"><fmt:message key="text.medicstories.id" />
					: ${history.id}
				</span>
				 <span class="rowitem"><fmt:message
						key="text.medicstories.fname" /> : ${history.patient.fname}
				</span>
				 <span class="rowitem">
				 	<fmt:message key="text.medicstories.sname" />
					${history.patient.sname}
				</span>
				<button class="rowbtn" id="${history.id}" value="${history.id}" onclick="setChosen(${history.id}, '${cons.HIST_ID}'); ${ajaxQuery}">
					<fmt:message key="text.medicstories.open" />
				</button>
			</div>
		</c:forEach>
	</div>
</body>
</html>