package org.rygn.first_graphql;

import java.util.List;

public class TeamDao {

	private List<Team> teams;
	
	public TeamDao(List<Team> teams) {

		this.teams = teams;
	}

	public List<Team> getAllTeams() {
		
		return this.teams;
	}
}
