package cn.edu.lynu.javactf.service;

import java.util.List;

import cn.edu.lynu.javactf.model.Category;

public interface CategoryService {
	
	Category getCategoryById(int id);
	
	List<Category> getAllCategories();
	
	void deleteCategoryById(int id);
	
	void save(Category category);
	
	void update(Category category);

}
