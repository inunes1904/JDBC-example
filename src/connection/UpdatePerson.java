package connection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UpdatePerson {
  public static void main(String[] args) throws SQLException {

    // create a scanner
    Scanner sc = new Scanner(System.in);
    System.out.println("Update by id (choose an id to update): ");
    int search = sc.nextInt();
    System.out.println("Choose the new name: ");
    sc.nextLine();
    String input = sc.nextLine();

    // create connection
    Connection c = ConnectionDB.getCon();
    // create a statement to avoid injections
    String sqlQuerie = "Update persons set name = ? where id = ?";
    PreparedStatement p = c.prepareStatement(sqlQuerie);
    p.setInt(2, search);
    p.setString(1, input);
    // execute the query
    p.execute();
    // show result
    String getAll = "select * from persons";
    Statement st = c.createStatement();
    ResultSet rs = st.executeQuery(getAll);

    List<Person> personsList = new ArrayList<>();

    while(rs.next()){
      int id = rs.getInt("id");
      String name = rs.getString("name");
      Person newPerson = new Person( id, name );
      personsList.add(newPerson);
    }

    personsList.forEach(x-> System.out.println(x));
    // close con and scanner
    sc.close();
    c.close();
  }
}
