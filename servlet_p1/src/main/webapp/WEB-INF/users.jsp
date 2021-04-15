<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@page import="java.util.ArrayList" %>
  <%@page import="com.company.models.User" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

   <h1> Table of users </h1>
   
   <% ArrayList<User> users = (ArrayList) request.getAttribute("users"); %>
   
   <table border=1>
   <thead>
      <th>id</th>
      <th>First Name</th>
      <th>Second Name</th>
      <th>Email</th>
      <th>Created_at</th>
   </thead>
   <tbody>
   <% for(User u : users){ %>
   <tr>
      <td> <c:out value="u.getId()" /> </td>
      <td> <c:out value="u.getFirstname()" /> </td>
      <td> <c:out value="u.getSecondname()" /> </td>
      <td> <c:out value="u.getEmail()" /> </td>
      <td> <c:out value="u.getCreated_date()" /></td>
   </tr>
  
   <%} %>
   </tbody>
   

   </table>
</body>
</html>