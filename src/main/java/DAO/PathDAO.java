package DAO;

import java.util.List;

import model.Path;

public interface PathDAO {
	public void add(Path property);
	
	public void delete(Path property);
	
	public void update(Path property);
	
	public Path getByCode(String code);	
	
	public List<Path> getAllByType(String type);
	
	
	
}
