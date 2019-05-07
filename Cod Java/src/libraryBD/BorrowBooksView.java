package libraryBD;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BorrowBooksView extends JPanel {
	
	 private static final long serialVersionUID = 1L;

	  private JLabel memberIDLabel;
	 // private JLabel valabilityDateLabel;
	  private JLabel bookISBNLabel;
	  private JTextField memberIDTextField;
	 // private JTextField valabilityDateTextField;
	  private JTextField bookISBNTextField;
	  private JButton cancelButton;
	  private JButton createBorrowButton;

	  private GridBagConstraints constraints;

	  public BorrowBooksView() {
	    setLayout(new GridBagLayout());

	    memberIDLabel = new JLabel("Member ID:");
	   // valabilityDateLabel = new JLabel("Valability Date:");
	    bookISBNLabel = new JLabel("Book ISBN:");
	    memberIDTextField = new JTextField();
	   // valabilityDateTextField = new JTextField();
	    bookISBNTextField = new JTextField();
	    cancelButton = new JButton("Cancel");
	    createBorrowButton = new JButton("Borrow");

	    constraints = new GridBagConstraints();

	    constraints.fill = GridBagConstraints.BOTH;
	    constraints.gridx = 0;
	    constraints.gridy = 0;
	    constraints.insets = new Insets(5, 5, 5, 5);
	    constraints.anchor = GridBagConstraints.CENTER;
	    constraints.weightx = 0.5;
	    constraints.weighty = 0.5;
	    constraints.ipadx = 100;

	    add(memberIDLabel, constraints);

	    constraints.gridx++;
	    add(memberIDTextField, constraints);

	    /*constraints.gridy++;
	    constraints.gridx--;
	    add(valabilityDateLabel, constraints);

	    constraints.gridx++;
	    add(valabilityDateTextField, constraints);*/

	    constraints.gridy++;
	    constraints.gridx--;
	    add(bookISBNLabel, constraints);

	    constraints.gridx++;
	    add(bookISBNTextField, constraints);

	    constraints.gridy++;
	    constraints.gridx--;
	    add(cancelButton, constraints);

	    constraints.gridx++;
	    add(createBorrowButton, constraints);
	  }

	  public void addCancelButtonActionListener(ActionListener actionListener) {
	    cancelButton.addActionListener(actionListener);
	  }

	  public void addCreateBorrowButtonActionListener(ActionListener actionListener) {
	    createBorrowButton.addActionListener(actionListener);
	  }

	  public JTextField getMemberIDTextField() {
	    return memberIDTextField;
	  }

	 /* public JTextField getValabilityDateTextField() {
	    return valabilityDateTextField;
	  }*/

	  public JTextField getBookISBNTextField() {
	    return bookISBNTextField;
	  }

}
