package service;

import java.util.List;

import entity.Information;
import entity.OutLine;

public interface checkService {
	Information getInformation(long id);
	
	List<OutLine> getOutLines(String username);
}
