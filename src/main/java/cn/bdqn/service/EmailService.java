package cn.bdqn.service;

import cn.bdqn.entity.Email;

import java.util.List;
import java.util.Map;

public interface EmailService {


	boolean add(Email email);
	
	List<Map<String,Object>> listSend(String accepter, int type);
	
	boolean delete(String id);

	int hasTitle(String title);
	
}
