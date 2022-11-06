package org.example;

import org.example.model.Person;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
public class PeopleCleaner {

    public List<Person> getPeopleWithBooksOnly(List<Person> people){
        ArrayList<Person> secondPeople = new ArrayList<>(people);
        for (Person person : people) {
            if (person.getBooks().isEmpty())
                secondPeople.remove(person);
        }
        return secondPeople;
    }
}
