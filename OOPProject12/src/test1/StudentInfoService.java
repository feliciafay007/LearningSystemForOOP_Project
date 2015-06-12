package test1;

	import javax.persistence.*;

import java.util.*;

	public class StudentInfoService  {
		 private EntityManager manager;
		 
		 public StudentInfoService(EntityManager manager) {
			 this.manager = manager;
		 }
	
	
		 public StudentInfo createCourse(String id, String name,String age, String contactno) {
				StudentInfo student = new StudentInfo();
				student.setsID(id);
				student.setStudent_name(name);
				student.setsAge(age);
				student.setContactNo(contactno);
				manager.persist(student);
				return student;
			}

	

	
		 
	
//	      public StudentInfo readCourse(String id) {
//	    	 StudentInfo student = manager.find(StudentInfo.class,id);
//	    	 return student;   	 
//	     }

	    
	     public List<StudentInfo> readAll() {
	    	 
	    	 TypedQuery<StudentInfo> query = manager.createQuery("SELECT e FROM studentinfo e", StudentInfo.class);
	    	 List<StudentInfo> result =  query.getResultList();
	    	 return result;   	 
	     }
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
	    // method to update a record
	     public StudentInfo updateCourse(String id, String name, String age, String no) {
	    	StudentInfo student = manager.find(StudentInfo.class,id);
	    	 if (student != null) {
	    		 student.setStudent_name(name);;
	    		 student.setsAge(age);;
	    		 student.setContactNo(no);;
	    		
	    	 }
	    	 return student;
	     }

	    // method to delete a record
	    public void deleteCourse(String id) {
	    	 StudentInfo student = (StudentInfo) manager.find(StudentInfo.class, id);
	    	 if (student != null) {
	    		 manager.remove(student);
	    	 }
	    }
	



	
}
