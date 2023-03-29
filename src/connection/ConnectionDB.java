package connection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionDB {
  public static Connection getCon(){
    try {
      Properties prop = getProperties();
      final String strCon = prop.getProperty("BD.URL");
      final String user = prop.getProperty("BD.USER");
      final String pw = prop.getProperty("BD.PASSWORD");
      return DriverManager.getConnection(strCon, user, pw);
    } catch (SQLException | IOException e) {
      throw new RuntimeException(e);
    }
  }

  private static Properties getProperties() throws IOException {
    Properties prop = new Properties();
    String path = "../connection.properties";
    prop.load(ConnectionDB.class.getResourceAsStream(path));
    return prop;
  }


}
