package libraryBD;

import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PrintedInformationView extends JDialog{
	
	 private static final long serialVersionUID = 1L;
	  private JTable printTable;
	  @SuppressWarnings("unused")
	  private String[][] data;
	  @SuppressWarnings("unused")
	  private String[] columnNames;

	  public PrintedInformationView(String[][] data, String[] columnNames) {
	    this.data = data;
	    this.columnNames = columnNames;

	    printTable = new JTable(data, columnNames);
	    add(new JScrollPane(printTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));

	    setLayout(new FlowLayout());
	    setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	    setLocationRelativeTo(null);
	    pack();
	    setVisible(true);
	  }

}
