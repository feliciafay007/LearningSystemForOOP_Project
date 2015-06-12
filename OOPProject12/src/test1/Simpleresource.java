package test1;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name = "simpleresource")
public class Simpleresource implements Serializable {
	  @Id
	  @GeneratedValue(strategy = GenerationType.TABLE)
	  @Column(name = "resource_id")
	  private String resource_id;

	  
	  @Column
	  private String resource_name;
	  
	  
	  @Column
	  private String resource_path;
	  
	  public String getResource_id() {
		return this.resource_id;  
	  }
	  
	  public void setResource_id(String rID) {
		resource_id = rID;  
	  }
	  
	  public String getResource_name() {
	    return this.resource_name;
	  }

	  public void setResource_name(String name) {
	    this.resource_name = name;
	  }

	  public String getResource_path() {
	    return this.resource_path;
	  }

	  public void setResource_path(String p) {
	    this.resource_path = p;
	  }
	  	   
	   public int getNumberOfColumns() {
		   return 3;
	   }
	   
	   // return the data in column i
	   public String getColumnData(int i) throws Exception {
		   if (i == 0)
			   return getResource_id();
		   else if (i == 1)
			   return getResource_name();
		   else if (i == 2) 
			   return getResource_path();
		   else  
			   throw new Exception("Error: invalid column index in simpleresource table");    
	   }
	   
	   // return the name of column i
	   public String getColumnName(int i) throws Exception {
		   String colName = null;
		   if (i == 0) 
			   colName = "resource_id";
		   else if (i == 1)
			   colName = "resource_name";
		   else if (i == 2)
			   colName = "resource_path";
		   else 
			   throw new Exception("Access to invalid column number in simpleresource table");
		   return colName;
	   }
	   
	   // set data column i to value
	   public void setColumnData(int i, Object value) throws Exception {
		   if (i == 0) 
			   resource_id= (String) value;
		   else if (i == 1)
			   resource_name= (String) value;
		   else if (i == 2) 
			   resource_path=  (String) value;
		   else
			   throw new Exception("Error: invalid column index in simpleresource table");    
	   }
	   
	  @Override
	  public String toString() {
	    return "simpleresource [resource_id = " + resource_id + ", "
	    		+ "resource_name = " + resource_name + ", "
	    	    + " resource_path = " + resource_path+ 
	    	    "]";
	  }
	  
	  public String getFilePath () {
		  try {
			  return this.getColumnData(2);
		  } catch (Exception e) {
			  System.out.println("getFilePath()" + e.getMessage());
		  }
		  return "";
	  }
}
