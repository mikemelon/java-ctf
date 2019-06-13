package cn.edu.lynu.javactf.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.lynu.javactf.dao.NewsMapper;
import cn.edu.lynu.javactf.model.News;
import cn.edu.lynu.javactf.service.NewsService;

@Transactional
@Service
public class NewsServiceImpl implements NewsService{
	
	private static Logger logger = LoggerFactory.getLogger(NewsServiceImpl.class);
	@Autowired
	private NewsMapper newsDao;

	@Override
	public void save(News news) {
		int n = newsDao.insertNews(news);
		logger.info("{}个news插入数据库",n);
	}

	@Override
	public News getNewsById(int id) {
		return newsDao.getNewsById(id);
	}

	@Override
	public void deleteNewsById(int id) {
		int n = newsDao.deleteNewsById(id);
		logger.info("{}个news被删除", n );
		
	}

	@Override
	public List<News> getAllNews() {
		return newsDao.getAllNews();
	}

	@Override
	public void update(News news) {
		int n = newsDao.updateNews(news);
		logger.info("{}个news更新",n);
	}

}
