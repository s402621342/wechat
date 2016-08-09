package DAO;

import java.util.List;

import model.Property;

public interface PropertyDAO {
	public void add(Property property);
	
	public void delete(Property property);
	
	public void update(Property property);
	
	public Property getByCode(String code);	
	
	public List<Property> getAll();
	
	
	
}
