package org.example.interfaces;

import org.example.model.Person;
import org.example.queries.search.SearchParameters;

@FunctionalInterface
public interface TwoPersonsPredicate {
    boolean check(SearchParameters params, Person person);
}
