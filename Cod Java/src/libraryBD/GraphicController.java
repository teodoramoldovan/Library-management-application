package libraryBD;


import java.awt.GridBagLayout;

import javax.swing.JFrame;



public class GraphicController {
	
	  private MainFrame mainFrame;
	  private DatabaseConnectionView databaseConnectionView;
	  private LogInView logInView;
	  private StartApplicationView startApplicationView;
	  private BorrowBooksView borrowBooksView;
	  private ReservationView reservationView;
	  private BooksInformationView booksInformationView;
	  private PrintedInformationView printedInformationView;
	  private ManuscriptInformationView manuscriptInformationView;
	  private ReservationInformationView reservationInformationView;
	  private BorrowedBooksInformationView borrowedBooksInformationView;
	  private MembersInformationView membersInformationView;
	  //@SuppressWarnings("unused")
	  private BorrowHistoryInformationView borrowHistoryInformationView;
	 // @SuppressWarnings("unused")
	  private ReturnBorrowedBooksView returnBorrowedBooksView;
	  private CancelReservationView cancelReservationView;
	  private NewMemberView newMemberView;
	  private NewLiteraryWorkView newLiteraryWorkView;
	  private NewPrintedView newPrintedView;
	  private NewManuscriptView newManuscriptView;
	  private StudyRoomView studyRoomView;
	  private EmployeeInformationView employeeInformationView;
	  private EventInformationView eventInformationView;
	  private AccesInStudyRoomInformationView accessInStudyRoomInformationView;
	  private AddMemberInStudyRoomView addMemberInStudyRoomView;

	  public GraphicController() {
	  }

	  public void showMainframe() {
	    mainFrame = new MainFrame();
	    mainFrame.setTitle("Library");
	    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    mainFrame.setSize(600, 600);
	    mainFrame.setLayout(new GridBagLayout());
	    mainFrame.setLocationRelativeTo(null);
	    mainFrame.setVisible(true);
	  }

	  public void showDatabaseConnectionView() {
	    mainFrame.getContentPane().removeAll();
	    mainFrame.revalidate();
	    databaseConnectionView = new DatabaseConnectionView();
	    mainFrame.add(databaseConnectionView);
	    mainFrame.pack();
	  }

	  public void showLogInView() {
	    mainFrame.getContentPane().removeAll();
	    mainFrame.revalidate();
	    logInView = new LogInView();
	    mainFrame.add(logInView);
	    mainFrame.pack();
	  }

	  public void showStartApplicationView(String[][] data, String[] columnNames) {
	    mainFrame.getContentPane().removeAll();
	    mainFrame.revalidate();
	    startApplicationView = new StartApplicationView(data, columnNames);
	    mainFrame.add(startApplicationView);
	    mainFrame.pack();
	  }

	  public void showBorrowBooksView() {
	    mainFrame.getContentPane().removeAll();
	    mainFrame.revalidate();
	    borrowBooksView = new BorrowBooksView();
	    mainFrame.add(borrowBooksView);
	    mainFrame.pack();
	  }

	  public void showReservationView() {
	    mainFrame.getContentPane().removeAll();
	    mainFrame.revalidate();
	    reservationView = new ReservationView();
	    mainFrame.add(reservationView);
	    mainFrame.pack();
	  }

	  public void showBooksInformationView(String[][] data, String[] columnNames) {
	    booksInformationView = new BooksInformationView(data, columnNames);
	  }

	  public void showPrintedInformationView(String[][] data, String[] columnNames) {
	    printedInformationView = new PrintedInformationView(data, columnNames);
	  }

	  public void showManuscriptInformationView(String[][] data, String[] columnNames) {
	    manuscriptInformationView = new ManuscriptInformationView(data, columnNames);
	  }

	  public void showReservationInformationView(String[][] data, String[] columnNames) {
	    reservationInformationView = new ReservationInformationView(data, columnNames);
	  }

	  public void showBorrowedBooksInformationView(String[][] data, String[] columnNames) {
		  borrowedBooksInformationView = new BorrowedBooksInformationView(data, columnNames);
	  }

	  public void showMembersInformationView(String[][] data, String[] columnNames) {
		  membersInformationView = new MembersInformationView(data, columnNames);
	  }

	  public void showBorrowHistoryInformationView(String[][] data, String[] columnNames) {
		  borrowHistoryInformationView = new BorrowHistoryInformationView(data, columnNames);
	  }

	  public void showReturnBorrowedBooksView() {
	    mainFrame.getContentPane().removeAll();
	    mainFrame.revalidate();
	    returnBorrowedBooksView = new ReturnBorrowedBooksView();
	    mainFrame.add(returnBorrowedBooksView);
	    mainFrame.pack();
	  }

