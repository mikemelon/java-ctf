package cn.edu.lynu.javactf.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.lynu.javactf.dao.TeamMapper;
import cn.edu.lynu.javactf.model.Team;
import cn.edu.lynu.javactf.service.TeamService;

@Transactional
@Service
public class TeamServiceImpl implements TeamService{
	
	private static Logger logger = LoggerFactory.getLogger(TeamServiceImpl.class);
	@Autowired
	private TeamMapper teamDao;

	@Override
	public void save(Team team) {
		int n = teamDao.insertTeam(team);
		logger.info("{}个team插入数据库",n);
	}
	
	@Override
	public void update(Team team) {
		int n = teamDao.updateTeam(team);
		logger.info("{}个team更新",n);
	}

	@Override
	public Team getTeamById(int id) {
		return teamDao.getTeamById(id);
	}

	@Override
	public void deleteTeamById(int id) {
		int n = teamDao.deleteTeamById(id);
		logger.info("{}个team被删除", n );
		
	}

	@Override
	public List<Team> getAllTeams() {
		return teamDao.getAllTeams();
	}

}
