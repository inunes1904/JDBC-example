package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonQuerieTwo {
  public static void main(String[] args) throws SQLException {

    Scanner sc = new Scanner(System.in);
    System.out.println("Insert the letter you want to search for:");
    String input = sc.nextLine();
    Connection c = ConnectionDB.getCon();

    String sql = "Select * from persons where name like ? ";

    PreparedStatement p = c.prepareStatement(sql);
    p.setString(1, input);
    ResultSet r = p.executeQuery();

    List<Person> personsList = new ArrayList<>();

    while(r.next()){
      Person new_person = new Person(
        r.getInt("id"), r.getString("name"));
      personsList.add(new_person);
    }

    for (Person per:personsList) {
      System.out.print(per.getId());
      System.out.print(" ---> ");
      System.out.print(per.getName());
      System.out.print("\n");
    }
    c.close();
    sc.close();
  }
}
