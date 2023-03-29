package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ExcludePerson {
  public static void main(String[] args) throws SQLException {

    Scanner sc = new Scanner(System.in);
    Connection con = ConnectionDB.getCon();
    String sqlQuerie = "Delete from persons where id = ?";

    System.out.println("Enter the id you wanna see excluded: ");
    int id = sc.nextInt();

    PreparedStatement pst = con.prepareStatement(sqlQuerie);
    pst.setInt(1, id);

    if (pst.executeUpdate()>0){
      System.out.println("Removed person with.");
    }

    sc.close();
    con.close();
  }
}
