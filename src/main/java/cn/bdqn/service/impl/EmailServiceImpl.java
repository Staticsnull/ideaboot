package cn.bdqn.service.impl;

import cn.bdqn.dao.EmailMapper;
import cn.bdqn.entity.Email;
import cn.bdqn.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class EmailServiceImpl implements EmailService{
	
	@Resource
	private EmailMapper emailMapper;

	@Override
	public boolean add(Email email) {
		int result = emailMapper.add(email);
		return result > 0;
	}

	@Override
	public List<Map<String,Object>> listSend(String accepter,int type) {
		List<Map<String,Object>> emailList = emailMapper.list(accepter, type);
		return emailList;
	}

	@Override
	public boolean delete(String id) {
		int result = emailMapper.delete(id);
		return result > 0;
	}

	@Override
	public int hasTitle(String title) {
		int result = emailMapper.hasTitle(title);
		return result;
	}

}
