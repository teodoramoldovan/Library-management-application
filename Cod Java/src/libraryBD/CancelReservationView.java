package libraryBD;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CancelReservationView extends JPanel {
	
	private static final long serialVersionUID = 1L;

	  private JLabel memberIDLabel;
	  private JLabel reservationIDLabel;
	  private JTextField memberIDTextField;
	  private JTextField reservationIDTextField;
	  private JButton cancelButton;
	  private JButton cancelReservationButton;

	  private GridBagConstraints constraints;

	  public CancelReservationView() {
	    setLayout(new GridBagLayout());

	    memberIDLabel = new JLabel("Member ID :");
	    reservationIDLabel = new JLabel("Reservation ID:");
	    memberIDTextField = new JTextField();
	    reservationIDTextField = new JTextField();
	    cancelButton = new JButton("Cancel");
	    cancelReservationButton = new JButton("Cancel Reservation");

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
	    add(reservationIDLabel, constraints);

	    constraints.gridx++;
	    add(reservationIDTextField, constraints);

	    constraints.gridy++;
	    constraints.gridx--;
	    add(cancelButton, constraints);

	    constraints.gridx++;
	    add(cancelReservationButton, constraints);
	  }

	  public void addCancelButtonActionListener(ActionListener actionListener) {
	    cancelButton.addActionListener(actionListener);
	  }

	  public void addCancelReservationButtonActionListener(ActionListener actionListener) {
	    cancelReservationButton.addActionListener(actionListener);
	  }

	  public JTextField getMemberIDTextField() {
	    return memberIDTextField;
	  }

	  public JTextField getReservationIDTextField() {
	    return reservationIDTextField;
	  }

}
