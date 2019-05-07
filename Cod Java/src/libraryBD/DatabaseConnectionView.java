package libraryBD;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DatabaseConnectionView extends JPanel {
	 private static final long serialVersionUID = 1L;
	  private JLabel welcomeLabel;
	  private JButton connectAsMember;
	  private JButton connectAsEmployee;
	  private GridBagConstraints constraints;

	  public DatabaseConnectionView() {
	    setLayout(new GridBagLayout());

	    welcomeLabel = new JLabel("Welcome to Library Application!");
	    connectAsMember = new JButton("Connect as Member");
	    connectAsEmployee = new JButton("Connect as Employee");
	    constraints = new GridBagConstraints();

	    constraints.fill = GridBagConstraints.BOTH;
	    constraints.gridx = 0;
	    constraints.gridy = 0;
	    constraints.insets = new Insets(20, 110, 20, 5);
	    constraints.anchor = GridBagConstraints.CENTER;
	    constraints.weightx = 0.5;
	    constraints.weighty = 0.5;
	    connectAsMember.setPreferredSize(new Dimension(200, 50));
	    connectAsEmployee.setPreferredSize(new Dimension(200, 50));
	    
	    constraints.gridwidth = 2;
	    add(welcomeLabel, constraints);
	    
	    constraints.insets = new Insets(5, 5, 5, 5);
	    constraints.gridwidth = 1;
	    constraints.gridy++;
	    add(connectAsMember, constraints);

	    constraints.gridx++;
	    add(connectAsEmployee, constraints);
	  }

	  public void addConnectAsMemberButtonActionListener(ActionListener actionListener) {
	    connectAsMember.addActionListener(actionListener);
	  }

	  public void addConnectAsEmployeeButtonActionListener(ActionListener actionListener) {
	    connectAsEmployee.addActionListener(actionListener);
	  }

}
