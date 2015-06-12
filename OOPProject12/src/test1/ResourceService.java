package test1;

import javax.persistence.*;
import java.util.*;

public class ResourceService {
	 private EntityManager manager;
	 
	 public ResourceService(EntityManager manager) {
		 this.manager = manager;
	 }
	 
    // method to create a new record
     public Simpleresource createRecord(
    		 String resourceID, 
    		 String resourceMediatype, 
    		 String questionPath,
    		 String questionAudioPath,
    		 String questionLargeCate,
    		 String questionSmallCate,
    		 String optionA,
    		 String optionB,
    		 String optionC,
    		 String optionCorrect,
    		 String difficultyLevel) {
    	Simpleresource  simRes = new Simpleresource ();
    	simRes.setResource_id(resourceID);
    	simRes.setResource_mediatype(resourceMediatype);
    	simRes.setQuestionPath(questionPath);
    	simRes.setQuestionAudioPath(questionAudioPath);
    	simRes.setQuestionLargeCate(questionLargeCate);
    	simRes.setQuestionSmallCate(questionSmallCate);
    	simRes.setOptionA(optionA);
    	simRes.setOptionB(optionB);
    	simRes.setOptionC(optionC);
    	simRes.setDifficultyLevel(difficultyLevel);
    	manager.persist(simRes);
 	    return simRes;
     }
    
    // method to read a record
     public Simpleresource readRecord(String resourceID) {
    	 Simpleresource simRes = manager.find(Simpleresource.class, resourceID);
    	 return simRes;   	 
     }

     // method to read all records
     public List<Simpleresource> readAll() {
    	 TypedQuery<Simpleresource> query = manager.createQuery("SELECT e FROM simpleresource e", Simpleresource.class);
    	 List<Simpleresource> result =  query.getResultList();
    	 return result;   	 
     }
     
    // method to update a record
     public Simpleresource updateRecord(
    		 String resourceID, 
    		 String resourceMediatype, 
    		 String questionPath,
    		 String questionAudioPath,
    		 String questionLargeCate,
    		 String questionSmallCate,
    		 String optionA,
    		 String optionB,
    		 String optionC,
    		 String optionCorrect,
    		 String difficultyLevel
    		 ) {
    	 Simpleresource simRes = manager.find(Simpleresource.class, resourceID);
    	 if (simRes != null) {
    	    	simRes.setResource_mediatype(resourceMediatype);
    	    	simRes.setQuestionPath(questionPath);
    	    	simRes.setQuestionAudioPath(questionAudioPath);
    	    	simRes.setQuestionLargeCate(questionLargeCate);
    	    	simRes.setQuestionSmallCate(questionSmallCate);
    	    	simRes.setOptionA(optionA);
    	    	simRes.setOptionB(optionB);
    	    	simRes.setOptionC(optionC);
    	    	simRes.setDifficultyLevel(difficultyLevel);
    	 }
    	 return simRes;
     }

    // method to delete a record
    public void deleteRecord(String resourceID) {
    	Simpleresource simRes = manager.find(Simpleresource.class, resourceID);
    	 if (simRes != null) {
    		 manager.remove(simRes);
    	 }
    }
}

