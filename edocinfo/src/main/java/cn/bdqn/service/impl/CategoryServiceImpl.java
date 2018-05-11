package cn.bdqn.service.impl;

import cn.bdqn.dao.CategoryDao;
import cn.bdqn.entity.Category;
import cn.bdqn.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Resource
	private CategoryDao categoryDao;

	@Override
	public List<Category> getCategoryList() {
		return categoryDao.getCategoryList();
	}

	@Override
	public Integer findIdByName(String name) {
		Integer id = categoryDao.findIdByName(name);
		return id;
	}

	@Override
	public boolean add(Category category) {
		int row = categoryDao.add(category);
		return row > 0;
	}

	@Override
	public boolean updateCategory(Category category) {
		int row = categoryDao.updateCategory(category);
		return row > 0;
	}
}
