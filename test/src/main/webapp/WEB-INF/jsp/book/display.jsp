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
	<c:if test="${not empty book}">
		<TABLE BORDER CELLSPACING="10" CELLPADDING="10" WIDTH="50%">
			<TR VALIGN="Top">
				<TD WIDTH="3%"><strong>Title<strong></TD>
				<TD WIDTH="20%">${book.title}</TD>
			</TR>
			<TR VALIGN="Top">
				<TD WIDTH="3%"><strong>ISBN<strong></TD>
				<TD WIDTH="20%">${book.isbn}</TD>
			</TR>
			<TR VALIGN="Top">
				<TD WIDTH="3%"><strong>Author<strong></TD>
				<TD WIDTH="20%">${book.author}</TD>
			</TR>
			<TR VALIGN="Top">
				<TD WIDTH="3%"><strong>Edition<strong></TD>
				<TD WIDTH="20%">${book.edition}</TD>
			</TR>
			<TR VALIGN="Top">
				<TD WIDTH="3%"><strong>Category<strong></TD>
				<TD WIDTH="20%">${book.category}</TD>
			</TR>
		</TABLE>
	</c:if>
	<c:if test="${not empty books}">
		<TABLE BORDER CELLSPACING="10" CELLPADDING="10" WIDTH="50%">
			<c:forEach items="${books}" var="book">
				<TR VALIGN="Top">
					<TD WIDTH="3%"><strong>Title<strong></TD>
					<TD WIDTH="20%">${book.title}</TD>
				</TR>
				<TR VALIGN="Top">
					<TD WIDTH="3%"><strong>ISBN<strong></TD>
					<TD WIDTH="20%">${book.isbn}</TD>
				</TR>
				<TR VALIGN="Top">
					<TD WIDTH="3%"><strong>Author<strong></TD>
					<TD WIDTH="20%">${book.author}</TD>
				</TR>
				<TR VALIGN="Top">
					<TD WIDTH="3%"><strong>Edition<strong></TD>
					<TD WIDTH="20%">${book.edition}</TD>
				</TR>
				<TR VALIGN="Top">
					<TD WIDTH="3%"><strong>Category<strong></TD>
					<TD WIDTH="20%">${book.category}</TD>
				</TR>
			</c:forEach>
		</TABLE>
	</c:if>		
</body>
</html>