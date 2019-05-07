package libraryBD;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;


public class ApplicationLogicController {
	
	
	  private DatabaseConnectionController databaseConnectionController;
	  private DatabaseLogicController databaseLogicController;
	  private GraphicController graphicController;
	  private boolean connectedAsEmployee;
	  private String logInEmail;
	  private Integer loggedMemberID;

	  public ApplicationLogicController() {
	    // connect to database
	    databaseConnectionController = new DatabaseConnectionController();

	    // show GUI
	    graphicController = new GraphicController();
	    displayMainFrame();
	    displayDatabaseConnectionView();
	  }

	  private void displayMainFrame() {
	    SwingUtilities.invokeLater(new Runnable() {

	      @Override
	      public void run() {
	        graphicController.showMainframe();
	      }
	    });
	  }

	  private void displayDatabaseConnectionView() {
	    SwingUtilities.invokeLater(new Runnable() {

	      @Override
	      public void run() {
	        graphicController.showDatabaseConnectionView();
	        addDatabaseConnectionViewConnectAsMemberButtonActionListener();
	        addDatabaseConnectionConnectAsEmployeeActionListener();
	      }
	    });
	  }

	  private void displayLogInView() {
	    SwingUtilities.invokeLater(new Runnable() {

	      @Override
	      public void run() {
	        graphicController.showLogInView();
	        addLogInViewCancelButtonActionListener();
	        addLogInViewLogInButtonActionListener();
	      }
	    });
	  }

	  private void displayStartApplicationView() {
	    if (!connectedAsEmployee) {
	      loggedMemberID = databaseLogicController.getMyId(logInEmail);
	    }
	    String[] columnNames = { "ISBN", "Title", "Author", "Category", "Status", "Location in Library", "Penalty charge" };
	    ResultSet resultSet = databaseLogicController.showBookInfo();
	    String[][] data = parseBookResultSet(resultSet, 70, 7);

	    SwingUtilities.invokeLater(new Runnable() {

	      @Override
	      public void run() {
	        graphicController.showStartApplicationView(data, columnNames);
	        addStartApplicationviewSearchButtonActionListener();
	        addStartApplicationViewSearchTextFieldKeyListener();
	        addStartApplicationViewShowMyIdButtonActionListener();
	        addStartApplicationViewBorrowBookButtonActionListener();
	        addStartApplicationViewMakeReservationButtonActionListener();
	        addStartApplicationViewShowBookInformationButtonActionListener();
	        addStartApplicationViewShowPrintedInformationButtonActionListener();
	        addStartApplicationViewShowManuscriptInformationButtonActionListener();
	        addStartApplicationViewShowReservationInformationActionListener();
	        addStartApplicationViewShowBorrowedBooksInformationButtonActionListener();
	        addStartApplicationViewShowMembersInformationButtonActionListener();
	        addStartApplicationViewShowBorrowHistoryInformationActionListener();
	        addStartApplicationViewReturnBorrowedBooksButtonActionListener();
	        addStartApplicationViewCancelReservationButtonActionListener();
	        addStartApplicationViewNewMemberButtonActionListener();
	        addStartApplicationViewNewLiteraryWorkButtonActionListener();
	        addStartApplicationViewNewPrintedButtonActionListener();
	        addStartApplicationViewNewManuscriptButtonActionListener();
	        addStartApplicationViewStudyRoomButtonActionListener();
	        addStartApplicationViewEmployeeInformationButtonActionListener();
	        addStartApplicationViewEventInformationButtonActionListener();
	        addStartApplicationViewAccessInStudyRoomInformationButtonActionListener();
	        addStartApplicationViewAddMemberInStudyRoomButtonActionListener();
	        
	      }
	    });
	  }

	  private void displayBorrowBooksView() {
	    SwingUtilities.invokeLater(new Runnable() {

	      @Override
	      public void run() {
	        graphicController.showBorrowBooksView();
	        addBorrowBooksViewCancelButtonActionListener();
	        addBorrowBooksViewCreateBorrowButtonActionListener();
	      }
	    });
	  }

	  private void displayReservationView() {
	    SwingUtilities.invokeLater(new Runnable() {

	      @Override
	      public void run() {
	        graphicController.showReservationView();
	       addReservationViewCancelButtonActionListener();
	       addReservationViewMakeReservationButtonActionListener();
	      }
	    });
	  }

	  private void displayBooksInformationView() {
	    String[] columnNames = { "ISBN", "Title", "Author" };
	    ResultSet resultSet = databaseLogicController.showLiteraryWorkInformation();
	    String[][] data = parseLiteraryWorkResultSet(resultSet, 0, 3);
	    SwingUtilities.invokeLater(new Runnable() {

	      @Override
	      public void run() {
	       graphicController.showBooksInformationView(data, columnNames);
	      }
	    });
	  }

	  private void displayPrintedInformationView() {
	    String[] columnNames = { "Title", "Author", "Language", "Total Number Of Copies", "Available Number Of Copies", "Category",
	    		"Location In Library","Penalty Charge","Publishing House"};
	    ResultSet resultSet = databaseLogicController.showPrintedInfo();
	   String[][] data = parsePrintedOrManuscriptResultSet(resultSet, 0, 9);
	    SwingUtilities.invokeLater(new Runnable() {

	      @Override
	      public void run() {
	        graphicController.showPrintedInformationView(data, columnNames);
	      }
	    });
	  }

	  private void displayManuscriptInformationView() {
	    String[] columnNames = { "Title", "Author", "Language", "Total Number Of Copies", "Available Number Of Copies", "Category",
	    		"Location In Library","Penalty Charge","Publishing Year" };
	    ResultSet resultSet = databaseLogicController.showManuscriptInfo();
	    String[][] data = parsePrintedOrManuscriptResultSet(resultSet, 0, 9);
	    SwingUtilities.invokeLater(new Runnable() {

	      @Override
	      public void run() {
	        graphicController.showManuscriptInformationView(data, columnNames);
	      }
	    });
	  }

	  private void displayReservationInformationView() {
	    String[] columnNames = { "Reservation ID", "From", "To", "Last Name", "First Name", "Title","Author" };
	    ResultSet resultSet = databaseLogicController.showReservationsInfo();
	    String[][] data = parseReservationInformationResultSet(resultSet, 0, 7);
	    SwingUtilities.invokeLater(new Runnable() {

	      @Override
	      public void run() {
	        graphicController.showReservationInformationView(data, columnNames);
	      }
	    });
	  }

