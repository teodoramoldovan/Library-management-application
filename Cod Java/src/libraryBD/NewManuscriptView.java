package libraryBD;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NewManuscriptView extends JPanel{
	
	private static final long serialVersionUID = 1L;

	  private JLabel bookISBNLabel;
	  private JLabel languageLabel;
	  private JLabel numberOfCopiesLabel;
	  private JLabel availableNumberOFCopiesLabel;
	  private JLabel categoryLabel;
	  private JLabel statusLabel;
	  private JLabel locationInLibraryLabel;
	  private JLabel penaltyChargeLabel;
	  private JLabel literaryWorkIDLabel;
	  private JLabel publishingYearLabel;
	  private JTextField bookISBNTextField;
	  private JTextField languageTextField;
	  private JTextField numberOfCopiesTextField;
	  private JTextField availableNumberOfCopiesTextField;
	  private JTextField categoryTextField;
	  private JTextField statusTextField;
	  private JTextField locationInLibraryTextField;
	  private JTextField penaltyChargeTextField;
	  private JTextField literaryWorkIDTextField;
	  private JTextField publishingYearTextField;
	  
	  private JButton cancelButton;
	  private JButton insertManuscriptButton;

	  private GridBagConstraints constraints;

	  public NewManuscriptView() {
	    setLayout(new GridBagLayout());
	    bookISBNLabel = new JLabel("Book ISBN:");
		languageLabel = new JLabel("Language:");
		numberOfCopiesLabel = new JLabel("Number of Copies:");
		availableNumberOFCopiesLabel = new JLabel("Available number of copies:");
		categoryLabel = new JLabel("Category:");
		statusLabel = new JLabel("Status:");
		locationInLibraryLabel = new JLabel("Location in library:");
		penaltyChargeLabel = new JLabel("Penalty Charge:");
		literaryWorkIDLabel = new JLabel("Literary Work:");
		publishingYearLabel = new JLabel("Publishing year:");
		bookISBNTextField= new JTextField();
		languageTextField= new JTextField();
		numberOfCopiesTextField= new JTextField();
		availableNumberOfCopiesTextField= new JTextField();
		categoryTextField= new JTextField();
		statusTextField= new JTextField();
		locationInLibraryTextField= new JTextField();
		penaltyChargeTextField= new JTextField();
		literaryWorkIDTextField= new JTextField();
		publishingYearTextField=new JTextField();

	    cancelButton = new JButton("Cancel");
	    insertManuscriptButton = new JButton("Add Manuscript");

	    constraints = new GridBagConstraints();

	    constraints.fill = GridBagConstraints.BOTH;
	    constraints.gridx = 0;
	    constraints.gridy = 0;
	    constraints.insets = new Insets(5, 5, 5, 5);
	    constraints.anchor = GridBagConstraints.CENTER;
	    constraints.weightx = 0.5;
	    constraints.weighty = 0.5;
	    constraints.ipadx = 100;

	    add(bookISBNLabel, constraints);

	    constraints.gridx++;
	    add(bookISBNTextField, constraints);

	    constraints.gridy++;
	    constraints.gridx--;
	    add(languageLabel, constraints);

	    constraints.gridx++;
	    add(languageTextField, constraints);

	    constraints.gridy++;
	    constraints.gridx--;
	    add(numberOfCopiesLabel, constraints);

	    constraints.gridx++;
	    add(numberOfCopiesTextField, constraints);

	    constraints.gridy++;
	    constraints.gridx--;
	    add(availableNumberOFCopiesLabel, constraints);

	    constraints.gridx++;
	    add(availableNumberOfCopiesTextField, constraints);

	    constraints.gridy++;
	    constraints.gridx--;
	    add(categoryLabel, constraints);

	    constraints.gridx++;
	    add(categoryTextField, constraints);

	    constraints.gridy++;
	    constraints.gridx--;
	    add(statusLabel, constraints);

	    constraints.gridx++;
	    add(statusTextField, constraints);

	    constraints.gridy++;
	    constraints.gridx--;
	    add(locationInLibraryLabel, constraints);

	    constraints.gridx++;
	    add(locationInLibraryTextField, constraints);
	    
	    constraints.gridy++;
	    constraints.gridx--;
	    add(penaltyChargeLabel, constraints);

	    constraints.gridx++;
	    add(penaltyChargeTextField, constraints);
	    
	    constraints.gridy++;
	    constraints.gridx--;
	    add(literaryWorkIDLabel, constraints);

	    constraints.gridx++;
	    add(literaryWorkIDTextField, constraints);
	    
	    constraints.gridy++;
	    constraints.gridx--;
	    add(publishingYearLabel, constraints);

	    constraints.gridx++;
	    add(publishingYearTextField, constraints);

	    constraints.gridy++;
	    constraints.gridx--;
	    add(cancelButton, constraints);

	    constraints.gridx++;
	    add(insertManuscriptButton, constraints);
	  }

	  public void addCancelButtonActionListener(ActionListener actionListener) {
	    cancelButton.addActionListener(actionListener);
	  }

	  public void addInsertManuscriptButtonActionListener(ActionListener actionListener) {
	    insertManuscriptButton.addActionListener(actionListener);
	  }

	public JTextField getBookISBNTextField() {
		return bookISBNTextField;
	}



	public JTextField getLanguageTextField() {
		return languageTextField;
	}



	public JTextField getNumberOfCopiesTextField() {
		return numberOfCopiesTextField;
	}


	public JTextField getAvailableNumberOfCopiesTextField() {
		return availableNumberOfCopiesTextField;
	}



	public JTextField getCategoryTextField() {
		return categoryTextField;
	}



	public JTextField getStatusTextField() {
		return statusTextField;
	}


	public JTextField getLocationInLibraryTextField() {
		return locationInLibraryTextField;
	}



	public JTextField getPenaltyChargeTextField() {
		return penaltyChargeTextField;
	}



	public JTextField getLiteraryWorkIDTextField() {
		return literaryWorkIDTextField;
	}



	public JTextField getPublishingYearTextField() {
		return publishingYearTextField;
	}

}
