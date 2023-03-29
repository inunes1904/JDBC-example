package connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class createTablePerson {

  public static void main(String[] args) throws SQLException {

    Connection c = ConnectionDB.getCon();

    String strCreate = "Create table if not exists persons"+
      "(id int auto_increment Primary key,"+
      "name varchar(80) not null)";

    Statement st = c.createStatement();
    st.execute(strCreate);

    c.close();
  }
}
