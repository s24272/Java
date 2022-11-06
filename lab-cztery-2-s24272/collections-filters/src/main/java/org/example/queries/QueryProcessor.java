package org.example.queries;

import org.example.GeneralFilter;
import org.example.interfaces.ICalculate;
import org.example.interfaces.ICutToPage;
import org.example.interfaces.IFilterPeople;
import org.example.interfaces.TwoPersonsPredicate;
import org.example.model.Person;
import org.example.queries.results.FunctionResult;
import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class QueryProcessor {

    List<IFilterPeople> listOfFilters = new ArrayList<>();
    List<ICalculate> listOfCalculators = new ArrayList<>();
    List<ICutToPage> listOfPages = new ArrayList<>();
    Results results = new Results();
    public Results GetResults(SearchParameters parameters, List<Person> data){
        int i;
       results.setPages(1);


        return results;
    }

    public QueryProcessor addFilter(IFilterPeople item){
        listOfFilters.add(item);
        return this;
    }

    public QueryProcessor addCalculation(ICalculate anyCalculator){
        listOfCalculators.add(anyCalculator);
        return this;
    }

    public QueryProcessor addPageCutter(ICutToPage onePage){
        listOfPages.add(onePage);
        return this;
    }
}
