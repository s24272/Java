package org.example.interfaces;

import org.example.model.Person;
import org.example.queries.search.Page;

import java.util.List;
import java.util.stream.Stream;

public interface ICutToPage {

    List<Person> cut(Page page, List<Person> streamOfPeople);

}
