package test1;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.*;
import javax.swing.table.*;
import java.util.*;


public class StudentTableModel extends AbstractTableModel {

	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<StudentInfo> studentinfoResultList;   // stores the model data in a List collection of type StudentInfo
	  private static final String PERSISTENCE_UNIT_NAME = "OOPProject12";  // Used in persistence.xml
	  private static EntityManagerFactory factory;  // JPA  
	  private EntityManager manager;		      // JPA 
	  private StudentInfo StudentInfo;// represents the entity StudentInfo

      // This field contains additional information about the results   
	  private StudentInfoService studentinfoservice;
	
	 
	  private int numcols, numrows; // number of rows and columns

	 StudentTableModel() {
	    factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	    manager = factory.createEntityManager();
	    StudentInfo = new StudentInfo();
	    studentinfoservice = new StudentInfoService(manager);
	    
	    // read all the records from StudentInfo
	    
	    studentinfoResultList = studentinfoservice.readAll();
	    
	    // update the number of rows and columns in the model
	    numrows = studentinfoResultList.size();
	    numcols = StudentInfo.getNumberOfColumns();
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
		  return studentinfoResultList.get(row).getColumnData(col);
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
				return StudentInfo.getColumnName(col);
			} catch (Exception err) {
	             return err.toString();
	       }             
	 }
	
	 // update the data in the given row and column to aValue
	 public void setValueAt(Object aValue, int row, int col) {
		//data[rowIndex][columnIndex] = (String) aValue;
		try {
		   StudentInfo element = studentinfoResultList.get(row);
                   element.setColumnData(col, aValue); 
            fireTableCellUpdated(row, col);
		} catch(Exception err) {
			err.toString();
		}	
	 }
	
	 public List<StudentInfo> getList() {
		 return studentinfoResultList;
	 }

	 public EntityManager getEntityManager() {
	      return manager;
	 }

	 // create a new table model using the existing data in list
	 public StudentTableModel(List<StudentInfo> list, EntityManager em)  {
		 studentinfoResultList = list;
	    numrows = studentinfoResultList.size();
	    StudentInfo = new StudentInfo();
	   	numcols = StudentInfo.getNumberOfColumns();     
		manager = em;  
		studentinfoservice = new StudentInfoService(manager);
	 }
	 
	 // In this method, a newly inserted row in the GUI is added to the table model as well as the database table
	 // The argument to this method is an array containing the data in the textfields of the new row.
	 public void addRow(Object[] array) {
		//data[rowIndex][columnIndex] = (String) aValue;
			
		 EntityTransaction userTransaction = manager.getTransaction();  
			userTransaction.begin();
			StudentInfo newRecord = studentinfoservice.createCourse((String) array[0], (String) array[1],(String) array[2],(String) array[3]);
			userTransaction.commit();
			 
			// set the current row to rowIndex
	        studentinfoResultList.add(newRecord);
	        int row = studentinfoResultList.size();  
	        int col = 0;

	        // update the data in the model to the entries in array
	         for (Object data : array) {
	          	 setValueAt((String) data, row-1, col++);
	         }
	         
	         numrows++;

	     
	}	
	 
	 public void updateRow(Object[] array) {
			    //data[rowIndex][columnIndex] = (String) aValue;
				
			 EntityTransaction userTransaction = manager.getTransaction();  
				userTransaction.begin();
				//StudentInfo newRecord = studentinfoservice.updateCourse((String) array[0], (String) array[1],(String) array[2],(String) array[3]);
				userTransaction.commit();
				 
				// set the current row to rowIndex
				//studentinfoResultList.remove(newRecord);
				//studentinfoResultList.add(newRecord);
		        //studentinfoResultList.remove(newRecord);
		        int row = studentinfoResultList.size();  
		        int col = 0;

	       //  update the data in the model to the entries in array
		         for (Object data : array) {
		          
		        	 setValueAt((String) data, row-1, col++);
		         }
		         
		        // numrows++;

		      		}	
	 
	 
	 
	 
	 
	 
	 public void deleteRow(Object[] array) {
			//data[rowIndex][columnIndex] = (String) aValue;
				
			 EntityTransaction userTransaction = manager.getTransaction();  
				userTransaction.begin();
				 studentinfoservice.deleteCourse((String) array[0]);
				userTransaction.commit();
				
				
				studentinfoResultList = studentinfoservice.readAll();
		         numrows--;
		         
		         fireTableDataChanged();  
				 
		         
				// set the current row to rowIndex
				//studentinfoResultList.remove(newRecord);
				//int row = studentinfoResultList.size(); 
		        //studentinfoResultList.remove(row);
		         
		        //int col = 0;

	       //  update the data in the model to the entries in array
		       //  for (Object data : array) {
		          
		        //	 setValueAt((String) data, row-1, col++);
		         //}
		         
		        // numrows;

		      // complete the code
		}	
	  
	 
	 
	 
	 
	 
	 
	 
	 
}

