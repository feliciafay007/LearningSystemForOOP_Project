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
	  private String resource_mediatype;
	  
	  @Column
	  private String questionPath;
	  
	  @Column
	  private String questionAudioPath;
	  
	  @Column
	  private String questionLargeCate;
	  
	  @Column
	  private String questionSmallCate;
	  
	  @Column
	  private String optionA;
	  
	  @Column
	  private String optionB;
	  
	  @Column
	  private String optionC;
	  
	  @Column
	  private String optionCorrect;

	  @Column
	  private String difficultyLevel;	  
	  
	  public String getResource_id() {
		return this.resource_id;  
	  }
	  
	  public void setResource_id(String rID) {
		resource_id = rID;  
	  }
	  
	  public String getResource_mediatype() {
	    return this.resource_mediatype;

	  }

	  public void setResource_mediatype(String name) {
	    this.resource_mediatype = name;
	  }

	  public String getQuestionPath() {
	    return this.questionPath;
	  }

	  public void setQuestionPath(String p) {
	    this.questionPath = p;
	  }
	  	
	  public String getQuestionAudioPath() {
		    return this.questionAudioPath;
	  }

	  public void setQuestionAudioPath(String p) {
		    this.questionAudioPath = p;
	  }	  
	  
	  public String getQuestionLargeCate() {
		  return this.questionLargeCate;
	  }
	  
	  public void setQuestionLargeCate (String s) {
		  this.questionLargeCate = s;
	  }
	  
	  public String getQuestionSmallCate() {
		  return this.questionSmallCate;
	  }
	  
	  public void setQuestionSmallCate (String s) {
		  this.questionSmallCate = s;
	  }	  
	  
	  public String getOptionA() {
		  return this.optionA;
	  }
	  
	  public void setOptionA(String s ) {
		  this.optionA = s;
	  }	  
	  
	  public String getOptionB() {
		  return this.optionB;
	  }
	  
	  public void setOptionB(String s ) {
		  this.optionB = s;
	  }	  
	  
	  public String getOptionC() {
		  return this.optionC;
	  }
	  
	  public void setOptionC(String s ) {
		  this.optionC = s;
	  }	  	  
	  
	  public String getOptionCorrect() {
		  return this.optionCorrect;
	  }
	  
	  public void setOptionCorrect(String s ) {
		  this.optionCorrect = s;
	  }	  
	  
	  public String getDifficultyLevel() {
		  return this.difficultyLevel;
	  }
	  
	  public void setDifficultyLevel(String s ) {
		  this.difficultyLevel = s;
	  }	   
	  
	  public int getNumberOfColumns() {
		   return 3;
	  }
	  
	   
	   // return the data in column i
	   public String getColumnData(int i) throws Exception {
		   if (i == 0)
			   return getResource_id();
		   else if (i == 1)
			   return getResource_mediatype();
		   else if (i == 2) 
			   return getQuestionPath();
		   else if (i == 3) 
			   return getQuestionAudioPath();
		   else if (i == 4)
			   return getQuestionLargeCate();
		   else if (i == 5)
			   return getQuestionSmallCate();
		   else if (i == 6)
			   return getOptionA();
		   else if (i == 7)
			   return getOptionB();
		   else if (i == 8)
			   return getOptionC();
		   else if (i == 9)
			   return getOptionCorrect();
		   else if (i == 10)
			   return getDifficultyLevel();
		   else 
			   throw new Exception("Error: invalid column index in simpleresource table");    
	   }
	   
	   // return the name of column i
	   public String getColumnName(int i) throws Exception {
		   String colName = null;
		   if (i == 0) 
			   colName = "resource_id";
		   else if (i == 1)
			   colName = "resource_mediatype";
		   else if (i == 2)
			   colName = "questionPath";
		   else if (i == 3)
			   colName = "questionAudioPath";
		   else if (i == 4)
			   colName = "questionLargeCate";
		   else if (i == 5)
			   colName = "questionSmallCate";
		   else if (i == 6)
			   colName = "optionA";
		   else if (i == 7)
			   colName = "optionB";
		   else if (i == 8)
			   colName = "optionC";
		   else if (i == 9)
			   colName = "optionCorrect";
		   else if (i == 10)
			   colName = "difficultyLevel";
		   else
			   throw new Exception("Access to invalid column number in simpleresource table");
		   return colName;
	   }
	   
	   // set data column i to value
	   public void setColumnData(int i, Object value) throws Exception {
		   if (i == 0) 
			   resource_id= (String) value;
		   else if (i == 1)
			   resource_mediatype= (String) value;
		   else if (i == 2) 
			   questionPath =  (String) value;
		   else if (i == 3) 
			   questionAudioPath =  (String) value;
		   else if (i == 4) 
			   questionLargeCate =  (String) value;
		   else if (i == 5) 
			   questionSmallCate =  (String) value;
		   else if (i == 6) 
			   optionA =  (String) value;
		   else if (i == 7) 
			   optionB =  (String) value;
		   else if (i == 8) 
			   optionC =  (String) value;
		   else if (i == 9) 
			   optionCorrect =  (String) value;
		   else if (i == 10) 
			   difficultyLevel =  (String) value;		   
		   else
			   throw new Exception("Error: invalid column index in simpleresource table");    
	   }
	   
	  @Override
	  public String toString() {
	    return "simpleresource [resource_id = " + resource_id + ", "
	    		+ "resource_mediatype = " + resource_mediatype + ", "
	    	    + "questionPath = " + questionPath + ","
	    	    + "questionAudioPath = " + questionAudioPath  + ", " 
	    	    + "questionLargeCate = " + questionLargeCate + ", " 
	    	    + "questionSmallCate= " + questionSmallCate + ", " 
	    	    + "optionA = " + optionA  + ", " 
	    	    + "optionB = " + optionB + ", " 
	    	    + "optionC  = " + optionC + ", " 
	    	    + "optionCorrect  = " + optionCorrect + ", " 
	    	    + "difficultyLevel = " + difficultyLevel +  
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
