package libraryBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class DatabaseConnectionController {
	private Connection connection;

	  public DatabaseConnectionController() {
	    loadDriver();
	  }

	  public void loadDriver() {
	    try {
	      Class.forName("java.sql.Driver");
	    }
	    catch (Exception exception) {
	      JOptionPane.showMessageDialog(null, "Connetion driver loading failed", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	  }

	  public void connectToDatabaseAsEmployee() {
	    try {
	      connection = DriverManager.getConnection("jdbc:mysql://localhost/biblioteca?user=employee&password=&noAccessToProcedureBodies=true&useSSL=false");
	    }
	    catch (Exception exception) {
	      JOptionPane.showMessageDialog(null, "Establising database connection failed", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	  }

	  public void connectToDatabaseAsMember() {
	    try {
	      connection = DriverManager.getConnection("jdbc:mysql://localhost/biblioteca?user=member&password=&noAccessToProcedureBodies=true&useSSL=false");
	    }
	    catch (Exception exception) {
	      JOptionPane.showMessageDialog(null, "Establising database connection failed", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	  }

	  public void deconnectFromDatabase() {
	    if (connection != null) {
	      try {
	        connection.close();
	        connection = null;
	      }
	      catch (SQLException e) {
	        JOptionPane.showMessageDialog(null, "Closing database connection failed", "Error", JOptionPane.ERROR_MESSAGE);
	      }
	    }
	  }

	  /**
	   * @return conexiune la baza de date.
	   */
	  public Connection getConnection() {
	    return connection;
	  }
	}


