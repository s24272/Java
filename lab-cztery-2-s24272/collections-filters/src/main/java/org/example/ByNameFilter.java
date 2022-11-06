package org.example;

import org.example.interfaces.IFilterPeople;
import org.example.model.Person;
import org.example.queries.search.SearchParameters;

import java.util.List;
import java.util.stream.Stream;

public class ByNameFilter implements IFilterPeople {

    SearchParameters searchParameters = new SearchParameters();


    @Override
    public void setSearchParameters(SearchParameters searchParameters) {
        this.searchParameters = searchParameters;
    }
    @Override
    public boolean canFilter() {
        return searchParameters.getName() != null;
    }

    @Override
    public List<Person> filter(List<Person> streamOfPeople) {
        return streamOfPeople.stream().filter(p -> p.getName().equalsIgnoreCase(searchParameters.getName())).toList();
    }
}
