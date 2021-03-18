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
            posts.add(post);
        }
        return new PostDao(posts);
    }
	
	@Bean
    public Query query(PostDao postDao) {
        return new Query(postDao);
    }
	
	@Bean
    public Mutation mutation(PostDao postDao) {
        return new Mutation(postDao);
    }
}
