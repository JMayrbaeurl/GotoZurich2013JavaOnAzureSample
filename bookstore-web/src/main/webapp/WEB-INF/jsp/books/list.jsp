<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to our GOTOCON Bookstore Sample</title>
</head>
<body>
	<h1>Goto Conference - Azure Bookstore Sample</h1>
	<p>
		You are browsing this at <c:out value="${now}" />
	</p>
	<h2>List of books in our store:</h2>
	<table border="1" style="border-style: solid; border-color: gray;">
		<thead>
			<tr>
				<th>ISBN</th>
				<th>Title</th>
				<th>Short Description</th>
				<th>Rating</th>
				<th>Image</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${books}" var="book">
				<tr>
					<td><c:out value="${book.isbn}" /></td>
					<td><c:out value="${book.title}" /></td>
					<td><c:out value="${book.description}" /></td>
					<td><c:out value="${book.rating}" /></td>
					<td>
						<c:if test="${ book.imageUrl != null }">
							<img src="${book.imageUrl}" />
						</c:if>
						<c:if test="${ book.imageUrl == null }">
							<div style="text-align: center;">
								none
							</div>
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>