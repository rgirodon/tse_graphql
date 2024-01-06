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
        for (int postId = 0; postId < 1000; ++postId) {
            Post post = new Post();
            post.setId("" + postId);
            post.setTitle("Title " + postId);
            post.setText("Text " + postId);
            post.setCategory("Category " + (postId % 2 == 0 ? "1" : "2"));
            posts.add(post);
        }
        return new PostDao(posts);
    }		
}
