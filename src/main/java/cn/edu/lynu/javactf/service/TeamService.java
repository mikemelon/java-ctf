package cn.edu.lynu.javactf.service;

import java.util.List;

import cn.edu.lynu.javactf.model.Team;

public interface TeamService {
	
	Team getTeamById(int id);
	
	List<Team> getAllTeams();
	
	void deleteTeamById(int id);
	
	void save(Team team);
	
	void update(Team team);

}
