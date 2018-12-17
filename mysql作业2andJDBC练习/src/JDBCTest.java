import java.sql.*;
import java.util.Scanner;

public class JDBCTest {
    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/test", "root", "root");
        Statement statement = conn.createStatement();
        Scanner sc = new Scanner(System.in);
        String sql = sc.nextLine();
        Query(statement, sql);
        //insert(statement, sql);

    }

    private static void insert(Statement statement, String sql) throws SQLException {
        int row = statement.executeUpdate(sql);
        if(row >0)
            System.out.println("增加学生信息成功");
        else{
            System.out.println("增加学生信息失败");
        }
    }

    private static void Query(Statement statement, String sql) throws SQLException {
        ResultSet result = statement.executeQuery(sql);
        while (result.next()) {
            int sid = result.getInt(1);
            int cid = result.getInt(3);
            int score = result.getInt(2);
            System.out.println(sid+" "+score+" "+cid);
        }
    }
}
