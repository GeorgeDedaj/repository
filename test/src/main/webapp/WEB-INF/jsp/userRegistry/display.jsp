<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Test Application</title>
</head>
<body>
	<c:if test="${not empty userRegistries}">
		<TABLE BORDER CELLSPACING="10" CELLPADDING="10" WIDTH="50%">
			<c:forEach items="${userRegistries}" var="registry">
				<TR VALIGN="Top">
					<TD WIDTH="3%"><strong>User RegistryId<strong></TD>
					<TD WIDTH="20%">${registry.userRegistryId}</TD>
				</TR>
				<TR VALIGN="Top">
					<TD WIDTH="3%"><strong>Issue Date<strong></TD>
					<TD WIDTH="20%">${registry.issueDate}</TD>
				</TR>
				<TR VALIGN="Top">
					<TD WIDTH="3%"><strong>Return Date<strong></TD>
					<TD WIDTH="20%">${registry.returnDate}</TD>
				</TR>
			</c:forEach>
		</TABLE>
	</c:if>		
</body>
</html>