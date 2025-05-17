package org.rygn.first_graphql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BlogController {

	@Autowired
	private PostDao postDao;
	
	@Autowired
	private AuthorDao authorDao;

    public BlogController() {
    }

    @QueryMapping
    public List<Post> recentPosts(@Argument int count, @Argument int offset) {
    	
        return this.postDao.getRecentPosts(count, offset);
    }
    
    @SchemaMapping(typeName="Post", field="author")
    public Author getAuthor(Post post) {
    	    	
        return this.authorDao.getAuthor(Integer.parseInt(post.getAuthorId()));
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
