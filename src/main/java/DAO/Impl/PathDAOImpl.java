package DAO.Impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import DAO.PathDAO;
import model.Path;
@Repository
public class PathDAOImpl implements PathDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession(){
		return sessionFactory.openSession();
	}
	@Override
	public void add(Path property) {
		// TODO Auto-generated method stub
		Session session=getSession();
		session.beginTransaction();
		session.save(property);
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public void delete(Path property) {
		// TODO Auto-generated method stub
		Session session=getSession();
		session.beginTransaction();
		session.delete(property);
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public void update(Path property) {
		// TODO Auto-generated method stub
		Session session=getSession();
		session.beginTransaction();
		session.update(property);
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public Path getByCode(String code) {
		// TODO Auto-generated method stub
		Session session=getSession();
		session.beginTransaction();
		Query query=session.createQuery("from Path where code=?");
		query.setParameter(0, code);
		List<Path> properties=query.list();
		Path property=null;
		if(properties.size()>0){
			property=properties.get(0);
		}
		session.getTransaction().commit();
		session.close();
		return property;
	}
	@Override
	public List<Path> getAllByType(String type) {
		// TODO Auto-generated method stub
		Session session=getSession();
		session.beginTransaction();
		Query query=session.createQuery("from Path where type=?");
		query.setParameter(0, type);
		List<Path> properties=query.list();
		session.getTransaction().commit();
		session.close();
		return properties;
	}

}
