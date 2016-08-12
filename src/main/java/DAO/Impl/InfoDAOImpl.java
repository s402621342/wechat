package DAO.Impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import DAO.InfoDAO;
import model.Info;
@Repository
public class InfoDAOImpl implements InfoDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession(){
		return sessionFactory.openSession();
	}
	@Override
	public void update(List<Info> infos) {
		// TODO Auto-generated method stub
		Session session=getSession();
		for(Info info:infos){
			session.beginTransaction();
			session.saveOrUpdate(info);
			session.getTransaction().commit();
		}
		session.close();

	}

	@Override
	public List<Info> getAllByType(String type) {
		// TODO Auto-generated method stub
		Session session=getSession();
		session.beginTransaction();
		Query query=session.createQuery("from Info where type=:type");
		query.setParameter("type", type);
		List<Info> infos=query.list();
		session.getTransaction().commit();
		session.close();
		return infos;
	}
	@Override
	public Info getbyName(String name) {
		// TODO Auto-generated method stub
		Session session=getSession();
		session.beginTransaction();
		Query query=session.createQuery("from Info where name=:name");
		query.setParameter("name", name);
		List<Info> infos=query.list();
		Info info=null;
		if(infos.size()>0){
			info=infos.get(0);
		}
		session.getTransaction().commit();
		session.close();
		return info;
	}
	
	

}
