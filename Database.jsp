<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Student Records</title>
</head>
<body>
    <h1>Student Records</h1>

    <%@ page import="java.sql.*" %>
    <%
        String url = "jdbc:mysql://localhost:3306/sem-5-java";
        String username = "root";
        String password = "";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            
            if (request.getParameter("action") != null) {
                if (request.getParameter("action").equals("insert")) {
                	int id = Integer.parseInt(request.getParameter("id"));
                    String name = request.getParameter("name");
                    String branch = request.getParameter("branch");
                    PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO student (id, name, branch) VALUES (?, ?, ?)");
                    preparedStatement.setInt(1, id);
                    preparedStatement.setString(2, name);
                    preparedStatement.setString(3, branch);
                    preparedStatement.executeUpdate();
                } 
                else if (request.getParameter("action").equals("update")) {
                    int id = Integer.parseInt(request.getParameter("id"));
                    String name = request.getParameter("name");
                    String branch = request.getParameter("branch");
                    PreparedStatement preparedStatement = connection.prepareStatement("UPDATE student SET name = ?, branch = ? WHERE id = ?");
                    preparedStatement.setString(1, name);
                    preparedStatement.setString(2, branch);
                    preparedStatement.setInt(3, id);
                    preparedStatement.executeUpdate();
                }
            }

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM student");
    %>

    <h2>Add New Student</h2>
    <form action="Database.jsp?action=insert" method="post">
    	ID: <input type="text" name="id"><br>
        Name: <input type="text" name="name"><br>
        Branch: <input type="text" name="branch"><br>
        <input type="submit" value="Insert">
    </form>

    <h2>Update Student</h2>
    <form action="Database.jsp?action=update" method="post">
        ID: <input type="text" name="id"><br>
        Name: <input type="text" name="name"><br>
        Branch: <input type="text" name="branch"><br>
        <input type="submit" value="Update">
    </form>

    <h2>Student Records</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Branch</th>
        </tr>
        <%
            while (resultSet.next()) {
        %>
        <tr>
            <td><%= resultSet.getInt("id") %></td>
            <td><%= resultSet.getString("name") %></td>
            <td><%= resultSet.getString("branch") %></td>
        </tr>
        <%
            }
        %>
    </table>
    <%
        resultSet.close();
        statement.close();
        connection.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    %>
</body>
</html>
