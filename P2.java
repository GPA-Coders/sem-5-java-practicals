import java.sql.*;
import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sem-5-java", "root", "");

            Statement stat = conn.createStatement();
            ResultSet result = stat.executeQuery("SELECT * from products");

            while(result.next()){
                int id = result.getInt("Id");
                String name = result.getString("Name");
                System.out.printf("%d. %s\n", id, name);
            }

            System.out.print("\nEnter Product Id : ");
            Scanner sc = new Scanner(System.in);
            int id = sc.nextInt();

            result = stat.executeQuery("SELECT Price FROM products WHERE Id = " + id);
            while(result.next()){
                int price = result.getInt("Price");
                System.out.println("Price : " + price);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}

//1. Java Mousepad
//2. Python Wallpaper
//
//Enter Product Id : 2
//Price : 200