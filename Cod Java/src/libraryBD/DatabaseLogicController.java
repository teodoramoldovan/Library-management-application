package libraryBD;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class DatabaseLogicController {
	
	 private Connection connection;
	  private Statement statement;
	  private ResultSet resultSet;
	  private CallableStatement callableStatement;

	  public DatabaseLogicController(Connection connection) throws SQLException {
	    this.connection = connection;
	  }

	  public boolean verifyLogInConditionsAsEmployee(String email, String password) {
	    if ((email.equals("employee") && (password.equals("")))) {
	      return true;
	    }
	    return false;
	  }
	  //password??
	  public boolean verifyLogInConditionsAsMember(String email, String password) {
	    String query = "select adresa_email from membru where adresa_email = '" + email + "'";
	    try {
	      statement = connection.createStatement();
	      statement.execute(query);
	      resultSet = statement.getResultSet();
	      if (resultSet.next() == false) {
	        return false;
	      }
	    }
	    catch (SQLException e) {
	      JOptionPane.showMessageDialog(null, "Query for verifying client log in conditions failed", null,
	          JOptionPane.ERROR_MESSAGE);
	    }
	    return true;
	  }

	  public String insertNewMember(String lastName, String firstName, String street, Integer number, String city,
			  String job,String birthDate,String sex,String email) {
		  
		  String result = new String();
	    try {
	      callableStatement = connection.prepareCall("{call adaugare_membru_nou(?,?,?,?,?,?,?,?,?)}");
	      callableStatement.setString(1, lastName);
	      callableStatement.setString(2, firstName);
	      callableStatement.setString(3, street);
	      callableStatement.setInt(4, number);
	      callableStatement.setString(5, city);
	      callableStatement.setString(6, job);
	      callableStatement.setString(7,birthDate);
	      callableStatement.setString(8, sex);
	      callableStatement.setString(9,email);
	      callableStatement.execute();
	      resultSet = callableStatement.getResultSet();
	      if (callableStatement.getMoreResults()) {
	        resultSet = callableStatement.getResultSet();
	        resultSet.next();
	        result = resultSet.getString(1);
	      }
	    }
	    catch (SQLException e) {
	      JOptionPane.showMessageDialog(null, e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
	    }
	    return result;
	  }

	  public boolean returnBorrowedBooks(Integer memberID, Integer borrowID) {

	    try {
	      callableStatement = connection.prepareCall("{call restituire_imprumut(?, ?)}");
	      callableStatement.setInt(1, memberID);
	      callableStatement.setInt(2, borrowID);
	      callableStatement.execute();

	      int count = 1;
	      resultSet = callableStatement.getResultSet();
	      while (callableStatement.getMoreResults(Statement.KEEP_CURRENT_RESULT)) {
	        count++;
	        resultSet = callableStatement.getResultSet();
	      }
	     switch (count) {
	      case 1:
	        JOptionPane.showMessageDialog(null, "Member with id " + memberID + " does not exist in the database", null,
	            JOptionPane.ERROR_MESSAGE);
	        return false;
	      case 2:
	        JOptionPane.showMessageDialog(null, "You haven't made any borrow with id "+ borrowID, null,
	            JOptionPane.ERROR_MESSAGE);
	        return false;
	      case 4:
	        JOptionPane.showMessageDialog(null, "Return borrowed book success!", null, JOptionPane.PLAIN_MESSAGE);
	        return true;
	      default:
	        JOptionPane.showMessageDialog(null, "Error return borrowed book", null, JOptionPane.ERROR_MESSAGE);
	        return false;
	      }
	    }
	    catch (SQLException e) {
	      JOptionPane.showMessageDialog(null, "Failed", null, JOptionPane.ERROR_MESSAGE);
	    }
	    return false;
	  }

	  public boolean cancelReservation(Integer memberID, Integer reservationID) {

	    try {
	      callableStatement = connection.prepareCall("{call anulare_rezervare(?, ?)}");
	      callableStatement.setInt(1, memberID);
	      callableStatement.setInt(2, reservationID);
	      callableStatement.execute();

	      int count = 1;
	      resultSet = callableStatement.getResultSet();
	      while (callableStatement.getMoreResults(Statement.KEEP_CURRENT_RESULT)) {
	        count++;
	        resultSet = callableStatement.getResultSet();
	      }
	      switch (count) {
	      case 1:
	        JOptionPane.showMessageDialog(null, "Member with id " + memberID + " does not exist in the database", null,
	            JOptionPane.ERROR_MESSAGE);
	        return false;
	      case 2:
	        JOptionPane.showMessageDialog(null, "You haven't made any borrow with id "+ reservationID,
	            null, JOptionPane.ERROR_MESSAGE);
	        return false;
	      case 4:
	   
	          JOptionPane.showMessageDialog(null, "Cancel reservation successful!", null, JOptionPane.PLAIN_MESSAGE);
	          return true;
	        
	      default:
	        JOptionPane.showMessageDialog(null, "Error cancel reservation", null, JOptionPane.ERROR_MESSAGE);
	        return false;
	      }
	    }
	    catch (SQLException e) {
	      JOptionPane.showMessageDialog(null, e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
	    }
	    return false;
	  }

	  public boolean insertNewBorrow(Integer memberID, Integer bookISBN) {

	    try {
	      callableStatement = connection.prepareCall("{call adaugare_imprumut_nou(?,?)}");
	      callableStatement.setInt(1, memberID);
	      callableStatement.setInt(2, bookISBN);
	      callableStatement.execute();

	      int count = 1;
	      resultSet = callableStatement.getResultSet();
	      while (callableStatement.getMoreResults(Statement.KEEP_CURRENT_RESULT)) {
	        count++;
	        resultSet = callableStatement.getResultSet();
	      }
	      switch (count) {
	      case 1:
	        JOptionPane.showMessageDialog(null, "Member with id " + memberID + " does not exist in the database", null,
	            JOptionPane.ERROR_MESSAGE);
	        return false;
	      case 2:
	        JOptionPane.showMessageDialog(null, "Book with isbn " + bookISBN + " does not exist in the database", null,
	            JOptionPane.ERROR_MESSAGE);
	        return false;
	      case 3:
		        JOptionPane.showMessageDialog(null, "Book with isbn " + bookISBN + " is not available", null,
		            JOptionPane.ERROR_MESSAGE);
		        return false;
	      case 4:
	          JOptionPane.showMessageDialog(null, "Succesful borrow!", null, JOptionPane.PLAIN_MESSAGE);
	          return true;
	      default:
	        JOptionPane.showMessageDialog(null, "Error inserting new borrow", null, JOptionPane.ERROR_MESSAGE);
	        return false;
	      }
	    }
	    catch (SQLException e) {
	      JOptionPane.showMessageDialog(null, e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
	    }
	    return false;
	  }

	  public boolean insertNewPrinted(Integer bookISBN, String language, Integer numberOfCopies, Integer availableNumberOfCopies,
	      String category, String status, String locationInLibrary,Double penaltyCharge,Integer literaryWork,String publishingHouse) {

	    try {
	      callableStatement = connection.prepareCall("{call adaugare_tiparita(?,?,?,?,?,?,?,?,?,?)}");
	      callableStatement.setInt(1, bookISBN);
	      callableStatement.setString(2, language);
	      callableStatement.setInt(3, numberOfCopies);
	      callableStatement.setInt(4, availableNumberOfCopies);
	      callableStatement.setString(5, category);
	      callableStatement.setString(6, status);
	      callableStatement.setString(7, locationInLibrary);
	      callableStatement.setDouble(8, penaltyCharge);
	      callableStatement.setInt(9, literaryWork);
	      callableStatement.setString(10,publishingHouse);
	      callableStatement.execute();

	      int count = 1;
	      resultSet = callableStatement.getResultSet();
	      while (callableStatement.getMoreResults(Statement.KEEP_CURRENT_RESULT)) {
	        count++;
	        resultSet = callableStatement.getResultSet();
	      }
	      switch (count) {
	      case 1:
	        
	          JOptionPane.showMessageDialog(null, "Book with ISBN: " + bookISBN + " already exists in the database", null,
	              JOptionPane.ERROR_MESSAGE);
	          return false;

	      case 2:
	        JOptionPane.showMessageDialog(null, "Literary Work with ID: " + literaryWork + " does not exist in the database", null,
	            JOptionPane.ERROR_MESSAGE);
	        return false;
	      case 3:
	    	  JOptionPane.showMessageDialog(null, "Succes inserting new printed book", null,
	  	            JOptionPane.ERROR_MESSAGE);
	  	        return false;
	    	  
	      default:
	        JOptionPane.showMessageDialog(null, "Error insert new printed book", null, JOptionPane.ERROR_MESSAGE);
	        return false;
	      }
	    }
	    catch (SQLException e) {
	      JOptionPane.showMessageDialog(null, e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
	    }
	    return false;
	  }

	  public boolean insertNewManuscript(Integer bookISBN, String language, Integer numberOfCopies, Integer availableNumberOfCopies,
		      String category, String status, String locationInLibrary,Double penaltyCharge,Integer literaryWork,String year) {

	    try {
	    	callableStatement = connection.prepareCall("{call adaugare_manuscris(?,?,?,?,?,?,?,?,?,?)}");
		      callableStatement.setInt(1, bookISBN);
		      callableStatement.setString(2, language);
		      callableStatement.setInt(3, numberOfCopies);
		      callableStatement.setInt(4, availableNumberOfCopies);
		      callableStatement.setString(5, category);
		      callableStatement.setString(6, status);
		      callableStatement.setString(7, locationInLibrary);
		      callableStatement.setDouble(8, penaltyCharge);
		      callableStatement.setInt(9, literaryWork);
		      callableStatement.setString(10,year);
		      callableStatement.execute();

	      int count = 1;
	      resultSet = callableStatement.getResultSet();
	      while (callableStatement.getMoreResults(Statement.KEEP_CURRENT_RESULT)) {
	        count++;
	        resultSet = callableStatement.getResultSet();
	      }
	      switch (count) {
	      case 1:
	        
	          JOptionPane.showMessageDialog(null, "Book with ISBN: " + bookISBN + " already exists in the database", null,
	              JOptionPane.ERROR_MESSAGE);
	          return false;

	      case 2:
	        JOptionPane.showMessageDialog(null, "Literary Work with ID: " + literaryWork + " does not exist in the database", null,
	            JOptionPane.ERROR_MESSAGE);
	        return false;
	      case 3:
	    	  JOptionPane.showMessageDialog(null, "Succes inserting new manuscript", null,
	  	            JOptionPane.ERROR_MESSAGE);
	  	        return false;
	    	  
	      default:
	        JOptionPane.showMessageDialog(null, "Error insert new manuscript", null, JOptionPane.ERROR_MESSAGE);
	        return false;
	      }
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	      JOptionPane.showMessageDialog(null, e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
	    }
	    return false;
	  }

	  public boolean insertNewReservation(Integer memberID, Integer bookISBN) {
	    try {
	      callableStatement = connection.prepareCall("{call adaugare_rezervare_noua(?,?)}");
	      callableStatement.setInt(1, memberID);
	      callableStatement.setInt(2, bookISBN);
	      callableStatement.execute();

	      int count = 1;
	      resultSet = callableStatement.getResultSet();
	      while (callableStatement.getMoreResults(Statement.KEEP_CURRENT_RESULT)) {
	        count++;
	        resultSet = callableStatement.getResultSet();
	      }
	      switch (count) {
	      case 2:
	        JOptionPane.showMessageDialog(null, "Member with ID: " + memberID + " does not exist in the database", null,
	            JOptionPane.ERROR_MESSAGE);
	        return false;
	      case 3:
	        JOptionPane.showMessageDialog(null, "Book with ISBN: " + bookISBN + " does not exist in the database", null,
	            JOptionPane.ERROR_MESSAGE);
	      case 4:
	        resultSet.next();
	        String result = resultSet.getString(1);
	        if (result.equals("Suportul media cu id-ul " + bookISBN + " este deja imprumutat")) {
	          JOptionPane.showMessageDialog(null, "Book with ISBN: " + bookISBN + " already borrowed", null,
	              JOptionPane.ERROR_MESSAGE);
	          return false;
	        }
	        else {
	          JOptionPane.showMessageDialog(null, "Succesfull reservation", null, JOptionPane.PLAIN_MESSAGE);
	          return true;
	        }
	      default:
	        JOptionPane.showMessageDialog(null, "Error insert new reserevation", null, JOptionPane.ERROR_MESSAGE);
	        return false;
	      }
	    }
	    catch (SQLException e) {
	      JOptionPane.showMessageDialog(null, e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
	    }
	    return false;
	  }

	  public boolean insertNewLiteraryWork(String title, String author) {
	    try {
	      callableStatement = connection.prepareCall("{call adaugare_opera(?,?)}");
	      callableStatement.setString(1, title);
	      callableStatement.setString(2,author);
	      callableStatement.execute();

	      int count = 1;
	      resultSet = callableStatement.getResultSet();
	      while (callableStatement.getMoreResults(Statement.KEEP_CURRENT_RESULT)) {
	        count++;
	        resultSet = callableStatement.getResultSet();
	      }
	      switch (count) {
	      case 1:
	        JOptionPane.showMessageDialog(null, "Success insert new literary work!", null, JOptionPane.PLAIN_MESSAGE);
	        return true;
	      default:
	        JOptionPane.showMessageDialog(null, "Error insert new literary work", null, JOptionPane.ERROR_MESSAGE);
	        return false;
	      }
	    }
	    catch (SQLException e) {
	      JOptionPane.showMessageDialog(null, e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
	    }
	    return false;
	  }
	  
	  public boolean insertNewAcces(Integer memberID, Integer studyRoomID,Integer employeeID) {

		    try {
		      callableStatement = connection.prepareCall("{call adaugare_acces(?,?,?)}");
		      callableStatement.setInt(1, memberID);
		      callableStatement.setInt(2, studyRoomID);
		      callableStatement.setInt(3, employeeID);
		      callableStatement.execute();

		      int count = 1;
		      resultSet = callableStatement.getResultSet();
		      while (callableStatement.getMoreResults(Statement.KEEP_CURRENT_RESULT)) {
		        count++;
		        resultSet = callableStatement.getResultSet();
		      }
		      switch (count) {
		      
		      case 3:
		          JOptionPane.showMessageDialog(null, "Succesful access entry!", null, JOptionPane.PLAIN_MESSAGE);
		          return true;
		      default:
		        JOptionPane.showMessageDialog(null, "Error inserting new access entry", null, JOptionPane.ERROR_MESSAGE);
		        return false;
		      }
		    }
		    catch (SQLException e) {
		      JOptionPane.showMessageDialog(null, e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
		    }
		    return false;
		  }

	  public ResultSet showMyID(String email) {
	    String query = "select membru.id_membru from membru where membru.adresa_email = " + "'" + email + "';";
	    try {
	      statement = connection.createStatement();
	      resultSet = statement.executeQuery(query);
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	      JOptionPane.showMessageDialog(null, "Show my id query failed!", null, JOptionPane.ERROR_MESSAGE);
	    }
	    return resultSet;
	  }

	  public ResultSet showLiteraryWorkInformation() {
	    String query = "select * from opera";
	    try {
	      statement = connection.createStatement();
	      resultSet = statement.executeQuery(query);
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	      JOptionPane.showMessageDialog(null, "Show literary works information query failed!", null, JOptionPane.ERROR_MESSAGE);
	    }
	    return resultSet;
	  }

	  public ResultSet showPrintedInfo() {
	    String query = "select * from Informatii_tiparite";
	    try {
	      statement = connection.createStatement();
	      resultSet = statement.executeQuery(query);
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	      JOptionPane.showMessageDialog(null, "Show printed books information query failed!", null, JOptionPane.ERROR_MESSAGE);
	    }
	    return resultSet;
	  }

	  public ResultSet showManuscriptInfo() {
	    String query = "select * from Informatii_manuscrise";
	    try {
	      statement = connection.createStatement();
	      resultSet = statement.executeQuery(query);
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	      JOptionPane.showMessageDialog(null, "Show manuscripts information query failed!", null, JOptionPane.ERROR_MESSAGE);
	    }
	    return resultSet;
	  }

	  public ResultSet showReservationsInfo() {
	    String query = "select * from Rezervari";
	    try {
	      statement = connection.createStatement();
	      resultSet = statement.executeQuery(query);
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	      JOptionPane.showMessageDialog(null, "Show reservations information query failed!", null,
	          JOptionPane.ERROR_MESSAGE);
	    }
	    return resultSet;
	  }

	  public ResultSet showMembersInfo() {
	    String query = "select * from Informatii_membrii";
	    try {
	      statement = connection.createStatement();
	      resultSet = statement.executeQuery(query);
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	      JOptionPane.showMessageDialog(null, "Show members information query failed!", null, JOptionPane.ERROR_MESSAGE);
	    }
	    return resultSet;
	  }

	  public ResultSet showBorrowHistoryInformation() {
	    String query = "select * from Istoric";
	    try {
	      statement = connection.createStatement();
	      resultSet = statement.executeQuery(query);
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	      JOptionPane.showMessageDialog(null, "Show borrow history information query failed!", null,
	          JOptionPane.ERROR_MESSAGE);
	    }
	    return resultSet;
	  }

	  public ResultSet showBorrowedBooksInformation() {
	    String query = "select * from Imprumuturi";
	    try {
	      statement = connection.createStatement();
	      resultSet = statement.executeQuery(query);
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	      JOptionPane.showMessageDialog(null, "Show borrowed books query failed!", null, JOptionPane.ERROR_MESSAGE);
	    }
	    return resultSet;
	  }

	  public ResultSet showBookInfo() {
	    String query = "select * from Carti";
	    try {
	      statement = connection.createStatement();
	      resultSet = statement.executeQuery(query);
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	      JOptionPane.showMessageDialog(null, "Show books information query failed!", null, JOptionPane.ERROR_MESSAGE);
	    }
	    return resultSet;
	  }
	  public ResultSet showStudyRoomInfo() {
		  String query="select * from  sala_studiu";
		  try {
		      statement = connection.createStatement();
		      resultSet = statement.executeQuery(query);
		    }
		    catch (SQLException e) {
		      e.printStackTrace();
		      JOptionPane.showMessageDialog(null, "Show study rooms information query failed!", null, JOptionPane.ERROR_MESSAGE);
		    }
		    return resultSet;
	  }
	  
	  public ResultSet showEmployeeInfo() {
		  String query="select id_angajat,nume,prenume from angajat";
		  try {
		      statement = connection.createStatement();
		      resultSet = statement.executeQuery(query);
		    }
		    catch (SQLException e) {
		      e.printStackTrace();
		      JOptionPane.showMessageDialog(null, "Show employee information query failed!", null, JOptionPane.ERROR_MESSAGE);
		    }
		    return resultSet;
	  }
	  public ResultSet showEventInfo() {
		  String query="select * from eveniment";
		  try {
		      statement = connection.createStatement();
		      resultSet = statement.executeQuery(query);
		    }
		    catch (SQLException e) {
		      e.printStackTrace();
		      JOptionPane.showMessageDialog(null, "Show event information query failed!", null, JOptionPane.ERROR_MESSAGE);
		    }
		    return resultSet;
	  }
	  
	  public ResultSet showAccessInStudyRoomInfo() {
		  String query="select * from Informatii_acces";
		  try {
		      statement = connection.createStatement();
		      resultSet = statement.executeQuery(query);
		    }
		    catch (SQLException e) {
		      e.printStackTrace();
		      JOptionPane.showMessageDialog(null, "Show acces in study room information query failed!", null, JOptionPane.ERROR_MESSAGE);
		    }
		    return resultSet;
	  }

	  public ResultSet showParticularBooksInfo(String title) {
	    String query = "select * from Carti where Carti.titlu like " + "'%" + title
	        + "%';";
	    try {
	      statement = connection.createStatement();
	      resultSet = statement.executeQuery(query);
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	      JOptionPane.showMessageDialog(null, "Show particular books information query failed!", null,
	          JOptionPane.ERROR_MESSAGE);
	    }
	    return resultSet;
	  }

	  public Integer getMyId(String logInEmail) {
	    String query = "select membru.id_membru from membru where membru.adresa_email = '" + logInEmail + "';";
	    String result = new String();
	    try {
	      statement = connection.createStatement();
	      resultSet = statement.executeQuery(query);
	      resultSet.next();
	      result = resultSet.getString(1);
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	      JOptionPane.showMessageDialog(null, "Show particular books information query failed!", null,
	          JOptionPane.ERROR_MESSAGE);
	    }
	    return Integer.parseInt(result);
	  }

}
