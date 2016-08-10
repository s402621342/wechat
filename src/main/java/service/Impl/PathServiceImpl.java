package service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DAO.PathDAO;
import model.Path;
import service.PathService;
@Service
public class PathServiceImpl implements PathService{
	@Autowired
	private PathDAO pathDAO;
	@Override
	public void add(Path property) {
		// TODO Auto-generated method stub
		pathDAO.add(property);
	}

	@Override
	public void delete(Path property) {
		// TODO Auto-generated method stub
		pathDAO.delete(property);
	}

	@Override
	public void update(Path property) {
		// TODO Auto-generated method stub
		pathDAO.update(property);
	}


	@Override
	public Path getByCode(String code) {
		// TODO Auto-generated method stub
		return pathDAO.getByCode(code);
	}

	@Override
	public List<Path> getAllByType(String type) {
		// TODO Auto-generated method stub
		return pathDAO.getAllByType(type);
	}

	

}
