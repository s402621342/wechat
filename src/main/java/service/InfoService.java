package service;

import java.util.List;

import model.Info;

public interface InfoService {
	public void update(List<Info> infos);
	
	public List<Info> getAllByType(String type);
}
