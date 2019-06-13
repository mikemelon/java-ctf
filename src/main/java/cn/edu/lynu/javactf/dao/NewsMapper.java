package cn.edu.lynu.javactf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.edu.lynu.javactf.model.News;

@Mapper
public interface NewsMapper {
	
	@Select("SELECT * FROM news")
	List<News> getAllNews();
	
	@Select("SELECT * FROM news WHERE ID=#{id}")
	News getNewsById(@Param("id") int id);
	
	@Delete("DELETE news WHERE ID = #{id}")
	int deleteNewsById(@Param("id")int id);
	
	@Insert("INSERT INTO news(title, content) VALUES ( #{news.title}, #{news.content} )")
	int insertNews(@Param("news") News news);
	
	@Update("UPDATE news SET title=#{news.title}, content=#{news.content} WHERE ID = #{news.id}")
	int updateNews(@Param("news")News news);
}
