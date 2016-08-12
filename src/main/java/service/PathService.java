package service;

import java.util.List;

import model.Path;

//配置中的配置数据源相关
public interface PathService {
	
	public void add(Path property);
	
	public void delete(Path property);
	
	public void update(Path property);
	
	public Path getByCode(String code);
	
	public List<Path> getAllByType(String type);
}
