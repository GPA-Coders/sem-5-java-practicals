import java.sql.*;

public class P1 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sem-5-java", "root", "");

            Statement stat = conn.createStatement();

            System.out.println("Current Rows in Table");
            getRows(stat);

            int insert = stat.executeUpdate("INSERT INTO Student VALUES(4, 'No Student', 'Computer')");
            if (insert == 1) {
                System.out.println("Inserted successfully");
            } else {
                System.out.println("Insert failed");
            }

            System.out.println("Rows after insertion");
            getRows(stat);

            int delete = stat.executeUpdate("DELETE FROM Student WHERE Id = 4");
            if (delete == 1) {
                System.out.println("Deleted successfully");
            } else {
                System.out.println("Delete failed");
            }

            System.out.println("Rows after deletion");
            getRows(stat);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static void getRows(Statement stat) {
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM Student");

            while (result.next()) {
                int id = result.getInt("Id");
                String name = result.getString("Name");
                String branch = result.getString("Branch");
                System.out.printf("Id : %d Name : %s Branch : %s%n", id
                        , name, branch);
            }
            System.out.println();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
}
