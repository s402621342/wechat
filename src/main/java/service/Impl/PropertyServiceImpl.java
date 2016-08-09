package service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DAO.PropertyDAO;
import model.Property;
import service.PropertyService;
@Service
public class PropertyServiceImpl implements PropertyService{
	@Autowired
	private PropertyDAO propertyDAO;
	@Override
	public void add(Property property) {
		// TODO Auto-generated method stub
		propertyDAO.add(property);
	}

	@Override
	public void delete(Property property) {
		// TODO Auto-generated method stub
		propertyDAO.delete(property);
	}

	@Override
	public void update(Property property) {
		// TODO Auto-generated method stub
		propertyDAO.update(property);
	}


	@Override
	public Property getByCode(String code) {
		// TODO Auto-generated method stub
		return propertyDAO.getByCode(code);
	}

	@Override
	public List<Property> getAll() {
		// TODO Auto-generated method stub
		return propertyDAO.getAll();
	}

}
