package org.rygn.first_graphql;

import java.util.List;

import graphql.kickstart.tools.GraphQLQueryResolver;


public class TeamsQuery implements GraphQLQueryResolver {

	private TeamDao teamDao;

    public TeamsQuery(TeamDao teamDao) {
        this.teamDao = teamDao;
    }

    public List<Team> getAllTeams() {
        return this.teamDao.getAllTeams();
    }
}
