<%
    String user = (String) session.getAttribute("user");
    if(user != null)
    {
        session.invalidate();
    }
    response.sendRedirect("login.jsp");
%>
<html>
    <head>
        <title>Student logout</title>
    </head>
    <body>
<!--         <div class="formcont">
            <form action="admin/loginme" method="post">
                <div class="rowcont">
                    <span class="label">User Name</span>
                    <input name="student_name">
                </div>
                <div class="rowcont">
                    <span class="label">Password</span>
                    <input name="student_password" type="password">
                </div>
                <input type="submit" value="Login">
            </form>
        </div>
 -->    </body>
</html>