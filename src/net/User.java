package net;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class User
{
    public static boolean isValidUser(String uname, String password, HttpServletRequest request)
    {
        boolean isValid = false;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "skava");
            if(connection != null)
            {
                PreparedStatement ps = connection.prepareStatement("select *from admin where name=? and password=?");
                ps.setString(1, uname);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                isValid = rs.next();
            }
        }
        catch (Exception e)
        {
            System.out.println("My SQL Exception");
            e.printStackTrace();
        }
        if(isValid)
        {
            createSession(uname, request);
        }
        return isValid;
    }
    public static void createSession(String uname, HttpServletRequest request)
    {
        HttpSession session = request.getSession(true);
        session.setAttribute("user", uname);
    }
}
