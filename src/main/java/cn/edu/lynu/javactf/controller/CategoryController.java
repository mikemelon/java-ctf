package cn.edu.lynu.javactf.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.lynu.javactf.exception.CategoryNotFoundException;
import cn.edu.lynu.javactf.model.Category;
import cn.edu.lynu.javactf.service.CategoryService;

@RestController
public class CategoryController {
	private static Logger logger = LoggerFactory.getLogger(CategoryController.class);
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping(value = "/categories")
	public List<Category> findAllCategories() {
		return categoryService.getAllCategories();
	}
	
	@GetMapping(value = "/category/{id}")
	public Category getCategoryById(@PathVariable("id") Integer id) {
		return categoryService.getCategoryById(id);
	}
	
	@PostMapping("/category")
	@ResponseStatus(HttpStatus.CREATED)
	public void addCategory(@RequestBody @Valid Category category) {
		logger.info("add category:{}", category);
		categoryService.save(category);
	}
	
	@PutMapping("/category")
	public void updateCategory(@RequestBody @Valid Category category) {
		logger.info("update category:{}", category);
		categoryService.update(category);
	}
	
	@DeleteMapping(value = "/category/{id}")
	public void delete(@PathVariable("id") Integer id) {
		if (categoryService.getCategoryById(id) == null) {
			throw new CategoryNotFoundException();
		}
		logger.info("delete category:id={}", id);
		categoryService.deleteCategoryById(id);
	}
}
