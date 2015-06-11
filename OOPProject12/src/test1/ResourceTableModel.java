package test1;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.table.AbstractTableModel;

public class ResourceTableModel extends AbstractTableModel {
	  List<Simpleresource> simpleResourceList;   
	  private static final String PERSISTENCE_UNIT_NAME = "OOPProject12";  //待修改Used in persistence.xml
	  private static EntityManagerFactory factory;  
	  private EntityManager manager; 
	  private Simpleresource simpleResource;
	  private ResourceService resourceService;
	  private int numcols, numrows; 

	  ResourceTableModel () {
	    factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	    manager = factory.createEntityManager();
	    simpleResource= new Simpleresource();
	    resourceService = new ResourceService(manager);
	    
	    simpleResourceList = resourceService.readAll();
	    
	    // update the number of rows and columns in the model
	    numrows = simpleResourceList.size();
	    numcols = simpleResource.getNumberOfColumns();
    }

	 // returns a count of the number of rows
	 public int getRowCount() {
		return numrows;
	 }
	
	 // returns a count of the number of columns
	 public int getColumnCount() {
		return numcols;
	 }
	
	 // returns the data at the given row and column number
	 public Object getValueAt(int row, int col) {
		try {
		  return simpleResourceList.get(row).getColumnData(col);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	 }
	
	 // table cells are not editable
	 public boolean isCellEditable(int rowIndex, int colIndex) {
		return false;
	 }
	
	 public Class<?> getColumnClass(int col) {
		return getValueAt(0, col).getClass();
	 }
	
	 // returns the name of the column
	 public String getColumnName(int col) {
		   try {
				return simpleResource.getColumnName(col);
			} catch (Exception err) {
	             return err.toString();
	       }             
	 }
	
	 // update the data in the given row and column to aValue
	 public void setValueAt(Object aValue, int row, int col) {
		//data[rowIndex][columnIndex] = (String) aValue;
		try {
		   Simpleresource element = simpleResourceList.get(row);
                 element.setColumnData(col, aValue); 
          fireTableCellUpdated(row, col);
		} catch(Exception err) {
			err.toString();
		}	
	 }
	
	 public List<Simpleresource> getList() {
		 return simpleResourceList;
	 }

	 public EntityManager getEntityManager() {
	      return manager;
	 }


	 public ResourceTableModel(List<Simpleresource> list, EntityManager em)  {
	    simpleResourceList = list;
	    numrows = simpleResourceList.size();
	    simpleResource= new Simpleresource();
	   	numcols = simpleResource.getNumberOfColumns();     
		manager = em;  
		resourceService = new ResourceService(manager);
	 }
	 
	 // In this method, a newly inserted row in the GUI is added to the table model as well as the database table
	 // The argument to this method is an array containing the data in the textfields of the new row.
	 public void addRow(Object[] array) {
		//data[rowIndex][columnIndex] = (String) aValue;
			
		 EntityTransaction userTransaction = manager.getTransaction();  
			userTransaction.begin();
			Simpleresource newRecord = resourceService.createRecord((String) array[0], (String) array[1], (String) array[2]); 
			//resourceService.createCourse((String) array[0], (String) array[1], Integer.parseInt((String) array[2]), (String) array[3], (String) array[4]);
			userTransaction.commit();
			 
			// set the current row to rowIndex
			simpleResourceList.add(newRecord);
	        int row = simpleResourceList.size();  
	        int col = 0;

	        // update the data in the model to the entries in array
	         for (Object data : array) {
	          	 setValueAt((String) data, row-1, col++);
	         }
	         
	         numrows++;

	      // complete the code
	}	
	
}
