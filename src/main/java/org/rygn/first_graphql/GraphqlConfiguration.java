package org.rygn.first_graphql;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphqlConfiguration {

	@Bean
    public PostDao postDao() {
        List<Post> posts = new ArrayList<>();
        for (int postId = 0; postId < 10; ++postId) {
            Post post = new Post();
            post.setId("" + postId);
            post.setTitle("Title " + postId);
            post.setText("Text " + postId);
            post.setCategory("Category " + (postId % 2 == 0 ? "1" : "2"));
            posts.add(post);
        }
        return new PostDao(posts);
    }
	
	@Bean
	public TeamDao teamDao() {
		
		List<Team> teams = new ArrayList<>();
		
		Team team1 = new Team();
		team1.setId("FRA");
		team1.setName("France");
		team1.setColors("Bleu, blanc, rouge");
		teams.add(team1);
		
		Team team2 = new Team();
		team2.setId("SP");
		team2.setName("Spain");
		team2.setColors("Rouge, jaune");
		teams.add(team2);
		
		return new TeamDao(teams);
	}
	
	@Bean
    public BlogQuery blogQuery(PostDao postDao) {
        return new BlogQuery(postDao);
    }
	
	@Bean
    public TeamsQuery teamsQuery(TeamDao teamDao) {
        return new TeamsQuery(teamDao);
    }
	
	@Bean
    public BlogMutation mutation(PostDao postDao) {
        return new BlogMutation(postDao);
    }
}
