<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello from JSP</title>
    <style>
        @import "../styles/main.css" screen;
    </style>
</head>
<body>
<h1>JSP</h1>

<%@page import="java.util.Date" %>
<%@ page import="logic.BusinessLogic" %>

<%Date now = new Date();%>
<%=now%>

<%
    for (int i = 0; i < 10; i++) {
        System.out.println("<p>" + "Loop number is: " + i + "</p>");
    }
%>

<%
    BusinessLogic bl = new BusinessLogic();
    System.out.println("<div><b>" + bl.getString() + "</b></div>");
%>

<%
    String name = (String)session.getAttribute("current_user");
    if (name != null) {
      System.out.println("<div><b>Hello," + name + "</b></div>");
    }
%>
</body>
</html>
