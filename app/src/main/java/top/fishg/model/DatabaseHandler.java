package top.fishg.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.io.InputStream;
import java.util.Properties;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseHandler {
  private String dbUrl = null;
  private String dbUser = null;
  private String dbPassword = null;

  public DatabaseHandler() {
    Properties props = new Properties();

    try (InputStream input = DatabaseHandler.class.getClassLoader().getResourceAsStream("db.properties")) {
      if (input == null) {
        throw new Exception("Sorry, unable to find db.properties");
      }

      props.load(input);

      this.dbUrl = props.getProperty("db.url");
      this.dbUser = props.getProperty("db.user");
      this.dbPassword = props.getProperty("db.password");

      Class.forName("com.mysql.cj.jdbc.Driver");

      System.out.println("Connecting to database...");
      try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword)) {
        System.out.println("Connected to the database successfully!");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public String getDbUrl() {
    return dbUrl;
  }

  public String getDbUser() {
    return dbUser;
  }

  public String getDbPassword() {
    return dbPassword;
  }

  public void query(String sql, ResultSetProcessor processor) {
    try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql)) {
      processor.process(rs);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @FunctionalInterface
  public interface ResultSetProcessor {
    void process(ResultSet rs) throws Exception;
  }

  public int update(String sql, Object... params) {
    try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        PreparedStatement pstmt = connection.prepareStatement(sql)) {

      for (int i = 0; i < params.length; i++) {
        pstmt.setObject(i + 1, params[i]);
      }

      return pstmt.executeUpdate();

    } catch (Exception e) {
      e.printStackTrace();
      return 0;
    }
  }
}
