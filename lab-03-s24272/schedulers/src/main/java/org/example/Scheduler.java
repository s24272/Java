package org.example;

import java.util.ArrayList;
import java.util.List;

public class Scheduler {

    private IRunNotSafeAction randomError;
    List<Job> workers = new ArrayList<>();
    private Scheduler() {

    }
    private static Scheduler instance = null;
    public static Scheduler getInstance()
    {
        if (instance == null) {
                instance = new Scheduler();
            }
            return instance;
    }

    public List<Job> getWorkers() {
        return workers;
    }

    public Job forAction(IRunNotSafeAction randomError){

            return new Job(randomError);
    }


}