	  private void displayMembersInformationView() {
	    String[] columnNames = { "Member ID", "Last Name","First Name","Job", "Email" };
	    ResultSet resultSet = databaseLogicController.showMembersInfo();
	    String[][] data = parseMemberInformationResultSet(resultSet, 0, 5);
	    SwingUtilities.invokeLater(new Runnable() {

	      @Override
	      public void run() {
	        graphicController.showMembersInformationView(data, columnNames);
	      }
	    });
	  }

	  private void displayBorrowHistoryInformationView() {
	    String[] columnNames = { "ID", "Return date", "Last Name", "First Name", "Title","Author" };
	    ResultSet resultSet = databaseLogicController.showBorrowHistoryInformation();
	    String[][] data = parseBorrowHistoryInformation(resultSet, 0, 6);
	    SwingUtilities.invokeLater(new Runnable() {

	      @Override
	      public void run() {
	        graphicController.showBorrowHistoryInformationView(data, columnNames);
	      }
	    });
	  }

	  private void displayBorrowedBooksInformationView() {
	    String[] columnNames = { "ID", "From", "To", "First Name","Last Name","Title", "Author" };
	    ResultSet resultSet = databaseLogicController.showBorrowedBooksInformation();
	    String[][] data = parseBorrowedBooksResultSet(resultSet, 0, 7);
	    SwingUtilities.invokeLater(new Runnable() {

	      @Override
	      public void run() {
	        graphicController.showBorrowedBooksInformationView(data, columnNames);
	      }
	    });
	  }

	  private void displayReturnBorrowedBooksView() {
	    SwingUtilities.invokeLater(new Runnable() {

	      @Override
	      public void run() {
	        graphicController.showReturnBorrowedBooksView();
	        addReturnBorrowedBooksViewCancelButtonActionListener();
	        addReturnBorrowedBooksViewReturnBorrowedBooksButtonActionListener();
	      }
	    });
	  }

	  private void displayCancelReservationView() {
	    SwingUtilities.invokeLater(new Runnable() {

	      @Override
	      public void run() {
	        graphicController.showCancelReservationView();
	        addCancelReservationCancelButtonActionListener();
	       addCancelReservationCancelReservationButtonActionListener();
	      }
	    });
	  }

	  private void displayNewMemberView() {
	    SwingUtilities.invokeLater(new Runnable() {

	      @Override
	      public void run() {
	        graphicController.showNewMemberView();
	       addNewMemberViewCancelButtonActionListener();
	        addNewMemberViewAddAccountButtonActionListener();
	      }
	    });
	  }

	  private void displayNewLiteraryWorkView() {
	    SwingUtilities.invokeLater(new Runnable() {

	      @Override
	      public void run() {
	        graphicController.showNewLiteraryWorkView();
	        addNewLiteraryWorkViewCancelButtonActionListener();
	        addNewLiteraryWorkViewInsertLiteraryWorkButtonActionListener();
	      }
	    });
	  }

	  private void displayNewPrintedView() {
	    SwingUtilities.invokeLater(new Runnable() {

	      @Override
	      public void run() {
	        graphicController.showNewPrintedView();
	        addNewPrintedviewCancelButtonActionListener();
	        addNewPrintedViewInsertPrintedActionListener();
	      }
	    });
	  }

	  private void displayNewManuscriptView() {
	    SwingUtilities.invokeLater(new Runnable() {

	      @Override
	      public void run() {
	        graphicController.showNewManuscriptView();
	        addNewManuscriptViewCancelButtonActionListener();
	        addNewManuscriptViewInsertManuscriptButtonActionListener();
	      }
	    });
	  }
	  private void displayStudyRoomView() {
		  String[] columnNames = { "Room Number", "Floor", "Name", "Number of Seats","Number of available Seats"};
		    ResultSet resultSet = databaseLogicController.showStudyRoomInfo();
		    String[][] data = parseStudyRoomResultSet(resultSet, 0, 5);
		    SwingUtilities.invokeLater(new Runnable() {

		      @Override
		      public void run() {
		        graphicController.showStudyRoomView(data,columnNames);
		      }
		    });
	  }
	  
	  private void displayEmployeeInformationView() {
		  String[] columnNames = { "ID", "Last Name", "First Name"};
		    ResultSet resultSet = databaseLogicController.showEmployeeInfo();
		    String[][] data = parseEmployeeInformationResultSet(resultSet, 0, 3);
		    SwingUtilities.invokeLater(new Runnable() {

		      @Override
		      public void run() {
		        graphicController.showEmployeeInformationView(data,columnNames);
		      }
		    });
	  }
	  private void displayEventInformationView() {
		  String[] columnNames = { "ID", "Name", "From","To","Field"};
		    ResultSet resultSet = databaseLogicController.showEventInfo();
		    String[][] data = parseEventInformationResultSet(resultSet, 0, 5);
		    SwingUtilities.invokeLater(new Runnable() {

		      @Override
		      public void run() {
		        graphicController.showEventInformationView(data,columnNames);
		      }
		    });
	  }
	  
	  private void displayAccessInStudyRoomInformationView() {
		  String[] columnNames = { "Member Last Name", "Member First Name", "Study Room ID","Employee Last Name",
				  "Employee First Name","Access Date"};
		    ResultSet resultSet = databaseLogicController.showAccessInStudyRoomInfo();
		    String[][] data = parseAccesInformationResultSet(resultSet, 0, 6);
		    SwingUtilities.invokeLater(new Runnable() {

		      @Override
		      public void run() {
		        graphicController.showAccessInStudyRoomInformationView(data,columnNames);
		      }
		    });
	  }
	  
	  private void displayAddMemberInStudyRoomView() {
		    SwingUtilities.invokeLater(new Runnable() {

		      @Override
		      public void run() {
		        graphicController.showAddMemberInStudyRoomView();
		        addAddMemberInStudyRoomViewCancelButtonActionListener();
		        addAddMemberInStudyRoomViewCreateAccessButtonActionListener();
		      }
		    });
		  }

	  private void addDatabaseConnectionViewConnectAsMemberButtonActionListener() {
	    graphicController.getDatabaseConnectionView().addConnectAsMemberButtonActionListener(new ActionListener() {

	      @Override
	      public void actionPerformed(ActionEvent e) {
	        databaseConnectionController.connectToDatabaseAsMember();
	        try {
	          databaseLogicController = new DatabaseLogicController(databaseConnectionController.getConnection());
	        }
	        catch (SQLException exception) {
	          JOptionPane.showMessageDialog(null, "Database Logic Controller initialization failed", null,
	              JOptionPane.ERROR_MESSAGE);
	        }
	        connectedAsEmployee = false;
	        displayLogInView();
	      }
	    });
	  }

