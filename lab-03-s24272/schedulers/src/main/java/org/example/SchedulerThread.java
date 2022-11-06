package org.example;

import java.time.LocalDateTime;
import java.util.List;

public class SchedulerThread implements Runnable{



    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(100);
                List<Job> ListOfWorkers = Scheduler.getInstance().getWorkers();
                for (Job job : ListOfWorkers){
                    if(job.getTime()!= null && job.getTime().isBefore(LocalDateTime.now())) job.start();
                }

            } catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }


}
