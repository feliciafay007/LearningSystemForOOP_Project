import javax.persistence.*;
import java.util.*;

public class Main {
  private static final String PERSISTENCE_UNIT_NAME = "PersistenceUnit";
  private static EntityManagerFactory factory;

  public static void main(String[] args) {
    factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    EntityManager manager = factory.createEntityManager();      
    Query query = manager.createQuery("Select e FROM courselist e");
    List<CourseList> result =  query.getResultList();
    System.out.println(result);
    factory.close();
  }
}