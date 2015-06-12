package test1;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;


public class  ProgressController implements ListSelectionListener, TableModelListener{
	private ProgressTableModel tableModel;
	private ProgressGui gui;
	
	public  ProgressController(ProgressGui gui) {
		this.gui = gui;   
         // create the tableModel using the data in the cachedRowSet
    		tableModel = new ProgressTableModel(); 
    		tableModel.addTableModelListener(this);
	}
	
	
	// new code
	public TableModel getTableModel() {
		return tableModel;
	}
	
	public void valueChanged(ListSelectionEvent e) {
		ListSelectionModel selectModel = (ListSelectionModel) e.getSource();
		int firstIndex = selectModel.getMinSelectionIndex();
		
		// read the data in each column using getValueAt and display it on corresponding textfield
		gui.setscoreidfield((String)tableModel.getValueAt(firstIndex, 0));
		gui.setSidfield((String) tableModel.getValueAt(firstIndex, 1));
		gui.setSnamefield((String) tableModel.getValueAt(firstIndex, 2));
		gui.setDateTextField((String) tableModel.getValueAt(firstIndex, 3));
		gui.setScoreField((String) tableModel.getValueAt(firstIndex, 3));
	}
	

	
	public void tableChanged(TableModelEvent e)
	{
	   try {
	    	// get the index of the inserted row
	        //tableModel.getRowSet().moveToCurrentRow();
	    	int firstIndex =  e.getFirstRow();
	    	
	    	// create a new table model with the new data
	        tableModel = new ProgressTableModel(tableModel.getList(), tableModel.getEntityManager());
	        tableModel.addTableModelListener(this);
	        // update the JTable with the data
	    	gui.updateTable();
	    
	        // read the data in each column using getValueAt and display it on corresponding textfield
			gui.setscoreidfield((String)tableModel.getValueAt(firstIndex, 0));
			gui.setSidfield((String) tableModel.getValueAt(firstIndex, 1));
			gui.setSnamefield((String) tableModel.getValueAt(firstIndex, 2));
			gui.setDateTextField((String) tableModel.getValueAt(firstIndex, 3));
			gui.setScoreField((String) tableModel.getValueAt(firstIndex, 3));
			
	} catch(Exception exp) {
		exp.getMessage();
		exp.printStackTrace();
	}
	}
	
	public void addRow(String[] array) {
		tableModel.addRow(array);			
	}
	
	public void updateRow(String[] array) {
		tableModel.updateRow(array);			
	}

	
	public void deleteRow(String[] array) {
		tableModel.deleteRow(array);			
	}	
	
}
