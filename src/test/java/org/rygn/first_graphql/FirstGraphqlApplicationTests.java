package org.rygn.first_graphql;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.graphql.spring.boot.test.GraphQLResponse;
import com.graphql.spring.boot.test.GraphQLTest;
import com.graphql.spring.boot.test.GraphQLTestTemplate;

import static org.mockito.Mockito.*;

@GraphQLTest
class FirstGraphqlApplicationTests {

	@Autowired
    private GraphQLTestTemplate graphQLTestTemplate;
	
	@MockBean
    PostDao postDao;

	@Test
	public void testRecentPosts() throws Exception {
		
		List<Post> posts = new ArrayList<>();
        for (int postId = 0; postId < 3; ++postId) {
            Post post = new Post();
            post.setId("" + postId);
            post.setTitle("Title " + postId);
            post.setText("Text " + postId);
            posts.add(post);
        }
		
		doReturn(posts).when(postDao).getRecentPosts(10, 0);
		
		GraphQLResponse response = graphQLTestTemplate.postForResource("get-recent-posts.graphql");
        
		assertTrue(response.isOk());
        
        assertEquals("3", response.get("$.data.recentPosts.length()"));
                
        assertEquals("Title 2", response.getList("$.data.recentPosts[?(@.id == 2)].title", String.class).get(0));
	}
}
