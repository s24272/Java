package org.example;

import org.example.scheduler.interfaces.CompleteTasks;
import org.example.scheduler.interfaces.ErrorExeption;
import org.example.scheduler.interfaces.SingleAction;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Job {

    private IRunNotSafeAction action;
    private LocalDateTime time;
    private IProvideNextExecutionTime provideNextExecutionTime = null;
    private IProvideNextExecutionTime start;
    private ErrorExeption randomExeption = ex -> {};
    private SingleAction oneOfAction = () -> {};
    private CompleteTasks doneTask = () -> {};

    public Job(IRunNotSafeAction action) {
        this.action = action;
    }

    public void start(){
        try {
            action.executeNotSafeAction();
            oneOfAction.oneAction();
            time = start.provideTime();
        } catch (Exception exception){
            randomExeption.takeError(exception);
            time = start.provideTime();
        } finally {
            if(time==null) doneTask.doneTasks();
        }
    }

    public IRunNotSafeAction getAction() {
        return action;
    }

    public void setAction(IRunNotSafeAction action) {
        this.action = action;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public IProvideNextExecutionTime getProvideNextExecutionTime() {
        return provideNextExecutionTime;
    }

    public void setProvideNextExecutionTime(IProvideNextExecutionTime provideNextExecutionTime) {
        this.provideNextExecutionTime = provideNextExecutionTime;
    }

    public Job useExecutionTimeProvider(IProvideNextExecutionTime start){
        this.start = start;
        this.time = start.provideTime();
        return this;
    }

    public Job onError (ErrorExeption ex){
         this.randomExeption = ex;
         return this;
    }

    public Job onSingleActionCompleted(SingleAction oneOfAction){
        this.oneOfAction=oneOfAction;
        return this;
    }

    public Job onCompleted(CompleteTasks doneTask){
        this.doneTask=doneTask;
        return this;
    }

    public void schedule(){
        Scheduler.getInstance().getWorkers().add(this);
    }

}
