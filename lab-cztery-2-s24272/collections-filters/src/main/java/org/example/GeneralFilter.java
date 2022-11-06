package org.example;

import org.example.interfaces.IFilterPeople;
import org.example.interfaces.TwoPersonsPredicate;
import org.example.model.Person;
import org.example.queries.search.SearchParameters;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class GeneralFilter implements IFilterPeople {

    Predicate<SearchParameters> check;
    TwoPersonsPredicate checkStreamPersons;
    SearchParameters searchParameters = new SearchParameters();

    public GeneralFilter(Predicate<SearchParameters> check, TwoPersonsPredicate checkStream) {
        this.check = check;
        this.checkStreamPersons = checkStream;
    }

    @Override
    public void setSearchParameters(SearchParameters searchParameters) {
        this.searchParameters = searchParameters;
    }

    @Override
    public boolean canFilter() {
        return check.test(searchParameters);
    }

    @Override
    public List<Person> filter(List<Person> streamOfPeople) {
        return streamOfPeople.stream().filter(p -> checkStreamPersons.check(this.searchParameters, p)).toList();
    }
}
