package cn.edu.lynu.javactf.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.lynu.javactf.exception.NewsNotFoundException;
import cn.edu.lynu.javactf.model.News;
import cn.edu.lynu.javactf.service.NewsService;

@RestController
public class NewsController {
	private static Logger logger = LoggerFactory.getLogger(NewsController.class);
	@Autowired
	private NewsService newsService;
	
	@GetMapping(value = "/news")
	public List<News> findAllNews() {
		return newsService.getAllNews();
	}
	
	@GetMapping(value = "/news/{id}")
	public News getNewsById(@PathVariable("id") Integer id) {
		return newsService.getNewsById(id);
	}
	
	@PostMapping("/news")
	public void addNews(@RequestBody @Valid News news) {
		logger.info("add news:{}", news);
		newsService.save(news);
	}
	
	@PutMapping("/news")
	public void udpateNews(@RequestBody @Valid News news) {
		logger.info("udpate news:{}", news);
		newsService.update(news);
	}
	
	@DeleteMapping(value = "/news/{id}")
	public void delete(@PathVariable("id") Integer id) {
		if (newsService.getNewsById(id) == null) {
			throw new NewsNotFoundException();
		}
		logger.info("delete news: id={}", id);
		newsService.deleteNewsById(id);
	}
	

}
