package org.example;

import org.example.interfaces.ICalculate;
import org.example.interfaces.ItemToCalculate;
import org.example.model.Person;
import org.example.queries.search.FunctionsParameters;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

public class GeneralCalculator implements ICalculate {

    private String nameOfitem;
    private ItemToCalculate item;

    public GeneralCalculator(String nameOfitem, ItemToCalculate item) {
        this.nameOfitem = nameOfitem;
        this.item = item;
    }

    @Override
    public double calculate(FunctionsParameters calculations, List<Person> peopleCollections) {

        switch(calculations.getFunction()) {
            case AVERAGE:
            double average = peopleCollections.stream().map(a -> a.getIncome()).reduce(0.0, (a, b) -> a + b)
                    / peopleCollections.stream().count();
                return average;
            case SUM:
                double counter = peopleCollections.stream().map(a -> a.getIncome()).reduce(0.0, (a, b) -> a + b);
                return counter;
            case MAX:
                 Person max = peopleCollections.stream().max(Comparator.comparing(Person::getIncome)).orElseThrow(NoSuchElementException::new);
                 return max.getIncome();
            case MIN:
                Person min = peopleCollections.stream().min(Comparator.comparing(Person::getIncome)).orElseThrow(NoSuchElementException::new);
                return min.getIncome();
        }

        return 0;
    }
}
