package libraryBD;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class StartApplicationView extends JPanel {
	
	private static final long serialVersionUID = 1L;

	  private JButton searchButton;
	  private JTextField searchTextField;
	  private JTable booksTable;
	  private JButton showMyIdButton;
	  private JButton borrowBooksButton;
	  private JButton makeResevationButton;
	  private JButton showBooksInformationButton;
	  private JButton showPrintedInformationButton;
	  private JButton showManuscriptInformationButton;
	  private JButton showReservationsButton;
	  private JButton showAllBooksBorrowsButton;
	  private JButton showMembersInformationButton;
	  private JButton showBorrowHistoryButton;
	  private JButton returnBorrowedBooksButton;
	  private JButton cancelReservationButton;
	  private JButton insertNewMemberButton;
	  private JButton insertBookButton;
	  private JButton insertPrintedButtonButton;
	  private JButton insertManuscriptButton;
	  private JButton showStudyRoomsButton;
	  private JButton showEmployeeInformationButton;
	  private JButton showEventInformationButton;
	  private JButton showAccesInStudyRoomInformationButton;
	  private JButton insertAccessButton;
	  private GridBagConstraints constraints;

	  @SuppressWarnings("unused")
	  private String[][] data;
	  @SuppressWarnings("unused")
	  private String[] columnNames;

	  public StartApplicationView(String[][] data, String[] columnNames) {
	    this.data = data;
	    this.columnNames = columnNames;

	    setLayout(new GridBagLayout());

	    searchButton = new JButton("Search");
	    searchTextField = new JTextField();
	    showMyIdButton = new JButton("Show my ID");
	    borrowBooksButton = new JButton("Borrow Books");
	    makeResevationButton = new JButton("Make reservation");
	    showBooksInformationButton = new JButton("Show Literary Works");
	    showPrintedInformationButton = new JButton("Show Printed Books Information");
	    showManuscriptInformationButton = new JButton("Show Manuscripts Information");
	    showReservationsButton = new JButton("Show Reservations");
	    showAllBooksBorrowsButton = new JButton("Show all borrowed books");
	    showMembersInformationButton = new JButton("Show members information");
	    showBorrowHistoryButton = new JButton("Show borrows history");
	    returnBorrowedBooksButton = new JButton("Return borrowed books");
	    cancelReservationButton = new JButton("Cancel Reservation");
	    insertNewMemberButton = new JButton("Insert new member");
	    insertBookButton = new JButton("Insert new literary work");
	    insertPrintedButtonButton = new JButton("Insert new printed book");
	    insertManuscriptButton = new JButton("Insert new manuscript");
	    showStudyRoomsButton= new JButton("Study Rooms");
	    showEmployeeInformationButton=new JButton("Employee Information");
	    showEventInformationButton=new JButton("Event Information");
	    showAccesInStudyRoomInformationButton=new JButton("Members in Study Room");
	    insertAccessButton=new JButton("New access in study room");

	    constraints = new GridBagConstraints();

	    constraints.fill = GridBagConstraints.CENTER;
	    constraints.gridx = 0;
	    constraints.gridy = 0;
	    constraints.insets = new Insets(5, 5, 5, 5);
	    constraints.anchor = GridBagConstraints.CENTER;
	    constraints.weightx = 0.5;
	    constraints.weighty = 0.5;

	    searchTextField.setPreferredSize(new Dimension(300, 20));
	    add(searchTextField, constraints);

	    constraints.gridx++;
	    constraints.fill = GridBagConstraints.WEST;
	    searchButton.setPreferredSize(new Dimension(75, 20));
	    add(searchButton, constraints);

	    constraints.fill = GridBagConstraints.BOTH;
	    constraints.gridy++;
	    add(showMyIdButton, constraints);

	    constraints.gridy++;
	    add(borrowBooksButton, constraints);

	    constraints.gridy++;
	    add(makeResevationButton, constraints);

	    constraints.gridy++;
	    add(showBooksInformationButton, constraints);

	    constraints.gridy++;
	    add(showPrintedInformationButton, constraints);

	    constraints.gridy++;
	    add(showManuscriptInformationButton, constraints);

	    constraints.gridy++;
	    add(showReservationsButton, constraints);

	    constraints.gridy++;
	    add(showAllBooksBorrowsButton, constraints);

	    constraints.gridy++;
	    add(showMembersInformationButton, constraints);

	    constraints.gridy++;
	    add(showBorrowHistoryButton, constraints);

	    constraints.gridy++;
	    add(returnBorrowedBooksButton, constraints);

	    constraints.gridy++;
	    add(cancelReservationButton, constraints);

	    constraints.gridy++;
	    add(insertNewMemberButton, constraints);

	    constraints.gridy++;
	    add(insertBookButton, constraints);

	    constraints.gridy++;
	    add(insertPrintedButtonButton, constraints);

	    constraints.gridy++;
	    add(insertManuscriptButton, constraints);
	    
	    constraints.gridy++;
	    add(showStudyRoomsButton,constraints);
	    
	    constraints.gridy++;
	    add(showEmployeeInformationButton,constraints);
	    
	    constraints.gridy++;
	    add(showEventInformationButton,constraints);
	    
	    constraints.gridy++;
	    add(showAccesInStudyRoomInformationButton,constraints);
	    
	    constraints.gridy++;
	    add(insertAccessButton,constraints);

	    booksTable = new JTable(data, columnNames);
	    constraints.gridy = 1;
	    constraints.gridx--;
	    constraints.gridheight = 13;
	    add(new JScrollPane(booksTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
	        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), constraints);
	  }

	  public void addSearchButtonActionListener(ActionListener actionListener) {
	    searchButton.addActionListener(actionListener);
	  }

	  public void addSearchtextFieldKeyListener(KeyListener keyListener) {
	    searchTextField.addKeyListener(keyListener);
	  }

	  public void addShowMyIdButtonActionListener(ActionListener actionListener) {
	    showMyIdButton.addActionListener(actionListener);
	  }

	  public void addBorrowBooksButtonActionListener(ActionListener actionListener) {
	    borrowBooksButton.addActionListener(actionListener);
	  }

	  public void addMakeReservationButtonActionListener(ActionListener actionListener) {
	    makeResevationButton.addActionListener(actionListener);
	  }

	  public void addShowBooksInformationButtonActionListener(ActionListener actionListener) {
	    showBooksInformationButton.addActionListener(actionListener);
	  }

	  public void addShowPrintedInformationButtonActionListener(ActionListener actionListener) {
	    showPrintedInformationButton.addActionListener(actionListener);
	  }

	  public void addShowManuscriptInformationButtonActionListener(ActionListener actionListener) {
	    showManuscriptInformationButton.addActionListener(actionListener);
	  }

	  public void addShowReservationsActionListener(ActionListener actionListener) {
	    showReservationsButton.addActionListener(actionListener);
	  }

	  public void addShowAllBooksBorrowsButton(ActionListener actionListener) {
	    showAllBooksBorrowsButton.addActionListener(actionListener);
	  }

	  public void addShowMembersInformationButtonActionListener(ActionListener actionListener) {
	    showMembersInformationButton.addActionListener(actionListener);
	  }

	  public void addShowBorrowHistoryButtonActionListener(ActionListener actionListener) {
	    showBorrowHistoryButton.addActionListener(actionListener);
	  }

	  public void addReturnBorrowedBooksButtonActionListener(ActionListener actionListener) {
	    returnBorrowedBooksButton.addActionListener(actionListener);
	  }

	  public void addCancelReservationButtonActionListener(ActionListener actionListener) {
	    cancelReservationButton.addActionListener(actionListener);
	  }

	  public void addInsertMemberButtonActionListener(ActionListener actionListener) {
	    insertNewMemberButton.addActionListener(actionListener);
	  }

	  public void addInsertBookButtonActionListener(ActionListener actionListener) {
	    insertBookButton.addActionListener(actionListener);
	  }

	  public void addInsertPrintedButtonActionListener(ActionListener actionListener) {
	    insertPrintedButtonButton.addActionListener(actionListener);
	  }

	  public void addInsertManuscriptButtonActionListener(ActionListener actionListener) {
	    insertManuscriptButton.addActionListener(actionListener);
	  }
	  
	  public void addShowStudyRoomsButtonActionListener(ActionListener actionListener) {
		  
		  showStudyRoomsButton.addActionListener(actionListener);
	  }
	  
	  public void addShowEmployeeInformationButtonActionListener(ActionListener actionListener) {
		  
		  showEmployeeInformationButton.addActionListener(actionListener);
	  }
	  public void addShowEventInformationButtonActionListener(ActionListener actionListener) {
		  
		  showEventInformationButton.addActionListener(actionListener);
	  }
	  public void addAccessInStudyRoomInformationButtonActionListener(ActionListener actionListener) {
		  
		  showAccesInStudyRoomInformationButton.addActionListener(actionListener);
	  }
	  public void addInsertAccessButtonActionListener(ActionListener actionListener) {
		  
		  insertAccessButton.addActionListener(actionListener);
	  }

	  public JTable getBookTable() {
	    return booksTable;
	  }

	  public void setBookTable(JTable mediaTable) {
	    this.booksTable = mediaTable;
	  }

	  public JTextField getSearchTextField() {
	    return searchTextField;
	  }

}
