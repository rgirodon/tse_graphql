package org.rygn.first_graphql;

import java.util.List;

import graphql.kickstart.tools.GraphQLQueryResolver;


public class BlogQuery implements GraphQLQueryResolver {

	private PostDao postDao;

    public BlogQuery(PostDao postDao) {
        this.postDao = postDao;
    }

    public List<Post> getRecentPosts(int count, int offset) {
        return postDao.getRecentPosts(count, offset);
    }
}
