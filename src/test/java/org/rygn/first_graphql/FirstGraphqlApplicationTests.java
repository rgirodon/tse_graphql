package org.rygn.first_graphql;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.context.annotation.Import;
import org.springframework.graphql.test.tester.GraphQlTester;


@GraphQlTest(BlogController.class)
@Import(GraphqlConfiguration.class)
class FirstGraphqlApplicationTests {

	@Autowired
    private GraphQlTester graphQlTester;

	
	@Test
	public void testRecentPosts() throws IOException {
		
        String documentName = "recent_posts";

        graphQlTester.documentName(documentName)
          .variable("count", 1)
          .variable("offset", 0)
          .execute()
          .path("$")
          .matchesJson(expected(documentName));
	}
	
    public static String expected(String fileName) throws IOException {
        Path path = Paths.get("src/test/resources/" + fileName + "_expected_response.json");
        return new String(Files.readAllBytes(path));
    }
}
