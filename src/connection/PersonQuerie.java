package connection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonQuerie {

  public static void main(String[] args) throws SQLException {

    Connection c = ConnectionDB.getCon();

    String sql = "select * from persons";

    Statement st = c.createStatement();

    ResultSet result = st.executeQuery(sql);

    List<Person> personsList = new ArrayList<>();

    while(result.next()){
      int id = result.getInt("id");
      String name = result.getString("name");
      personsList.add(new Person(id, name));
    }
    personsList.forEach(
      p -> System.out.println(p.toString())
    );
    c.close();
  }
}
