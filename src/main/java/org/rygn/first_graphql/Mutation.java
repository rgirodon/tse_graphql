package org.rygn.first_graphql;

import graphql.kickstart.tools.GraphQLMutationResolver;

public class Mutation implements GraphQLMutationResolver {
	
	private PostDao postDao;

    public Mutation(PostDao postDao) {
        this.postDao = postDao;
    }

    public Post writePost(String id, String title, String category, String text) {
    	
    	Post post = new Post();
    	post.setId(id);
    	post.setTitle(title);
    	post.setCategory(category);
    	post.setText(text);
    	
        return postDao.savePost(post);
    }
}