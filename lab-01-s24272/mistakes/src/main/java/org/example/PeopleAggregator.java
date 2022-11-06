package org.example;

import org.example.model.Gender;
import org.example.model.Person;
import org.example.model.Samples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PeopleAggregator {

    public Map<Gender, List<Person>> aggregatePeopleByGender(){
        List<Person> newListOfWoman = new ArrayList<>();
        List<Person> newListOfMan = new ArrayList<>();

        Map<Gender, List<Person>> aggregatedByGender = new HashMap<>();
        aggregatedByGender.put(Gender.FEMALE, newListOfWoman);
        aggregatedByGender.put(Gender.MALE, newListOfMan);

        for (Person person : Samples.getSampleListOfPeople()) {
            if (person.getGender() == Gender.MALE)
                aggregatedByGender.get(Gender.MALE).add(person);
            if(person.getGender() == Gender.FEMALE)
                aggregatedByGender.get(Gender.FEMALE).add(person);
        }
        return aggregatedByGender;
    }
}