	  private void addDatabaseConnectionConnectAsEmployeeActionListener() {
	    graphicController.getDatabaseConnectionView().addConnectAsEmployeeButtonActionListener(new ActionListener() {

	      @Override
	      public void actionPerformed(ActionEvent e) {
	        databaseConnectionController.connectToDatabaseAsEmployee();
	        try {
	          databaseLogicController = new DatabaseLogicController(databaseConnectionController.getConnection());
	        }
	        catch (SQLException exception) {
	          JOptionPane.showMessageDialog(null, "Database Logic Controller initialization failed", null,
	              JOptionPane.ERROR_MESSAGE);
	        }
	        connectedAsEmployee = true;
	        displayLogInView();
	      }
	    });
	  }

	  private void addLogInViewCancelButtonActionListener() {
	    graphicController.getLogInView().addCancelButtonActionListener(new ActionListener() {

	      @Override
	      public void actionPerformed(ActionEvent e) {
	        displayDatabaseConnectionView();
	      }
	    });
	  }

	  private void addLogInViewLogInButtonActionListener() {
	    graphicController.getLogInView().addLogInButtonActionListener(new ActionListener() {

	      @Override
	      public void actionPerformed(ActionEvent e) {
	        logInEmail = graphicController.getLogInView().getEmailTextField().getText();
	        String email = graphicController.getLogInView().getEmailTextField().getText();
	        String password = graphicController.getLogInView().getPasswordTextField().getText();

	        if (connectedAsEmployee) {
	          if (databaseLogicController.verifyLogInConditionsAsEmployee(email, password)) {
	            displayStartApplicationView();
	          }
	          else {
	            JOptionPane.showMessageDialog(null, "Employee data is incorrect", null,
	                JOptionPane.PLAIN_MESSAGE);
	          }
	        }
	        else {
	          if (databaseLogicController.verifyLogInConditionsAsMember(email, password)) {
	            displayStartApplicationView();
	          }
	          else {
	            JOptionPane.showMessageDialog(null, "Member data is incorrect", null, JOptionPane.PLAIN_MESSAGE);
	          }
	        }
	      }
	    });
	  }

	  private void addStartApplicationviewSearchButtonActionListener() {
	    graphicController.getStartApplicationView().addSearchButtonActionListener(new ActionListener() {

	      @Override
	      public void actionPerformed(ActionEvent e) {
	        graphicController.getStartApplicationView().getBookTable().setModel(createNewAbstractTableModel());
	      }
	    });
	  }

	  private void addStartApplicationViewSearchTextFieldKeyListener() {
	    graphicController.getStartApplicationView().addSearchtextFieldKeyListener(new KeyAdapter() {
	      @Override
	      public void keyReleased(KeyEvent arg) {
	        graphicController.getStartApplicationView().getBookTable().setModel(createNewAbstractTableModel());
	      }
	    });
	  }

	  private void addStartApplicationViewShowMyIdButtonActionListener() {
	    graphicController.getStartApplicationView().addShowMyIdButtonActionListener(new ActionListener() {

	      @Override
	      public void actionPerformed(ActionEvent e) {
	        if (connectedAsEmployee) {
	        	
	          JOptionPane.showMessageDialog(null, "You are connected as employee!", null, JOptionPane.PLAIN_MESSAGE);
	          
	        }
	        else {
	          ResultSet resultSet = databaseLogicController.showMyID(logInEmail);
	          try {
	            resultSet.next();
	            JOptionPane.showMessageDialog(null, resultSet.getString(1));
	          }
	          catch (SQLException e1) {
	            e1.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Show my id query failed", null, JOptionPane.ERROR_MESSAGE);
	          }
	        }
	      }
	    });
	  }

	  private void addStartApplicationViewBorrowBookButtonActionListener() {
	    graphicController.getStartApplicationView().addBorrowBooksButtonActionListener(new ActionListener() {

	      @Override
	      public void actionPerformed(ActionEvent e) {
	        if (connectedAsEmployee) {
	          JOptionPane.showMessageDialog(null, "You are connected as employee!", null, JOptionPane.PLAIN_MESSAGE);
	        }
	        else {
	          displayBorrowBooksView();
	        }
	      }
	    });
	  }

	  private void addStartApplicationViewMakeReservationButtonActionListener() {
	    graphicController.getStartApplicationView().addMakeReservationButtonActionListener(new ActionListener() {

	      @Override
	      public void actionPerformed(ActionEvent e) {
	        if (connectedAsEmployee) {
	          JOptionPane.showMessageDialog(null, "You are connected as employee!", null, JOptionPane.PLAIN_MESSAGE);
	        }
	        else {
	          displayReservationView();
	        }
	      }
	    });
	  }

	  private void addStartApplicationViewShowBookInformationButtonActionListener() {
	    graphicController.getStartApplicationView().addShowBooksInformationButtonActionListener(new ActionListener() {

	      @Override
	      public void actionPerformed(ActionEvent e) {
	        displayBooksInformationView();
	      }
	    });
	  }

	  private void addStartApplicationViewShowPrintedInformationButtonActionListener() {
	    graphicController.getStartApplicationView().addShowPrintedInformationButtonActionListener(new ActionListener() {

	      @Override
	      public void actionPerformed(ActionEvent e) {
	        displayPrintedInformationView();
	      }
	    });
	  }

	  private void addStartApplicationViewShowManuscriptInformationButtonActionListener() {
	    graphicController.getStartApplicationView().addShowManuscriptInformationButtonActionListener(new ActionListener() {

	      @Override
	      public void actionPerformed(ActionEvent e) {
	        displayManuscriptInformationView();
	      }
	    });
	  }

	  private void addStartApplicationViewShowReservationInformationActionListener() {
	    graphicController.getStartApplicationView().addShowReservationsActionListener(new ActionListener() {

	      @Override
	      public void actionPerformed(ActionEvent e) {
	        displayReservationInformationView();
	      }
	    });
	  }

	  private void addStartApplicationViewShowBorrowedBooksInformationButtonActionListener() {
	    graphicController.getStartApplicationView().addShowAllBooksBorrowsButton(new ActionListener() {

	      @Override
	      public void actionPerformed(ActionEvent e) {
	        displayBorrowedBooksInformationView();
	      }
	    });
	  }

