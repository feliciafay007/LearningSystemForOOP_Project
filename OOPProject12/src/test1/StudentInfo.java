package test1;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


	@Entity(name ="studentinfo")  //entity name has to be changed before execution
	public class StudentInfo implements Serializable {

	  /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	@Column(name = "sName")
	  private String student_name;
	  
	  @Id
	  @GeneratedValue(strategy = GenerationType.TABLE)
	  @Column
	  private String sID;
	  
	  @Column
	  private String sAge; 
	  
	  @Column
	  private String contactNo;
	  
	  
	   
	   public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public String getsID() {
		return sID;
	}

	public void setsID(String sID) {
		this.sID = sID;
	}

	public String getsAge() {
		return sAge;
	}

	public void setsAge(String sAge) {
		this.sAge = sAge;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	// return number of columns in the table
	   public int getNumberOfColumns() {
		   return 4;
	   }
	   
	   // return the data in column i
	   public String getColumnData(int i) throws Exception {
		   if (i == 0)
			   return getsID();
		   else if (i == 1)
			   return getStudent_name();
		   else if (i == 2) 
			   return getsAge();
		   else if (i == 3)
			   return getContactNo();
		   else
			   throw new Exception("Error: invalid column index in studentinfo table");    
	   }
	   
	   // return the name of column i
	   public String getColumnName(int i) throws Exception {
		   String colName = null;
		   if (i == 0) 
			   colName = "Student ID";
		   else if (i == 1)
			   colName = "Student Name";
		   else if (i == 2)
			   colName = "Age";
		   else if (i == 3)
			   colName = "Contact No";
		   else 
			   throw new Exception("Access to invalid column number in studentinfo table");
		   
		   return colName;
	   }
	   
	   // set data column i to value
	   public void setColumnData(int i, Object value) throws Exception {
		   if (i == 0) 
			   sID = (String) value;
		   else if (i == 1) 
			   student_name = (String) value;
		   else if (i == 2) 
			   sAge =  (String) value;
		   else if (i == 3)
			   contactNo = (String) value;
		   else
			   throw new Exception("Error: invalid column index in studentinfo table");    
	   }
	   
	  @Override
	  public String toString() {
	    return "StudentInfo [Student ID =" + sID + ", "
	    	    + " Student Name =" + student_name + ","
	    	    + " Age =" + sAge + ","
	    	    + " Contact No =" + contactNo + ","
	        + "]";
	  }

	}


