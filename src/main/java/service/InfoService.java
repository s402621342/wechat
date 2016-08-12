package service;

import java.util.List;

import model.Info;

public interface InfoService {
	//更新配置中的基本信息，身份认证，微信推送的信息
	public void update(List<Info> infos);
	
	//根据type获取所有信息
	public List<Info> getAllByType(String type);
}
