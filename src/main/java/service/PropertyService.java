package service;

import java.util.List;

import model.Property;

public interface PropertyService {
	public void add(Property property);
	
	public void delete(Property property);
	
	public void update(Property property);
	
	public Property getByCode(String code);
	
	public List<Property> getAll();
}
