package service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DAO.InfoDAO;
import model.Info;
import service.InfoService;
@Service
public class InfoServiceImpl implements InfoService {

	@Autowired
	private InfoDAO infoDAO;
	
	@Override
	public void update(List<Info> infos) {
		// TODO Auto-generated method stub
		infoDAO.update(infos);
	}

	@Override
	public List<Info> getAllByType(String type) {
		// TODO Auto-generated method stub
		return infoDAO.getAllByType(type);
	}

}
