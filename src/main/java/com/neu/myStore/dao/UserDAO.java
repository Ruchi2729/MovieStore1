package com.neu.myStore.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.neu.myStore.pojo.Email;
import com.neu.myStore.pojo.Genre;
import com.neu.myStore.pojo.Movie;
import com.neu.myStore.pojo.User;


public class UserDAO extends DAO {

    public UserDAO() {
    }

    public User get(String username,String password)
    {
    	
    	User user = null;
    	
        try {
        	
        	Query q = getSession().createQuery("from User where username = :username and password=:password");
            q.setString("username", username);
            q.setString("password", password);
         user = (User) q.uniqueResult();
   
            return user;
        } catch (HibernateException e) {
      
            //throw new AdException("Could not get user " + username, e);
        	System.out.println("Exception:"+e.getMessage());
        }
        finally {
			if (getSession().isOpen())

				
				getSession().close();

		}
		return user;
     
        
    }
       public boolean checkUser(String userName)
       {

       
       	
           try {
           	
           	Query q = getSession().createQuery("from User where username = :username");
               q.setString("username", userName);
               User user = (User) q.uniqueResult();
      if(user==null)
      {
    	  return false;
      }
           } catch (HibernateException e) {
         
               //throw new AdException("Could not get user " + username, e);
           	System.out.println("Exception:"+e.getMessage());
           }
           finally {
   			if (getSession().isOpen())

   				
   				getSession().close();

   		}
		return true;
    	   
       }
  

    public User create(String username, String password,String emailId, String firstName, String lastName,String address,User.AccountType accountype,String favGenre)
          {
        try {
        begin();
            System.out.println("inside DAO");
            
            Email email=new Email(emailId);
            User user=new User();
            
            user.setFirstname(firstName);
            user.setLastname(lastName);
            user.setUsername(username);
            user.setPassword(password);
            user.setAddress(address);
            
            user.setEmail(email);
            user.setAcountType(accountype);
            user.setFavGenre(favGenre);
            Genre fevg=new Genre();
            fevg.setGenreName(user.getFavGenre());
            fevg.setUsersgenre(user);
            user.getFavgenres().add(fevg);
           
            
            email.setUser(user);
            
            getSession().save(user);
            
          commit();
            return user;
        } catch (HibernateException e) {
        	rollback();
            //throw new AdException("Could not create user " + username, e);
            throw new HibernateException("Exception while creating user: " + e.getMessage());
        }
        finally {
			if (getSession().isOpen())

				
				getSession().close();

		}
      
      
     
      
    }

//    public void delete(User user)
//            throws AdException {
//        try {
//            begin();
//            getSession().delete(user);
//            commit();
//        } catch (HibernateException e) {
//            rollback();
//            throw new AdException("Could not delete user " + user.getUsername(), e);
//        }
//    }

	
		
	

	public void update(User user,Movie movie)  {
		
		 try {
			 begin();
			 getSession().update(user);
			   System.out.println("UPDATE AFTER UPDATE");
			  // getSession().update(movie);
			   commit();
		 } catch (HibernateException e) {
			rollback();
	            //throw new AdException("Could not get user " + user.getId(), e);
	            System.out.println("Exception is"+e.getMessage());
	        }
		 finally {
				if (getSession().isOpen())

					
					getSession().close();

			}
		
		
	
       
		
		
		
	}
	
	
	public void updateReview(User user,Movie movie) {
		
		 try {
			 begin();
			 getSession().update(user);
			   System.out.println("UPDATE AFTER UPDATE");
			   getSession().update(movie);
			   commit();
		 } catch (HibernateException e) {
			rollback();
	            //throw new AdException("Could not get user " + user.getId(), e);
	            System.out.println("Exception is"+e.getMessage());
	        }
		 finally {
				if (getSession().isOpen())

					
					getSession().close();

			}
		
		
	
      
		
		
		
	}
}