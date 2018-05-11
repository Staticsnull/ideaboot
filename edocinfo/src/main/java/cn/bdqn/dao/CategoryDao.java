package cn.bdqn.dao;

import cn.bdqn.entity.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryDao {
	List<Category> getCategoryList();
	Integer findIdByName(String name);
	int add(Category category);
	int updateCategory(Category category);

}
