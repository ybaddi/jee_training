<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
      <td> <%= u.getId() %> </td>
      <td> <%= u.getFirstname() %> </td>
      <td> <%= u.getSecondname() %> </td>
      <td> <%= u.getEmail() %> </td>
      <td> <%= u.getCreated_date() %> </td>
   </tr>
  
   <%} %>
   </tbody>
   

   </table>
</body>
</html>