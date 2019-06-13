package cn.edu.lynu.javactf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.edu.lynu.javactf.model.Category;

@Mapper
public interface CategoryMapper {
	
	@Select("SELECT * FROM category")
	List<Category> getAllCategories();
	
	@Select("SELECT * FROM category WHERE ID=#{id}")
	Category getCategoryById(@Param("id") int id);
	
	@Delete("DELETE category WHERE ID = #{id}")
	int deleteCategoryById(@Param("id")int id);
	
	@Insert("INSERT INTO category(name) VALUES ( #{category.name})")
	int insertCategory(@Param("category")Category category);
	
	@Update("UPDATE category SET NAME=#{category.name} WHERE ID = #{category.id}")
	int updateCategory(@Param("category")Category category);
}
