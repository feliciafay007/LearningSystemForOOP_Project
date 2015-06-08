import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;


public class TableModleExample extends AbstractTableModel{

	private String[] columnNames = {"country", "capital", "location", "currency", "population in million"};
	
	private String[][] data = {
		{"Canada", "Ottawa", "North America", "Canadian dollar", "38" },
		{"Germany", "Berlin", "Europe", "Euro", "82"},
		{"Indonesia", "Jakarta", "Asia", "Indonesian rupiah", "246.5"},
		{"Morocco", "Rabat", "Africa", "Moroccan dirham", "32.3"},
		{"Norway", "Oslo", "Europe", "Norwegian krone", "5"}
	};
	
	public int getRowCount() {
		return data.length;
	}
	
	public int getColumnCount() {
		return columnNames.length;
	}
	
	public Object getValueAt(int row, int col) {
		return data[row][col];
	}
	
	public boolean isCellEditable(int rowIndex, int colIndex) {
		return false;
	}
	
	public Class<?> getColumnClass(int col) {
		return getValueAt(0, col).getClass();
	}
	
	public String getColumnName(int col) {
		return columnNames[col];
	}
	
	
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

	  data[rowIndex][columnIndex] = (String) aValue;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// create a model of the table
		TableModleExample tableModel = new TableModleExample();
		// add the data and column names to a JTable
		JTable table  = new JTable(tableModel);
		// add the table to a scrollpane
		
		//add action listener
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				ListSelectionModel selectModel = (ListSelectionModel) e.getSource();
				int firstIndex = selectModel.getMinSelectionIndex();
				int lastIndex = selectModel.getMaxSelectionIndex();
						
				for (int i = firstIndex; i <=lastIndex; i++) {
						System.out.println("Row " +i +" selected");
				}
			}
		});

		//
		JScrollPane scrollpane = new JScrollPane(table);
		
		// create a window
		JFrame frame = new JFrame();
		JPanel panel = new JPanel(new BorderLayout());
		
		frame.setContentPane(panel);
		// add the scrollpane to the center of the BorderLayour
		panel.add(scrollpane, BorderLayout.CENTER);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
