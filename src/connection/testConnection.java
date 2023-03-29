package connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class testConnection {
  public static void main(String[] args) throws SQLException {

    Connection c = ConnectionDB.getCon();
    System.out.println("Connection Done!");

    Statement st = c.createStatement();

    st.execute("create table if not exists test");

    c.close();
  }
}
