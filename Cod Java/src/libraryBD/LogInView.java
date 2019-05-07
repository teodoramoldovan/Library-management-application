package libraryBD;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LogInView extends JPanel{
	
	private static final long serialVersionUID = 1L;
	  private JLabel email;
	  private JLabel password;
	  private JTextField emailTextField;
	  private JTextField passwordTextField;
	  private JButton logInButton;
	  private JButton cancelButton;
	  private GridBagConstraints constraints;

	  public LogInView() {
	    email = new JLabel("E-mail: ");
	    password = new JLabel("Password: ");
	    emailTextField = new JTextField();
	    passwordTextField = new JTextField();
	    constraints = new GridBagConstraints();
	    logInButton = new JButton("Log In");
	    cancelButton = new JButton("Cancel");

	    setLayout(new GridBagLayout());

	    // constraints for the email JLabel
	    constraints.fill = GridBagConstraints.BOTH;
	    constraints.gridx = 0;
	    constraints.gridy = 0;
	    constraints.insets = new Insets(5, 5, 5, 5);
	    constraints.anchor = GridBagConstraints.CENTER;
	    constraints.weightx = 0.5;
	    constraints.weighty = 0.5;
	    add(email, constraints);

	    // constraints for the email text field
	    constraints.gridx++;
	    constraints.ipadx = 100;
	    add(emailTextField, constraints);

	    // constraints for the password label
	    constraints.gridx--;
	    constraints.gridy++;
	    constraints.ipadx = 0;
	    add(password, constraints);

	    // constraints for the password text field
	    constraints.gridx++;
	    constraints.ipadx = 120;
	    add(passwordTextField, constraints);

	    // constraints for the log in button
	    constraints.gridx--;
	    constraints.gridy++;
	    add(cancelButton, constraints);

	    // constraints for the new account button
	    constraints.gridx++;
	    add(logInButton, constraints);
	  }

	  public void addLogInButtonActionListener(ActionListener actionListener) {
	    logInButton.addActionListener(actionListener);
	  }

	  public void addCancelButtonActionListener(ActionListener actionListener) {
	    cancelButton.addActionListener(actionListener);
	  }

	  public JTextField getEmailTextField() {
	    return emailTextField;
	  }

	  public JTextField getPasswordTextField() {
	    return passwordTextField;
	  }

}
