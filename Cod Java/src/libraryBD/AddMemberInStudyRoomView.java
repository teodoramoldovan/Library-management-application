package libraryBD;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddMemberInStudyRoomView extends JPanel{
	
	private static final long serialVersionUID = 1L;

	  private JLabel memberIDLabel;
	  private JLabel studyRoomIDLabel;
	  private JLabel employeeIDLabel;
	  private JTextField memberIDTextField;
	  private JTextField studyRoomIDTextField;
	  private JTextField employeeIDTextField;
	  private JButton cancelButton;
	  private JButton createAccessButton;

	  private GridBagConstraints constraints;

	  public AddMemberInStudyRoomView() {
	    setLayout(new GridBagLayout());

	    memberIDLabel = new JLabel("Member ID:");
	    studyRoomIDLabel = new JLabel("Study Room ID:");
	    employeeIDLabel=new JLabel("Employee ID:");
	    memberIDTextField = new JTextField();
	    studyRoomIDTextField = new JTextField();
	    employeeIDTextField=new JTextField();
	    cancelButton = new JButton("Cancel");
	    createAccessButton = new JButton("Access");

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
	    add(studyRoomIDLabel, constraints);

	    constraints.gridx++;
	    add(studyRoomIDTextField, constraints);
	    
	    constraints.gridy++;
	    constraints.gridx--;
	    add(employeeIDLabel, constraints);

	    constraints.gridx++;
	    add(employeeIDTextField, constraints);

	    constraints.gridy++;
	    constraints.gridx--;
	    add(cancelButton, constraints);

	    constraints.gridx++;
	    add(createAccessButton, constraints);
	  }

	  public void addCancelButtonActionListener(ActionListener actionListener) {
	    cancelButton.addActionListener(actionListener);
	  }

	  public void addCreateAccessButtonActionListener(ActionListener actionListener) {
	    createAccessButton.addActionListener(actionListener);
	  }

	  public JTextField getMemberIDTextField() {
	    return memberIDTextField;
	  }
	  public JTextField getStudyRoomIDTextField() {
	    return studyRoomIDTextField;
	  }
	  public JTextField getEmployeeIDTextField() {
		  return employeeIDTextField;
	  }

}
