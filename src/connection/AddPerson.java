package connection;

import javax.script.ScriptContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AddPerson {

  public static void main(String[] args) throws SQLException {

    Scanner sc = new Scanner(System.in);
    System.out.println("Enter Person name: ");
    String personName = sc.nextLine();

    Connection c = ConnectionDB.getCon();

    String sqlQuerie = String.format(
      "insert into persons (name) values ( ? )", personName
    );

    PreparedStatement st = c.prepareStatement(sqlQuerie);
    st.setString(1,personName);
    st.execute();


    System.out.println(sqlQuerie);

    sc.close();
  }
}