	  private void addStartApplicationViewShowMembersInformationButtonActionListener() {
	    graphicController.getStartApplicationView().addShowMembersInformationButtonActionListener(new ActionListener() {

	      @Override
	      public void actionPerformed(ActionEvent e) {
	        displayMembersInformationView();
	      }
	    });
	  }

	  private void addStartApplicationViewShowBorrowHistoryInformationActionListener() {
	    graphicController.getStartApplicationView().addShowBorrowHistoryButtonActionListener(new ActionListener() {

	      @Override
	      public void actionPerformed(ActionEvent e) {
	        displayBorrowHistoryInformationView();
	      }
	    });
	  }

	  private void addStartApplicationViewReturnBorrowedBooksButtonActionListener() {
	    graphicController.getStartApplicationView().addReturnBorrowedBooksButtonActionListener(new ActionListener() {

	      @Override
	      public void actionPerformed(ActionEvent e) {
	        if (connectedAsEmployee) {
	          JOptionPane.showMessageDialog(null, "You are connected as employee!", null, JOptionPane.ERROR_MESSAGE);
	        }
	        else {
	          displayReturnBorrowedBooksView();
	        }
	      }
	    });
	  }

	  private void addStartApplicationViewCancelReservationButtonActionListener() {
	    graphicController.getStartApplicationView().addCancelReservationButtonActionListener(new ActionListener() {

	      @Override
	      public void actionPerformed(ActionEvent e) {
	        if (connectedAsEmployee) {
	          JOptionPane.showMessageDialog(null, "You are connected as employee!", null, JOptionPane.ERROR_MESSAGE);
	        }
	        else {
	          displayCancelReservationView();
	        }
	      }
	    });
	  }

	  private void addStartApplicationViewNewMemberButtonActionListener() {
	    graphicController.getStartApplicationView().addInsertMemberButtonActionListener(new ActionListener() {

	      @Override
	      public void actionPerformed(ActionEvent e) {
	        displayNewMemberView();
	      }
	    });
	  }

	  private void addStartApplicationViewNewLiteraryWorkButtonActionListener() {
	    graphicController.getStartApplicationView().addInsertBookButtonActionListener(new ActionListener() {

	      @Override
	      public void actionPerformed(ActionEvent e) {
	        if (connectedAsEmployee) {
	          displayNewLiteraryWorkView();
	        }
	        else {
	          JOptionPane.showMessageDialog(null, "You are not connected as employee!", null, JOptionPane.ERROR_MESSAGE);
	        }
	      }
	    });
	  }

	  private void addStartApplicationViewNewPrintedButtonActionListener() {
	    graphicController.getStartApplicationView().addInsertPrintedButtonActionListener(new ActionListener() {

	      @Override
	      public void actionPerformed(ActionEvent e) {
	        if (connectedAsEmployee) {
	          displayNewPrintedView();
	        }
	        else {
	          JOptionPane.showMessageDialog(null, "You are not connected as employee!", null, JOptionPane.ERROR_MESSAGE);
	        }
	      }
	    });
	  }

	  private void addStartApplicationViewNewManuscriptButtonActionListener() {
	    graphicController.getStartApplicationView().addInsertManuscriptButtonActionListener(new ActionListener() {

	      @Override
	      public void actionPerformed(ActionEvent e) {
	        if (connectedAsEmployee) {
	          displayNewManuscriptView();
	        }
	        else {
	          JOptionPane.showMessageDialog(null, "You are not connected as employee!", null, JOptionPane.ERROR_MESSAGE);
	        }
	      }
	    });
	  }
	  private void addStartApplicationViewAddMemberInStudyRoomButtonActionListener() {
		    graphicController.getStartApplicationView().addInsertAccessButtonActionListener(new ActionListener() {

		      @Override
		      public void actionPerformed(ActionEvent e) {
		        if (connectedAsEmployee) {
		        	displayAddMemberInStudyRoomView();
		          
		        }
		        else {
		        	JOptionPane.showMessageDialog(null, "You are not connected as employee!", null, JOptionPane.ERROR_MESSAGE);
		        }
		      }
		    });
		  }

	  private void addBorrowBooksViewCancelButtonActionListener() {
	    graphicController.getBorrowBooksView().addCancelButtonActionListener(new ActionListener() {

	      @Override
	      public void actionPerformed(ActionEvent e) {
	        displayStartApplicationView();
	      }
	    });
	  }

	  private void addBorrowBooksViewCreateBorrowButtonActionListener() {
	    graphicController.getBorrowBooksView().addCreateBorrowButtonActionListener(new ActionListener() {

	      @Override
	      public void actionPerformed(ActionEvent e) {
	        Integer memberID = Integer.parseInt(graphicController.getBorrowBooksView().getMemberIDTextField().getText());
	       // String valabilityDate = graphicController.getBorrowMediaPanel().getValabilityDateTextField().getText();
	        Integer bookISBN = Integer.parseInt(graphicController.getBorrowBooksView().getBookISBNTextField().getText());
	        if (memberID.equals(loggedMemberID)) {

	          if (databaseLogicController.insertNewBorrow(memberID, bookISBN)) {
	            displayStartApplicationView();
	          }
	          else {
	            JOptionPane.showMessageDialog(null, "Verify the input data", null, JOptionPane.ERROR_MESSAGE);
	          }
	        }
	        else {
	          JOptionPane.showMessageDialog(null, "Wrong Member ID inserted", null, JOptionPane.ERROR_MESSAGE);
	        }
	      }
	    });
	  }

	  private void addReservationViewCancelButtonActionListener() {
	    graphicController.getReservationView().addCancelButtonActionListener(new ActionListener() {

	      @Override
	      public void actionPerformed(ActionEvent e) {
	        displayStartApplicationView();
	      }
	    });
	  }

	  private void addReservationViewMakeReservationButtonActionListener() {
	    graphicController.getReservationView().addCreateReservationButtonActionListener(new ActionListener() {

	      @Override
	      public void actionPerformed(ActionEvent e) {
	        Integer memberID = Integer.parseInt(graphicController.getReservationView().getMemberIDTextField().getText());
	        Integer bookISBN = Integer.parseInt(graphicController.getReservationView().getBookISBNTextField().getText());
	       // String valabilityDate = graphicController.getInternetRezervationPanel().getValabilityDateTextField().getText();
	        if (memberID.equals(loggedMemberID)) {
	          if (databaseLogicController.insertNewReservation(memberID, bookISBN)) {
	            displayStartApplicationView();
	          }
	          else {
	            JOptionPane.showMessageDialog(null, "Verify the input data", null, JOptionPane.ERROR_MESSAGE);
	          }
	        }
	        else {
	          JOptionPane.showMessageDialog(null, "Wrong Member ID inserted", null, JOptionPane.ERROR_MESSAGE);
	        }
	      }
	    });
	  }

