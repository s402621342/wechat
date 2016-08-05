package DAO.Impl;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import DAO.UserDAO;
import model.User;
@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession(){
		return sessionFactory.openSession();
	}
	
	@Override
	public User getUserByID(String id) {
		// TODO Auto-generated method stub
		Session session=getSession();
		session.beginTransaction();
		User user=(User) session.get(User.class, id);
		session.getTransaction().commit();
		session.close();
		return user;
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		Session session=getSession();
		session.beginTransaction();
		session.saveOrUpdate(user);
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public User getUserByName(String username) {
		Session session=getSession();
		session.beginTransaction();
		Query query=session.createQuery("from User where username=?");
		query.setParameter(0, username);
		List<User> users=query.list();
		User user=null;
		if(users.size()>0){
			user=users.get(0);
		}
		session.getTransaction().commit();
		session.close();
		return user;
		// TODO Auto-generated method stub
		
	}

}
