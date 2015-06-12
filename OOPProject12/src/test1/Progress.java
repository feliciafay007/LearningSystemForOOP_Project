package test1;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;





	@Entity(name ="progresstable")  //entity name has to be changed before execution
	public class Progress implements Serializable {

	  /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		
		
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "scoreid")
	  private String scoreid;
	  
	  
	  @Column
	  private String studentID;
	  
	  @Column
	  private String sname; 
	  
	  @Column
	  private String date;
	  
	  
	  @Column
	  private String score;
	  
	  


	public String getScoreid() {
		return scoreid;
	}

	public void setScoreid(String scoreid) {
		this.scoreid = scoreid;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	// return number of columns in the table
	   public int getNumberOfColumns() {
		   return 5;
	   }
	   
	   // return the data in column i
	   public String getColumnData(int i) throws Exception {
		   if (i == 0)
			   return getScoreid();
		   else if (i == 1)
			   return getStudentID();
		   else if (i == 2) 
			   return getSname();
		   else if (i == 3)
			   return getDate();
		   else if (i == 4)
			   return getScore();
		   else
			   throw new Exception("Error: invalid column index in studentinfo table");    
	   }
	   
	   // return the name of column i
	   public String getColumnName(int i) throws Exception {
		   String colName = null;
		   if (i == 0) 
			   colName = "Score Id";
		   else if (i == 1)
			   colName = "Student Id";
		   else if (i == 2)
			   colName = "Student Name";
		   else if (i == 3)
			   colName = "Date";
		   else if (i == 4)
			   colName = "Score";
		   else 
			   throw new Exception("Access to invalid column number in studentinfo table");
		   
		   return colName;
	   }
	   
	   // set data column i to value
	   public void setColumnData(int i, Object value) throws Exception {
		   if (i == 0) 
			   scoreid = (String) value;
		   else if (i == 1) 
			   studentID = (String) value;
		   else if (i == 2) 
			   sname =  (String) value;
		   else if (i == 3)
			  date = (String) value;
		   if (i == 4) 
			   score = (String) value;
		   else
			   throw new Exception("Error: invalid column index in studentinfo table");    
	   }
	   
	  @Override
	  public String toString() {
	    return "Progress [Score ID =" + scoreid + ", "
	    	    + " Student ID =" + studentID + ","
	    	    + " Name =" + sname + ","
	    	    + " Date =" + date + ","
	    	    + " Score ="+score+","
	        + "]";
	  }

	}