	  private void addReturnBorrowedBooksViewCancelButtonActionListener() {
	    graphicController.getReturnBorrowedBooksView().addCancelButtonActionListener(new ActionListener() {

	      @Override
	      public void actionPerformed(ActionEvent e) {
	        displayStartApplicationView();
	      }
	    });
	  }

	  private void addReturnBorrowedBooksViewReturnBorrowedBooksButtonActionListener() {
	    graphicController.getReturnBorrowedBooksView().addReturnBorrowedBooksButtonActionListener(new ActionListener() {

	      @Override
	      public void actionPerformed(ActionEvent e) {
	        Integer memberID = Integer.parseInt(graphicController.getReturnBorrowedBooksView().getMemberIDTextField().getText());
	        Integer borrowID = Integer.parseInt(graphicController.getReturnBorrowedBooksView().getBorrowedIDTextField().getText());
	        if (memberID.equals(loggedMemberID)) {
	          if (databaseLogicController.returnBorrowedBooks(memberID, borrowID)) {
	            displayStartApplicationView();
	          }
	          else {
	            JOptionPane.showMessageDialog(null, "Verify the input data", null, JOptionPane.ERROR_MESSAGE);
	          }
	        }
	        else {
	          JOptionPane.showMessageDialog(null, "Wrong Member ID inserted", null, JOptionPane.ERROR_MESSAGE);
	        }
	      }
	    });
	  }

	  private void addCancelReservationCancelButtonActionListener() {
	    graphicController.getCancelReservationView().addCancelButtonActionListener(new ActionListener() {

	      @Override
	      public void actionPerformed(ActionEvent e) {
	        displayStartApplicationView();
	      }
	    });
	  }

	  private void addCancelReservationCancelReservationButtonActionListener() {
	    graphicController.getCancelReservationView().addCancelReservationButtonActionListener(
	        new ActionListener() {

	          @Override
	          public void actionPerformed(ActionEvent e) {
	            Integer memberID = Integer.parseInt(graphicController.getCancelReservationView().getMemberIDTextField().getText());
	            Integer reservationID = Integer.parseInt(graphicController.getCancelReservationView().getReservationIDTextField().getText());
	            if (memberID.equals(loggedMemberID)) {
	              if (databaseLogicController.cancelReservation(memberID, reservationID)) {
	                displayStartApplicationView();
	              }
	              else {
	                JOptionPane.showMessageDialog(null, "Verify the input data", null, JOptionPane.ERROR_MESSAGE);
	              }
	            }
	            else {
	              JOptionPane.showMessageDialog(null, "Wrong Member ID inserted", null, JOptionPane.ERROR_MESSAGE);
	            }
	          }
	        });
	  }

	  private void addNewMemberViewCancelButtonActionListener() {
	    graphicController.getNewMemberView().addCancelButtonActionListener(new ActionListener() {

	      @Override
	      public void actionPerformed(ActionEvent e) {
	        displayStartApplicationView();
	      }
	    });
	  }

	  private void addNewMemberViewAddAccountButtonActionListener() {
	    graphicController.getNewMemberView().addCreateMemberButtonActionListener(new ActionListener() {

	      @Override
	      public void actionPerformed(ActionEvent e) {
	        String firstName = graphicController.getNewMemberView().getFirstNameTextField().getText();
	        String lastName=graphicController.getNewMemberView().getLastNameTextField().getText();
	        String street = graphicController.getNewMemberView().getStreetTextField().getText();
	        Integer number=Integer.parseInt(graphicController.getNewMemberView().getNumberTextField().getText());
	        String city=graphicController.getNewMemberView().getCityTextField().getText();
	        String job=graphicController.getNewMemberView().getJobTextField().getText();
	        String birthDate=graphicController.getNewMemberView().getBirthDateTextField().getText();
	        String sex = graphicController.getNewMemberView().getSexTextField().getText();
	        String email = graphicController.getNewMemberView().getEmailTextField().getText();
	     
	        String result = databaseLogicController.insertNewMember(firstName,lastName,street,number,city,job,birthDate,sex,email);
	        if (result.equals("Deja exista membrul cu email-ul " + email)) {
	          JOptionPane.showMessageDialog(null, "Member with that email already exists", null, JOptionPane.PLAIN_MESSAGE);
	        }
	        else {
	          displayStartApplicationView();
	        }
	      }
	    });
	  }

	  private void addNewLiteraryWorkViewCancelButtonActionListener() {
	    graphicController.getNewLiteraryWorkView().addCancelButtonActionListener(new ActionListener() {

	      @Override
	      public void actionPerformed(ActionEvent e) {
	        displayStartApplicationView();
	      }
	    });
	  }

	  private void addNewLiteraryWorkViewInsertLiteraryWorkButtonActionListener() {
	    graphicController.getNewLiteraryWorkView().addInsertLiteraryWorkButtonActionListener(new ActionListener() {

	      @Override
	      public void actionPerformed(ActionEvent e) {
	        //Integer movieID = Integer.parseInt(graphicController.getInsertMoviePanel().getMovieIDTextField().getText());
	        String title = graphicController.getNewLiteraryWorkView().getTitleTextField().getText();
	        String author = graphicController.getNewLiteraryWorkView().getAuthorTextField().getText();
	        if (databaseLogicController.insertNewLiteraryWork( title, author)) {
	          displayStartApplicationView();
	        }
	        else {
	          JOptionPane.showMessageDialog(null, "Verify input data", null, JOptionPane.ERROR_MESSAGE);
	        }
	      }
	    });
	  }

	  private void addNewPrintedviewCancelButtonActionListener() {
	    graphicController.getNewPrintedView().addCancelButtonActionListener(new ActionListener() {

	      @Override
	      public void actionPerformed(ActionEvent e) {
	        displayStartApplicationView();
	      }
	    });
	  }

