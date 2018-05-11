package cn.bdqn.dao;

import cn.bdqn.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
	

	List<User> isLogin(@Param("email") String email, @Param("userPassword") String userPassword);
	
	int hasEmail(@Param("email") String email);
}
