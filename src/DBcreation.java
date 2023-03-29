import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBcreation {
  public static void main(String[] args) throws SQLException {

    final String conStr =
      "DBURL";
    final String user = "DBUSER";
    final String pw = "DBPASSWORD!";

    Connection con = DriverManager.getConnection(conStr,user,pw);

    Statement st = con.createStatement();
    st.execute("create database if not exists java_course");
    System.out.println("If not created database was created");
    con.close();
  }
}