	  private void addNewPrintedViewInsertPrintedActionListener() {
	    graphicController.getNewPrintedView().addInsertPrintedButtonActionListener(new ActionListener() {

	      @Override
	      public void actionPerformed(ActionEvent e) {
	        Integer bookISBN = Integer.parseInt(graphicController.getNewPrintedView().getBookISBNTextField().getText());
	        String language=graphicController.getNewPrintedView().getLanguageTextField().getText();
	        Integer numberOfCopies = Integer.parseInt(graphicController.getNewPrintedView().getNumberOfCopiesTextField().getText());
	        Integer availableNumberOfCopies = Integer.parseInt(graphicController.getNewPrintedView().getAvailableNumberOfCopiesTextField().getText());
	        String category = graphicController.getNewPrintedView().getCategoryTextField().getText();
	        String status = graphicController.getNewPrintedView().getStatusTextField().getText();
	        String locationInLibrary = graphicController.getNewPrintedView().getLocationInLibraryTextField().getText();
	        Double penaltyCharge=Double.parseDouble(graphicController.getNewPrintedView().getPenaltyChargeTextField().getText());
	        Integer literaryWork= Integer.parseInt(graphicController.getNewPrintedView().getLiteraryWorkIDTextField().getText());
	        String publishingHouse = graphicController.getNewPrintedView().getPublishingHouseTextField().getText();
	        
	        if (databaseLogicController.insertNewPrinted(bookISBN,language,numberOfCopies,availableNumberOfCopies,category,
	        		status,locationInLibrary,penaltyCharge,literaryWork,publishingHouse)) {
	          displayStartApplicationView();
	        }
	        else {
	          JOptionPane.showMessageDialog(null, "Verify input data", null, JOptionPane.ERROR_MESSAGE);
	        }
	      }
	    });
	  }
	  
	  private void addNewManuscriptViewCancelButtonActionListener() {
		    graphicController.getNewManuscriptView().addCancelButtonActionListener(new ActionListener() {

		      @Override
		      public void actionPerformed(ActionEvent e) {
		        displayStartApplicationView();
		      }
		    });
		  }

	  private void addNewManuscriptViewInsertManuscriptButtonActionListener() {
	    graphicController.getNewManuscriptView().addCancelButtonActionListener(new ActionListener() {

	    	 public void actionPerformed(ActionEvent e) {
	 	        Integer bookISBN = Integer.parseInt(graphicController.getNewManuscriptView().getBookISBNTextField().getText());
	 	        String language=graphicController.getNewManuscriptView().getLanguageTextField().getText();
	 	        Integer numberOfCopies = Integer.parseInt(graphicController.getNewManuscriptView().getNumberOfCopiesTextField().getText());
	 	        Integer availableNumberOfCopies = Integer.parseInt(graphicController.getNewManuscriptView().getAvailableNumberOfCopiesTextField().getText());
	 	        String category = graphicController.getNewManuscriptView().getCategoryTextField().getText();
	 	        String status = graphicController.getNewManuscriptView().getStatusTextField().getText();
	 	        String locationInLibrary = graphicController.getNewManuscriptView().getLocationInLibraryTextField().getText();
	 	        Double penaltyCharge=Double.parseDouble(graphicController.getNewManuscriptView().getPenaltyChargeTextField().getText());
	 	        Integer literaryWork= Integer.parseInt(graphicController.getNewManuscriptView().getLiteraryWorkIDTextField().getText());
	 	        String year = graphicController.getNewManuscriptView().getPublishingYearTextField().getText();
	 	        
	 	        if (databaseLogicController.insertNewPrinted(bookISBN,language,numberOfCopies,availableNumberOfCopies,category,
	 	        		status,locationInLibrary,penaltyCharge,literaryWork,year)) {
	 	          displayStartApplicationView();
	 	        }
	 	        else {
	 	          JOptionPane.showMessageDialog(null, "Verify input data", null, JOptionPane.ERROR_MESSAGE);
	 	        }
	 	      }
	 	    });
	  }
	  
	  private void addStartApplicationViewStudyRoomButtonActionListener() {
		    graphicController.getStartApplicationView().addShowStudyRoomsButtonActionListener(new ActionListener() {

		      @Override
		      public void actionPerformed(ActionEvent e) {
		        displayStudyRoomView();
		      }
		    });
		  }
	  
	  private void addStartApplicationViewEmployeeInformationButtonActionListener() {
		    graphicController.getStartApplicationView().addShowEmployeeInformationButtonActionListener(new ActionListener() {

		      @Override
		      public void actionPerformed(ActionEvent e) {
		        displayEmployeeInformationView();
		      }
		    });
		  }
	  private void addStartApplicationViewEventInformationButtonActionListener() {
		    graphicController.getStartApplicationView().addShowEventInformationButtonActionListener(new ActionListener() {

		      @Override
		      public void actionPerformed(ActionEvent e) {
		        displayEventInformationView();
		      }
		    });
		  }
	  
	  private void addStartApplicationViewAccessInStudyRoomInformationButtonActionListener() {
		    graphicController.getStartApplicationView().addAccessInStudyRoomInformationButtonActionListener(new ActionListener() {

		      @Override
		      public void actionPerformed(ActionEvent e) {
		        displayAccessInStudyRoomInformationView();
		      }
		    });
		  }
	  
	  private void addAddMemberInStudyRoomViewCancelButtonActionListener() {
		    graphicController.getAddMemberInStudyRoomView().addCancelButtonActionListener(new ActionListener() {

		      @Override
		      public void actionPerformed(ActionEvent e) {
		        displayStartApplicationView();
		      }
		    });
		  }

		  private void addAddMemberInStudyRoomViewCreateAccessButtonActionListener() {
		    graphicController.getAddMemberInStudyRoomView().addCreateAccessButtonActionListener(new ActionListener() {

		      @Override
		      public void actionPerformed(ActionEvent e) {
		        Integer memberID = Integer.parseInt(graphicController.getAddMemberInStudyRoomView().getMemberIDTextField().getText());
		        Integer studyRoomID = Integer.parseInt(graphicController.getAddMemberInStudyRoomView().getStudyRoomIDTextField().getText());
		        Integer employeeID=Integer.parseInt(graphicController.getAddMemberInStudyRoomView().getEmployeeIDTextField().getText());
		      

		          if (databaseLogicController.insertNewAcces(memberID, studyRoomID,employeeID)) {
		            displayStartApplicationView();
		          }
		          else {
		            JOptionPane.showMessageDialog(null, "Verify the input data", null, JOptionPane.ERROR_MESSAGE);
		          }
		       
		      }
		    });
		  }


