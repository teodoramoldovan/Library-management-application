package libraryBD;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ReturnBorrowedBooksView extends JPanel {
	
	 private static final long serialVersionUID = 1L;

	  private JLabel memberIDLabel;
	  private JLabel borrowIDLabel;
	  private JTextField memberIDTextField;
	  private JTextField borrowedIDTextField;
	  private JButton cancelButton;
	  private JButton returnBorrowedMediaButton;

	  private GridBagConstraints constraints;

	  public ReturnBorrowedBooksView() {
	    setLayout(new GridBagLayout());

	    memberIDLabel = new JLabel("Member ID :");
	    borrowIDLabel = new JLabel("Borrow ID:");
	    memberIDTextField = new JTextField();
	    borrowedIDTextField = new JTextField();
	    cancelButton = new JButton("Cancel");
	    returnBorrowedMediaButton = new JButton("Return Book");

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

	    constraints.gridy++;
	    constraints.gridx--;
	    add(borrowIDLabel, constraints);

	    constraints.gridx++;
	    add(borrowedIDTextField, constraints);

	    constraints.gridy++;
	    constraints.gridx--;
	    add(cancelButton, constraints);

	    constraints.gridx++;
	    add(returnBorrowedMediaButton, constraints);
	  }

	  public void addCancelButtonActionListener(ActionListener actionListener) {
	    cancelButton.addActionListener(actionListener);
	  }

	  public void addReturnBorrowedBooksButtonActionListener(ActionListener actionListener) {
	    returnBorrowedMediaButton.addActionListener(actionListener);
	  }

	  public JTextField getMemberIDTextField() {
	    return memberIDTextField;
	  }

	  public JTextField getBorrowedIDTextField() {
	    return borrowedIDTextField;
	  }

}
