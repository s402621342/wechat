package DAO;

import java.util.List;

import model.Info;

public interface InfoDAO {
	public void update(List<Info> infos);
	
	public List<Info> getAllByType(String type);
	
	public Info getbyName(String name);
}
