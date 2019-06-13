package cn.edu.lynu.javactf.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.lynu.javactf.dao.CategoryMapper;
import cn.edu.lynu.javactf.model.Category;
import cn.edu.lynu.javactf.service.CategoryService;

@Transactional
@Service
public class CategoryServiceImpl implements CategoryService{
	
	private static Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);
	@Autowired
	private CategoryMapper categoryDao;

	@Override
	public void save(Category category) {
		int n = categoryDao.insertCategory(category);
		logger.info("{}个category插入数据库",n);
	}
	
	@Override
	public void update(Category category) {
		int n = categoryDao.updateCategory(category);
		logger.info("{}个category更新",n);
	}

	@Override
	public Category getCategoryById(int id) {
		return categoryDao.getCategoryById(id);
	}

	@Override
	public void deleteCategoryById(int id) {
		int n = categoryDao.deleteCategoryById(id);
		logger.info("{}个category被删除", n );
		
	}

	@Override
	public List<Category> getAllCategories() {
		return categoryDao.getAllCategories();
	}



}
