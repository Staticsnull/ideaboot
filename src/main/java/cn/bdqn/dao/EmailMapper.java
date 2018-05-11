package cn.bdqn.dao;

import cn.bdqn.entity.Email;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


@Mapper
public interface EmailMapper {
	

	List<Map<String,Object>> list(@Param("accepter") String accepter, @Param("type") int type);

	int add(Email email);

	int delete(@Param("id") String id);

	int hasTitle(@Param("title") String title);
}
