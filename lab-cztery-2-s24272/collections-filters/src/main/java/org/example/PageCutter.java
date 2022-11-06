package org.example;

import org.example.interfaces.ICutToPage;
import org.example.model.Person;
import org.example.queries.search.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class PageCutter implements ICutToPage {

    @Override
    public List<Person> cut(Page page, List<Person> listOfPeople) {
        int whichStartElement = page.getPageNumber() * page.getSize() - page.getSize();
        int lastElement = page.getPageNumber() * page.getSize();
        List<Person> onePage = new ArrayList<>();
        if(page.getSize()< listOfPeople.size()) {
            for (int i = whichStartElement; i < lastElement - 1; i++) {
                onePage.add(listOfPeople.get(i));
            }
        } else {
            for (int i = 0; i<page.getSize()-1;i++){
                onePage.add(listOfPeople.get(i));
            }
        }

        return onePage;

    }
}
