package org.rygn.first_graphql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BlogController {

	@Autowired
	private PostDao postDao;

    public BlogController() {
    }

    @QueryMapping
    public List<Post> recentPosts(@Argument int count, @Argument int offset) {
    	
        return this.postDao.getRecentPosts(count, offset);
    }
    
    @MutationMapping
    public Post writePost(@Argument String id, @Argument String title, @Argument String category, @Argument String text) {
    	
    	Post post = new Post();
    	post.setId(id);
    	post.setTitle(title);
    	post.setCategory(category);
    	post.setText(text);
    	
        return postDao.savePost(post);
    }
}
