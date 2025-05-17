package org.rygn.first_graphql;

import java.util.Map;

public class AuthorDao {

	private Map<Integer, Author> authors;

    public AuthorDao(Map<Integer, Author> authors) {
    	
        this.authors = authors;
    }
    
    public Author getAuthor(Integer id) {
    	
    	return this.authors.get(id);
    }
}