	  private String[][] parseBookResultSet(ResultSet resultSet, Integer rowCount, Integer columnCount) {
	    String[][] result = new String[rowCount][columnCount];
	    int i = 0;
	    try {
	      while (resultSet.next()) {
	        int j = 0;

	        if (i > rowCount) {
	          result = copyMatrix(result, rowCount, columnCount);
	          rowCount++;
	        }

	        Integer temp = resultSet.getInt(1);
	        result[i][j] = temp.toString();
	        j++;

	        result[i][j] = resultSet.getString(2);
	        j++;

	        result[i][j] = resultSet.getString(3);
	        j++;

	        result[i][j] = resultSet.getString(4);
	        j++;

	        result[i][j] = resultSet.getString(5);
	        j++;

	        result[i][j] = resultSet.getString(6);
	        j++;

	        //temp = resultSet.getInt(7);
	        result[i][j] = resultSet.getString(7);
	        

	        /*temp = resultSet.getInt(8);
	        switch (temp) {
	        case 0:
	          result[i][j] = "Available";
	          break;
	        case 1:
	          result[i][j] = "Borrowed";
	          break;
	        case 2:
	          result[i][j] = "Rezerved";
	          break;
	        default:
	          result[i][j] = "Error";
	          break;
	        }*/

	        i++;
	      }
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	      JOptionPane.showMessageDialog(null, "The parsing of the result set failed", null, JOptionPane.ERROR_MESSAGE);
	    }

	    return result;
	  }

	  private String[][] parsePrintedOrManuscriptResultSet(ResultSet resultSet, int rowCount, int columnCount) {
	    String[][] result = new String[rowCount][columnCount];
	    int i = 0;
	    try {
	      while (resultSet.next()) {
	        int j = 0;

	        if (i >= rowCount) {
	          result = copyMatrix(result, rowCount, columnCount);
	          rowCount++;
	        }

	        result[i][j] = resultSet.getString(1);
	        j++;

	        result[i][j] = resultSet.getString(2);
	        j++;

	        result[i][j] = resultSet.getString(3);
	        j++;
	        
	        Integer temp=resultSet.getInt(4);
	        result[i][j] = temp.toString();
	        j++;
	        
	        temp=resultSet.getInt(5);
	        result[i][j] = temp.toString();
	        j++;

	        
	        result[i][j] = resultSet.getString(6);
	        j++;
	        
	        result[i][j]=resultSet.getString(7);
	        j++;
	        
	        Double temp2=resultSet.getDouble(8);
	        result[i][j]=temp2.toString();
	        j++;
	        
	        result[i][j]=resultSet.getString(9);
	        i++;
	      }
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	      JOptionPane.showMessageDialog(null, "The parsing of the result set failed", null, JOptionPane.ERROR_MESSAGE);
	    }

	    return result;
	  }

	  private String[][] parseReservationInformationResultSet(ResultSet resultSet, int rowCount, int columnCount) {
	    String[][] result = new String[rowCount][columnCount];
	    int i = 0;
	    try {
	      while (resultSet.next()) {
	        int j = 0;

	        if (i >= rowCount) {
	          result = copyMatrix(result, rowCount, columnCount);
	          rowCount++;
	        }

	        Integer temp = resultSet.getInt(1);
	        result[i][j] = temp.toString();
	        j++;

	        result[i][j] = resultSet.getString(2);
	        j++;

	        result[i][j] = resultSet.getString(3);
	        j++;

	        result[i][j] = resultSet.getString(4);
	        j++;

	        result[i][j] = resultSet.getString(5);
	        j++;

	        result[i][j] = resultSet.getString(6);
	        j++;
	        
	        result[i][j]=resultSet.getString(7);

	        i++;
	      }
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	      JOptionPane.showMessageDialog(null, "The parsing of the result set failed", null, JOptionPane.ERROR_MESSAGE);
	    }

	    return result;
	  }

	  private String[][] parseMemberInformationResultSet(ResultSet resultSet, int rowCount, int columnCount) {
	    String[][] result = new String[rowCount][columnCount];
	    int i = 0;
	    try {
	      while (resultSet.next()) {
	        int j = 0;

	        if (i >= rowCount) {
	          result = copyMatrix(result, rowCount, columnCount);
	          rowCount++;
	        }

	        Integer temp = resultSet.getInt(1);
	        result[i][j] = temp.toString();
	        j++;

	        result[i][j] = resultSet.getString(2);
	        j++;

	        result[i][j] = resultSet.getString(3);
	        j++;
	        
	        result[i][j]=resultSet.getString(4);
	        j++;
	        
	        result[i][j]=resultSet.getString(5);
	        i++;
	      }
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	      JOptionPane.showMessageDialog(null, "The parsing of the result set failed", null, JOptionPane.ERROR_MESSAGE);
	    }

	    return result;
	  }

	  private String[][] parseBorrowedBooksResultSet(ResultSet resultSet, int rowCount, int columnCount) {
	    String[][] result = new String[rowCount][columnCount];
	    int i = 0;
	    try {
	      while (resultSet.next()) {
	        int j = 0;

	        if (i >= rowCount) {
	          result = copyMatrix(result, rowCount, columnCount);
	          rowCount++;
	        }

	        Integer temp = resultSet.getInt(1);
	        result[i][j] = temp.toString();
	        j++;

	        result[i][j] = resultSet.getString(2);
	        j++;

	        result[i][j] = resultSet.getString(3);
	        j++;
	        
	        result[i][j] = resultSet.getString(4);
	        j++;
	        
	        result[i][j] = resultSet.getString(5);
	        j++;
	        
	        result[i][j] = resultSet.getString(6);
	        j++;
	        
	        result[i][j] = resultSet.getString(7);
	        j++;


	        i++;
	      }
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	      JOptionPane.showMessageDialog(null, "The parsing of the result set failed", null, JOptionPane.ERROR_MESSAGE);
	    }

	    return result;
	  }

	  private String[][] parseBorrowHistoryInformation(ResultSet resultSet, int rowCount, int columnCount) {
	    String[][] result = new String[rowCount][columnCount];
	    int i = 0;
	    try {
	      while (resultSet.next()) {
	        int j = 0;

	        if (i >= rowCount) {
	          result = copyMatrix(result, rowCount, columnCount);
	          rowCount++;
	        }

	        Integer temp = resultSet.getInt(1);
	        result[i][j] = temp.toString();
	        j++;

	        result[i][j] = resultSet.getString(2);
	        j++;

	        result[i][j] = resultSet.getString(3);
	        j++;
	        
	        result[i][j] = resultSet.getString(4);
	        j++;
	        
	        result[i][j] = resultSet.getString(5);
	        j++;
	        
	        result[i][j] = resultSet.getString(6);
	        j++;


	        i++;
	      }
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	      JOptionPane.showMessageDialog(null, "The parsing of the result set failed", null, JOptionPane.ERROR_MESSAGE);
	    }

	    return result;
	  }

