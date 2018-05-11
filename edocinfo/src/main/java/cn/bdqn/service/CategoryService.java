package cn.bdqn.service;

import cn.bdqn.entity.Category;
import cn.bdqn.entity.Entry;

import java.util.List;

public interface CategoryService {
	List<Category> getCategoryList();
	Integer findIdByName(String name);
	boolean add(Category category);
	boolean updateCategory(Category category);


}
