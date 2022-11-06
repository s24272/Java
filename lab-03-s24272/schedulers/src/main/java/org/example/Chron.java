package org.example;

import java.time.Duration;
import java.time.LocalDateTime;

public class Chron  {

    private LocalDateTime startTime = LocalDateTime.now();
    private LocalDateTime endTime;
    private Duration interval = Duration.ofSeconds(1);
    private  int counter;
    private  int maxCount = -1;


    private LocalDateTime getNextTime() {
        if(endTime!=null && endTime.isBefore(startTime)) return null;
        if(maxCount>0 && counter>maxCount) return null;
        if(counter==0){
            counter++;
            return startTime;
        }
        startTime = startTime.plus(interval);
        counter++;
        return startTime;
    }

    public Chron setStartTime(LocalDateTime localDateTime){
        this.startTime=localDateTime;
        return this;
    }

    public Chron setEndDate(LocalDateTime endDataTime){
        this.endTime=endDataTime;
        return this;
    }
    public Chron setMaxExecutionTimes(int maxCount){
        this.maxCount=maxCount;
        return this;
    }
   public Chron setIntervalDuration(Duration interval){
        this.interval = interval;
        return this;
    }

    public static Chron builder(){
        return new Chron();
    }

    public IProvideNextExecutionTime buildNextTimeExecutionProvider(){
        return ()->getNextTime() ;
    }



}
/**
 * Twoim pierwszym zadaniem jest napisanie
 * klasy o nazwie "Chron",
 * która jest przykładem prostej implementacji
 * wzorca projektowego "budowniczego".
 * Budowniczy w tym przykładzie zwraca metodę
 * wytwórczą, która ma być implementacją wcześniej utworzonego interfejsu.
 *
 * Chodzi o taką implemntację tych wzorców,
 * gdzie można ustawić:
 *      -> setStartTime: godzinę startu (domyślnie teraz)
 *      -> setEndTime: godzinę końca (domyślnie nigdy),
 *      -> setMaxExecutionTimes: ilość powtórzeń wykonania
 *          (czyli ile kolejnych godzin\czasów ma zwrócić - domyślnie ma wykonywać w nieskończoność),
 *      -> setIntervalDuration: odstęp czasowy między kolejnymi godzinami/ czasami (domyślnie 1 sekunda)
 *
 * Metoda buildNextTimeExecutionProvider ma zwracać lambdę,
 * która generuje kolejną godzinę według wcześniej podanych parametrów
 * UAWAGA !
 * Najlepiej zrobić tak, aby klasa Chron implementowała "buildera" (budowniczego) - w sensie nie robić buildera jako odrębnej klasy
 */