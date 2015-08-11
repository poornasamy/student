<%
    String user = (String) session.getAttribute("user");
    boolean isLoggedIn = (user != null);
    String logInfo = (isLoggedIn ? "Loggend in successfully with : " + user : "Logged out");
    if(!isLoggedIn)
    {
        response.sendRedirect("login.jsp");
    }
%>
<html>
    <head>
        <title>Student Home</title>
    </head>
    <body>
      <div><%=logInfo%></div>
    </body>
</html>