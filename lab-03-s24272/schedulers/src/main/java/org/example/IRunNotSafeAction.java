package org.example;


@FunctionalInterface
public interface IRunNotSafeAction {
    void executeNotSafeAction()
    throws Exception;

}
