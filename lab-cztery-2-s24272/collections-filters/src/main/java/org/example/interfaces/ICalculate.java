package org.example.interfaces;

import org.example.model.Person;
import org.example.queries.search.FunctionsParameters;

import java.util.List;
import java.util.stream.Stream;

public interface ICalculate {
double calculate(FunctionsParameters calculations, List<Person> peopleCollections);
}
