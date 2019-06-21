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

import cn.edu.lynu.javactf.exception.TeamNotFoundException;
import cn.edu.lynu.javactf.model.Team;
import cn.edu.lynu.javactf.service.TeamService;

@RestController
public class TeamController {
	private static Logger logger = LoggerFactory.getLogger(TeamController.class);
	@Autowired
	private TeamService teamService;
	
	@GetMapping(value = "/teams")
	public List<Team> findAllTeams() {
		return teamService.getAllTeams();
	}
	
	@GetMapping(value = "/team/{id}")
	public Team getTeamById(@PathVariable("id") Integer id) {
		return teamService.getTeamById(id);
	}
	
	@PostMapping("/team")
	public void addTeam(@RequestBody @Valid Team team) {
		logger.info("add team:{}", team);
		teamService.save(team);
	}
	
	@PutMapping("/team")
	public void updateTeam(@RequestBody @Valid Team team) {
		logger.info("update team:{}", team);
		teamService.update(team);
	}
	
	@DeleteMapping(value = "/team/{id}")
	public void delete(@PathVariable("id") Integer id) {
		if (teamService.getTeamById(id) == null) {
			throw new TeamNotFoundException();
		}
		logger.info("delete team:id={}", id);
		teamService.deleteTeamById(id);
	}
}