	  private String[][] parseLiteraryWorkResultSet(ResultSet resultSet, int rowCount, int columnCount) {
	    String[][] result = new String[rowCount][columnCount];
	    int i = 0;
	    try {
	      while (resultSet.next()) {
	        int j = 0;

	        if (i >= rowCount) {
	          result = copyMatrix(result, rowCount, columnCount);
	          rowCount++;
	        }

	        Integer temp = resultSet.getInt(1);
	        result[i][j] = temp.toString();
	        j++;

	        result[i][j] = resultSet.getString(2);
	        j++;

	        result[i][j] = resultSet.getString(3);
	        j++;

	        i++;
	      }
	    }
	    catch (SQLException e) {
	      e.printStackTrace();
	      JOptionPane.showMessageDialog(null, "The parsing of the result set failed", null, JOptionPane.ERROR_MESSAGE);
	    }

	    return result;
	  }
	  
	  private String[][] parseStudyRoomResultSet(ResultSet resultSet, int rowCount, int columnCount) {
		    String[][] result = new String[rowCount][columnCount];
		    int i = 0;
		    try {
		      while (resultSet.next()) {
		        int j = 0;

		        if (i >= rowCount) {
		          result = copyMatrix(result, rowCount, columnCount);
		          rowCount++;
		        }

		        Integer temp = resultSet.getInt(1);
		        result[i][j] = temp.toString();
		        j++;
		        
		        temp=resultSet.getInt(2);
		        result[i][j]=temp.toString();
		        j++;
		        

		        result[i][j] = resultSet.getString(3);
		        j++;

		        temp=resultSet.getInt(4);
		        result[i][j]=temp.toString();
		        j++;
		        
		        temp=resultSet.getInt(5);
		        result[i][j]=temp.toString();
		        j++;
		        

		        i++;
		      }
		    }
		    catch (SQLException e) {
		      e.printStackTrace();
		      JOptionPane.showMessageDialog(null, "The parsing of the result set failed", null, JOptionPane.ERROR_MESSAGE);
		    }

		    return result;
		  }
	  
	  private String[][] parseEmployeeInformationResultSet(ResultSet resultSet, int rowCount, int columnCount) {
		    String[][] result = new String[rowCount][columnCount];
		    int i = 0;
		    try {
		      while (resultSet.next()) {
		        int j = 0;

		        if (i >= rowCount) {
		          result = copyMatrix(result, rowCount, columnCount);
		          rowCount++;
		        }

		        Integer temp = resultSet.getInt(1);
		        result[i][j] = temp.toString();
		        j++;
		          
		        result[i][j] = resultSet.getString(2);
		        j++;
		        
		        result[i][j] = resultSet.getString(3);
		        j++;
		        i++;
		      }
		    }
		    catch (SQLException e) {
		      e.printStackTrace();
		      JOptionPane.showMessageDialog(null, "The parsing of the result set failed", null, JOptionPane.ERROR_MESSAGE);
		    }

		    return result;
		  }
	  
	  private String[][] parseEventInformationResultSet(ResultSet resultSet, int rowCount, int columnCount) {
		    String[][] result = new String[rowCount][columnCount];
		    int i = 0;
		    try {
		      while (resultSet.next()) {
		        int j = 0;

		        if (i >= rowCount) {
		          result = copyMatrix(result, rowCount, columnCount);
		          rowCount++;
		        }

		        Integer temp = resultSet.getInt(1);
		        result[i][j] = temp.toString();
		        j++;
		          
		        result[i][j] = resultSet.getString(2);
		        j++;
		        
		        result[i][j] = resultSet.getString(3);
		        j++;
		        
		        result[i][j] = resultSet.getString(4);
		        j++;
		        
		        result[i][j] = resultSet.getString(5);
		        j++;
		        
		        i++;
		      }
		    }
		    catch (SQLException e) {
		      e.printStackTrace();
		      JOptionPane.showMessageDialog(null, "The parsing of the result set failed", null, JOptionPane.ERROR_MESSAGE);
		    }

		    return result;
		  }
	  
	  private String[][] parseAccesInformationResultSet(ResultSet resultSet, int rowCount, int columnCount) {
		    String[][] result = new String[rowCount][columnCount];
		    int i = 0;
		    try {
		      while (resultSet.next()) {
		        int j = 0;

		        if (i >= rowCount) {
		          result = copyMatrix(result, rowCount, columnCount);
		          rowCount++;
		        }

		        
		          
		        result[i][j] = resultSet.getString(1);
		        j++;
		        
		        result[i][j] = resultSet.getString(2);
		        j++;
		        
		        Integer temp = resultSet.getInt(3);
		        result[i][j] = temp.toString();
		        j++;
		        
		        result[i][j] = resultSet.getString(4);
		        j++;
		        
		        result[i][j] = resultSet.getString(5);
		        j++;
		        
		        result[i][j] = resultSet.getString(6);
		        j++;
		        
		        i++;
		      }
		    }
		    catch (SQLException e) {
		      e.printStackTrace();
		      JOptionPane.showMessageDialog(null, "The parsing of the result set failed", null, JOptionPane.ERROR_MESSAGE);
		    }

		    return result;
		  }
	  

	  private String[][] copyMatrix(String[][] data, Integer rowCount, Integer columnCount) {
	    String[][] result = new String[rowCount + 1][columnCount];

	    for (int i = 0; i < rowCount; i++) {
	      for (int j = 0; j < columnCount; j++) {
	        result[i][j] = data[i][j];
	      }
	    }

	    return result;
	  }

	  private AbstractTableModel createNewAbstractTableModel() {
	    return new AbstractTableModel() {
	      /**
	       * 
	       */
	      private static final long serialVersionUID = 1L;
	      private String[] columnNames = { "ISBN", "Title", "Author", "Category", "Status", "Location in Library", "Penalty charge"};
	      String title = graphicController.getStartApplicationView().getSearchTextField().getText();
	      ResultSet resultSet = databaseLogicController.showParticularBooksInfo(title);
	      private String[][] data = parseBookResultSet(resultSet, 25, 7);

	      @Override
	      public int getColumnCount() {
	        return columnNames.length;
	      }

	      @Override
	      public int getRowCount() {
	        return data.length;
	      }

	      @Override
	      public String getColumnName(int col) {
	        return columnNames[col];
	      }

	      @Override
	      public String getValueAt(int row, int col) {
	        return data[row][col];
	      }

	      /*
	       * public Class getColumnClass(int c) { return getValueAt(0, c).getClass(); }
	       */
	    };
	  }

}
