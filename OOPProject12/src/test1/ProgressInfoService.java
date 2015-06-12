package test1;


import javax.persistence.*;

import java.util.*;

public class ProgressInfoService  {
	 private EntityManager manager;
	 
	  public ProgressInfoService(EntityManager manager) {
		 this.manager = manager;
	 }


	 public Progress createCourse(String scoreid, String studentid,String name, String date, String Score) {
			Progress progress = new Progress();
		     progress.setScoreid(scoreid);
			progress.setStudentID(studentid);
			progress.setSname(name);
			progress.setDate(date);
			progress.setScore(Score);
			manager.persist(progress);
			return progress;
		}




	 

//      public StudentInfo readCourse(String id) {
//    	 StudentInfo student = manager.find(StudentInfo.class,id);
//    	 return student;   	 
//     }

    
     public List<Progress> readAll() {
    	 
    	 TypedQuery<Progress> query = manager.createQuery("SELECT c FROM progresstable c", Progress.class);
    	 List<Progress> result =  query.getResultList();
    	 return result;   	 
     }
     
     
     
     
     
     
     
     
     
     
     
     
    // method to update a record
     public Progress updateprogress(String scoreid,String studentid, String name, String date, String score) {
    	Progress progress = manager.find(Progress.class,scoreid);
    	 if (progress != null) {
    		 progress.setStudentID(studentid);
    		 progress.setSname(name);
    		 progress.setDate(date);
    		 progress.setScore(score);
    		
    	 }
    	 return progress;
     }

    // method to delete a record
    public void deleteProgress(String id) {
    	 Progress progress = (Progress) manager.find(Progress.class, id);
    	 if (progress != null) {
    		 manager.remove(progress);
    	 }
    }





}
