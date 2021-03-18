package org.rygn.first_graphql;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.graphql.spring.boot.test.GraphQLResponse;
import com.graphql.spring.boot.test.GraphQLTestTemplate;


// @GraphQLTest
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FirstGraphqlApplicationTests {

	@Autowired
    private GraphQLTestTemplate graphQLTestTemplate;

	
	@Test
	public void testRecentPosts() throws Exception {
		
		GraphQLResponse response = graphQLTestTemplate.postForResource("get-recent-posts.graphql");
        
		assertTrue(response.isOk());
        
        assertEquals("10", response.get("$.data.recentPosts.length()"));
                
        assertEquals("Title 2", response.getList("$.data.recentPosts[?(@.id == 2)].title", String.class).get(0));
	}
}
