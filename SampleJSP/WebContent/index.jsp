<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>My First JSP Page</title>
    </head>
   <%
       int count = 3;
   %>
  <body>
  <%--sample comment --%>
  <!-- Sample comment -->
        Page Count is:  
        <% out.println(++count); %>   
  </body>
</html>