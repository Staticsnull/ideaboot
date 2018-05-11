package cn.bdqn.service.impl;


import cn.bdqn.dao.UserMapper;
import cn.bdqn.entity.User;
import cn.bdqn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;

	@Override
	public List<User> isLogin(String email, String password) {
		List<User> list = userMapper.isLogin(email, password);
		return list;
	}

	@Override
	public int hasEmail(String email) {
		int result = userMapper.hasEmail(email);
		return result;
	}

}
