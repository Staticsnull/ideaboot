package cn.bdqn.service;


import cn.bdqn.entity.User;

import java.util.List;

public interface UserService {

	List<User> isLogin(String email, String password);
	
	int hasEmail(String email);
}
