import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconExample {
  public static void main(String[] args) {
   final String conStr =
     "DBURL";
   final String user = "DBUSER";
   final String pass = "DBPASSWORD";

    try {
      Connection con = DriverManager
                .getConnection(conStr, user, pass);
      System.out.println("Connection successful");
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

  }
}
