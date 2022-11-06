package org.example.scheduler.interfaces;

@FunctionalInterface
public interface ErrorExeption <T extends Throwable> {
    void takeError(T random);
}
