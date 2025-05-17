package org.rygn.first_graphql;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphqlConfiguration {

	@Bean
    public AuthorDao authorDao() {
		
        Map<Integer, Author> authors = new HashMap<>();
        
        for (int authorId = 0; authorId < 5; ++authorId) {
            Author author = new Author();
            author.setId("" + authorId);
            author.setName("Author "  + authorId);
            authors.put(authorId, author);
        }
        
        return new AuthorDao(authors);
    }	
	
	@Bean
    public PostDao postDao() {
        
		List<Post> posts = new ArrayList<>();
        
        for (int postId = 0; postId < 1000; ++postId) {
            Post post = new Post();
            post.setId("" + postId);
            post.setTitle("Title " + postId);
            post.setText("Text " + postId);
            post.setCategory("Category " + (postId % 2 == 0 ? "1" : "2"));
            post.setAuthorId("" + postId % 5);
            posts.add(post);
        }
        
        return new PostDao(posts);
    }		
}
