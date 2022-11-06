package org.example.interfaces;

import org.example.model.Person;

@FunctionalInterface
public interface ItemToCalculate {
    double number(Person income);
}
