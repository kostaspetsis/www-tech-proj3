import java.util.List;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Query;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="user")
@Access(value=AccessType.FIELD)
class user implements Serializable{
  
  @Column(name="USERNAME")
  private String USERNAME;
  @Column(name="PASSWORD")
  private String PASSWORD;

  
  public String getPassword(){
    return this.PASSWORD;
  }
  public void setPassword(String password){
    this.PASSWORD = password;
  }
  
  public String getUsername(){
    return this.USERNAME;
  }
  
  public void setUsername(String username){
    this.USERNAME = username;
  }
} 
public class Jpa_Register extends HttpServlet {
  private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("user");

  protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
  
    EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
    EntityTransaction transaction = null;

    try {
    
        String username = request.getParameter("username");
        String password = request.getParameter("password");    
    
        // Get a transaction
        transaction = manager.getTransaction();
        // Begin the transaction
        transaction.begin();
        
        String stringQuery = "SELECT count(U) FROM user U where U.password= '"+password+"'";
        //String stringQuery = "insert into user (USERNAME,PASSWORD) values("+username+","+password+")";
        Query query = manager.createQuery(stringQuery);
        int size = ((Number) query.getSingleResult()).intValue();      
        
        transaction.commit();
        
        if(size> 0) {
          response.setStatus(HttpServletResponse.SC_ACCEPTED);
        } else {
          transaction = manager.getTransaction();
          transaction.begin();        
           
          // Create a new Student object
          user user1= new user();
          user1.setUsername(username);
          user1.setPassword(password);

          // Save the student object
          manager.persist(user1);
          transaction.commit();
        }
    } catch (Exception ex) {
        // If there are any exceptions, roll back the changes
        if (transaction != null) {
            transaction.rollback();
        }
        // Print the Exception
        ex.printStackTrace();
    } finally {
        // Close the EntityManager
        manager.close();
    }
  }
}