	  public void showCancelReservationView() {
	    mainFrame.getContentPane().removeAll();
	    mainFrame.revalidate();
	    cancelReservationView = new CancelReservationView();
	    mainFrame.add(cancelReservationView);
	    mainFrame.pack();
	  }

	  public void showNewMemberView() {
	    mainFrame.getContentPane().removeAll();
	    mainFrame.revalidate();
	    newMemberView = new NewMemberView();
	    mainFrame.add(newMemberView);
	    mainFrame.pack();
	  }

	  public void showNewLiteraryWorkView() {
	    mainFrame.getContentPane().removeAll();
	    mainFrame.revalidate();
	    newLiteraryWorkView = new NewLiteraryWorkView();
	    mainFrame.add(newLiteraryWorkView);
	    mainFrame.pack();
	  }

	  public void showNewPrintedView() {
	    mainFrame.getContentPane().removeAll();
	    mainFrame.revalidate();
	    newPrintedView = new NewPrintedView();
	    mainFrame.add(newPrintedView);
	    mainFrame.pack();
	  }

	  public void showNewManuscriptView() {
	    mainFrame.getContentPane().removeAll();
	    mainFrame.revalidate();
	    newManuscriptView = new NewManuscriptView();
	    mainFrame.add(newManuscriptView);
	    mainFrame.pack();
	  }
	  public void showStudyRoomView(String[][] data, String[] columnNames) {
		  
		  studyRoomView = new StudyRoomView(data, columnNames);
		  
	  }
	  
	  public void showEmployeeInformationView(String[][] data, String[] columnNames) {
		  
		  employeeInformationView = new EmployeeInformationView(data, columnNames);
		  
	  }
	  public void showEventInformationView(String[][] data, String[] columnNames) {
		  
		  eventInformationView = new EventInformationView(data, columnNames);
		  
	  }
	  public void showAccessInStudyRoomInformationView(String[][] data, String[] columnNames) {
		  
		  accessInStudyRoomInformationView = new AccesInStudyRoomInformationView(data, columnNames);
		  
	  }
	  public void showAddMemberInStudyRoomView() {
		  	mainFrame.getContentPane().removeAll();
		    mainFrame.revalidate();
		    addMemberInStudyRoomView = new AddMemberInStudyRoomView();
		    mainFrame.add(addMemberInStudyRoomView);
		    mainFrame.pack();
	  }

	  public MainFrame getMainFrame() {
	    return mainFrame;
	  }

	public DatabaseConnectionView getDatabaseConnectionView() {
		return databaseConnectionView;
	}

	public LogInView getLogInView() {
		return logInView;
	}

	public StartApplicationView getStartApplicationView() {
		return startApplicationView;
	}

	public BorrowBooksView getBorrowBooksView() {
		return borrowBooksView;
	}

	public ReservationView getReservationView() {
		return reservationView;
	}

	public BooksInformationView getBooksInformationView() {
		return booksInformationView;
	}

	public PrintedInformationView getPrintedInformationView() {
		return printedInformationView;
	}

	public ManuscriptInformationView getManuscriptInformationView() {
		return manuscriptInformationView;
	}

	public ReservationInformationView getReservationInformationView() {
		return reservationInformationView;
	}

	public BorrowedBooksInformationView getBorrowedBooksInformationView() {
		return borrowedBooksInformationView;
	}

	public MembersInformationView getMembersInformationView() {
		return membersInformationView;
	}

	public BorrowHistoryInformationView getBorrowHistoryInformationView() {
		return borrowHistoryInformationView;
	}

	public ReturnBorrowedBooksView getReturnBorrowedBooksView() {
		return returnBorrowedBooksView;
	}

	public CancelReservationView getCancelReservationView() {
		return cancelReservationView;
	}

	public NewMemberView getNewMemberView() {
		return newMemberView;
	}

	public NewLiteraryWorkView getNewLiteraryWorkView() {
		return newLiteraryWorkView;
	}

	public NewPrintedView getNewPrintedView() {
		return newPrintedView;
	}

	public NewManuscriptView getNewManuscriptView() {
		return newManuscriptView;
	}
	public StudyRoomView getNewStudyRoomView() {
		return studyRoomView;
	}
	public EmployeeInformationView getEmployeeInformationView() {
		return employeeInformationView;
	}
	public EventInformationView getEventInformationView() {
		return eventInformationView;
	}
	public AccesInStudyRoomInformationView getAccesInStudyRoomInformationView() {
		return accessInStudyRoomInformationView;
	}
	public AddMemberInStudyRoomView getAddMemberInStudyRoomView() {
		return addMemberInStudyRoomView;
	}

}
