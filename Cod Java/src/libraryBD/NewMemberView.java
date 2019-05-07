package libraryBD;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NewMemberView extends JPanel {
	
	 private static final long serialVersionUID = 1L;

	  private JTextField lastNameTextField;
	  private JTextField firstNameTextField;
	  private JTextField streetTextField;
	  private JTextField numberTextField;
	  private JTextField cityTextField;
	  private JTextField jobTextField;
	  private JTextField birthDateTextField;
	  private JTextField sexTextField;
	  private JTextField emailTextField;

	  private JLabel lastNameLabel;
	  private JLabel firstNameLabel;
	  private JLabel streetLabel;
	  private JLabel numberLabel;
	  private JLabel cityLabel;
	  private JLabel jobLabel;
	  private JLabel birthDateLabel;
	  private JLabel sexLabel;
	  private JLabel emailLabel;

	  private JButton cancelButton;
	  private JButton createMemberButton;
	  private GridBagConstraints constraints;

	  public NewMemberView() {
	    lastNameTextField = new JTextField();
	    firstNameTextField=new JTextField();
	    streetTextField = new JTextField();
	    numberTextField = new JTextField();
	    cityTextField = new JTextField();
	    jobTextField = new JTextField();
	    birthDateTextField = new JTextField();
	    sexTextField = new JTextField();
	    emailTextField = new JTextField();

	    lastNameLabel = new JLabel("Last name: ");
	    firstNameLabel=new JLabel("First name: ");
	    streetLabel=new JLabel("Street: ");
	    numberLabel=new JLabel("Number: ");
	    cityLabel=new JLabel("City: ");
	    jobLabel=new JLabel("Job: ");
	    birthDateLabel=new JLabel("Birth date: ");
	    sexLabel=new JLabel("Sex: ");
	    emailLabel=new JLabel("Email: ");
	    

	    createMemberButton = new JButton("Add Member");
	    cancelButton = new JButton("Cancel");
	    
	    setLayout(new GridBagLayout());
	    
	    constraints = new GridBagConstraints();

	    constraints.fill = GridBagConstraints.BOTH;
	    constraints.gridx = 0;
	    constraints.gridy = 0;
	    constraints.insets = new Insets(5, 5, 5, 5);
	    constraints.anchor = GridBagConstraints.CENTER;
	    constraints.weightx = 0.5;
	    constraints.weighty = 0.5;
	    constraints.ipadx = 100;
	    
	    add(lastNameLabel, constraints);

	    constraints.gridx++;
	    add(lastNameTextField, constraints);
	    
	    constraints.gridx--;
	    constraints.gridy++;
	    add(firstNameLabel, constraints);

	    constraints.gridx++;
	    add(firstNameTextField, constraints);

	    constraints.gridy++;
	    constraints.gridx--;
	    add(streetLabel, constraints);

	    constraints.gridx++;
	    add(streetTextField, constraints);

	    constraints.gridy++;
	    constraints.gridx--;
	    add(numberLabel, constraints);

	    constraints.gridx++;
	    add(numberTextField, constraints);

	    constraints.gridy++;
	    constraints.gridx--;
	    add(cityLabel, constraints);

	    constraints.gridx++;
	    add(cityTextField, constraints);

	    constraints.gridy++;
	    constraints.gridx--;
	    add(jobLabel, constraints);

	    constraints.gridx++;
	    add(jobTextField, constraints);
	    
	    constraints.gridy++;
	    constraints.gridx--;
	    add(birthDateLabel, constraints);

	    constraints.gridx++;
	    add(birthDateTextField, constraints);
	    
	    constraints.gridy++;
	    constraints.gridx--;
	    add(sexLabel, constraints);

	    constraints.gridx++;
	    add(sexTextField, constraints);
	    
	    constraints.gridy++;
	    constraints.gridx--;
	    add(emailLabel, constraints);

	    constraints.gridx++;
	    add(emailTextField, constraints);

	    constraints.gridy++;
	    constraints.gridx--;
	    add(cancelButton, constraints);

	    constraints.gridx++;
	    add(createMemberButton, constraints);
	  }
	  
	  public void addCancelButtonActionListener(ActionListener actionListener) {
	    cancelButton.addActionListener(actionListener);
	  }
	  
	  public void addCreateMemberButtonActionListener(ActionListener actionListener) {
	    createMemberButton.addActionListener(actionListener);
	  }

	public JTextField getLastNameTextField() {
		return lastNameTextField;
	}

	public void setLastNameTextField(JTextField lastNameTextField) {
		this.lastNameTextField = lastNameTextField;
	}

	public JTextField getFirstNameTextField() {
		return firstNameTextField;
	}

	public void setFirstNameTextField(JTextField firstNameTextField) {
		this.firstNameTextField = firstNameTextField;
	}

	public JTextField getStreetTextField() {
		return streetTextField;
	}

	public void setStreetTextField(JTextField streetTextField) {
		this.streetTextField = streetTextField;
	}

	public JTextField getNumberTextField() {
		return numberTextField;
	}

	public void setNumberTextField(JTextField numberTextField) {
		this.numberTextField = numberTextField;
	}

	public JTextField getCityTextField() {
		return cityTextField;
	}

	public void setCityTextField(JTextField cityTextField) {
		this.cityTextField = cityTextField;
	}

	public JTextField getJobTextField() {
		return jobTextField;
	}

	public void setJobTextField(JTextField jobTextField) {
		this.jobTextField = jobTextField;
	}

	public JTextField getBirthDateTextField() {
		return birthDateTextField;
	}

	public void setBirthDateTextField(JTextField birthDateTextField) {
		this.birthDateTextField = birthDateTextField;
	}

	public JTextField getSexTextField() {
		return sexTextField;
	}

	public void setSexTextField(JTextField sexTextField) {
		this.sexTextField = sexTextField;
	}

	public JTextField getEmailTextField() {
		return emailTextField;
	}

	public void setEmailTextField(JTextField emailTextField) {
		this.emailTextField = emailTextField;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public void setCancelButton(JButton cancelButton) {
		this.cancelButton = cancelButton;
	}

	public JButton getCreateMemberButton() {
		return createMemberButton;
	}

	public void setCreateMemberButton(JButton createMemberButton) {
		this.createMemberButton = createMemberButton;
	}

	 

}
