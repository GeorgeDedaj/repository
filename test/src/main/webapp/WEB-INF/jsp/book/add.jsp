<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Test Application</title>
</head>
<body>
	<form action="addBook">
	<p>
		<label for="title">Title</label>
		<input type="text" name="title"><br>
		<label for="author">Author</label>
		<input type="text" name="author"><br>
		<label for="category">Category</label>
		<input type="text" name="category"><br>
		<label for="isbn">ISBN</label>
		<input type="text" name="isbn"><br>
		<label for="edition">Edition</label>
		<input type="text" name="edition"><br>
	</p>
	<input type="submit" value="Add"><br>
	</form>
</body>
</html>