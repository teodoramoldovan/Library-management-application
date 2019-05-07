package libraryBD;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NewLiteraryWorkView extends JPanel {
	
	
	private static final long serialVersionUID = 1L;

	 // private JLabel movieIDLabel;
	  private JLabel titleLabel;
	  private JLabel authorLabel;
	 // private JTextField movieIDTextField;
	  private JTextField titleTextField;
	  private JTextField authorTextField;
	  private JButton cancelButton;
	  private JButton insertLiteraryWorkButton;

	  private GridBagConstraints constraints;

	  public NewLiteraryWorkView() {
	    setLayout(new GridBagLayout());

	   // movieIDLabel = new JLabel("Movie ID:");
	    titleLabel = new JLabel("Title:");
	    authorLabel = new JLabel("Author:");
	   // movieIDTextField = new JTextField();
	    titleTextField = new JTextField();
	    authorTextField = new JTextField();
	    cancelButton = new JButton("Cancel");
	    insertLiteraryWorkButton = new JButton("Add Literary Work");
	    
	    constraints = new GridBagConstraints();

	    constraints.fill = GridBagConstraints.BOTH;
	    constraints.gridx = 0;
	    constraints.gridy = 0;
	    constraints.insets = new Insets(5, 5, 5, 5);
	    constraints.anchor = GridBagConstraints.CENTER;
	    constraints.weightx = 0.5;
	    constraints.weighty = 0.5;
	    constraints.ipadx = 100;

	   /* add(movieIDLabel, constraints);

	    constraints.gridx++;
	    add(movieIDTextField, constraints);*/

	    add(titleLabel, constraints);

	    constraints.gridx++;
	    add(titleTextField, constraints);

	    constraints.gridy++;
	    constraints.gridx--;
	    add(authorLabel, constraints);

	    constraints.gridx++;
	    add(authorTextField, constraints);

	    constraints.gridy++;
	    constraints.gridx--;
	    add(cancelButton, constraints);

	    constraints.gridx++;
	    add(insertLiteraryWorkButton, constraints);
	  }

	  public void addCancelButtonActionListener(ActionListener actionListener) {
	    cancelButton.addActionListener(actionListener);
	  }

	  public void addInsertLiteraryWorkButtonActionListener(ActionListener actionListener) {
	    insertLiteraryWorkButton.addActionListener(actionListener);
	  }

	 /* public JTextField getMovieIDTextField() {
	    return movieIDTextField;
	  }*/

	  public JTextField getTitleTextField() {
	    return titleTextField;
	  }

	  public JTextField getAuthorTextField() {
	    return authorTextField;
	  }

}
