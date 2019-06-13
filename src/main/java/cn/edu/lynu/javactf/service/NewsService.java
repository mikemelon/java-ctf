package cn.edu.lynu.javactf.service;

import java.util.List;

import cn.edu.lynu.javactf.model.News;

public interface NewsService {
	
	News getNewsById(int id);
	
	List<News> getAllNews();
	
	void deleteNewsById(int id);
	
	void save(News news);
	
	void update(News news);

}
