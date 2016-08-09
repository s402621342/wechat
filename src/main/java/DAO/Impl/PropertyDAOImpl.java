package DAO.Impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import DAO.PropertyDAO;
import model.Property;
@Repository
public class PropertyDAOImpl implements PropertyDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession(){
		return sessionFactory.openSession();
	}
	@Override
	public void add(Property property) {
		// TODO Auto-generated method stub
		Session session=getSession();
		session.beginTransaction();
		session.save(property);
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public void delete(Property property) {
		// TODO Auto-generated method stub
		Session session=getSession();
		session.beginTransaction();
		session.delete(property);
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public void update(Property property) {
		// TODO Auto-generated method stub
		Session session=getSession();
		session.beginTransaction();
		session.update(property);
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public Property getByCode(String code) {
		// TODO Auto-generated method stub
		Session session=getSession();
		session.beginTransaction();
		Query query=session.createQuery("from Property where code=?");
		query.setParameter(0, code);
		List<Property> properties=query.list();
		Property property=null;
		if(properties.size()>0){
			property=properties.get(0);
		}
		session.getTransaction().commit();
		session.close();
		return property;
	}
	@Override
	public List<Property> getAll() {
		// TODO Auto-generated method stub
		Session session=getSession();
		session.beginTransaction();
		Query query=session.createQuery("from Property");
		List<Property> properties=query.list();
		session.getTransaction().commit();
		session.close();
		return properties;
	}

}
