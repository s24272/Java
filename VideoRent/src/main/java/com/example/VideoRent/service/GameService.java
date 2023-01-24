package com.example.VideoRent.service;

import com.example.VideoRent.data.GameRepository;
import com.example.VideoRent.entity.Games;
import com.example.VideoRent.entity.VideoCasset;
import com.example.VideoRent.enums.GameType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class GameService {

    private GameRepository gameRepository;
    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Optional<Games> find(int id){
        return gameRepository.findById(id);
    }

    public Iterable<Games> findAll(){
        return gameRepository.findAll();
    }

    public Games save(Games game){
        return gameRepository.save(game);
    }

    public void delete(int id){
        gameRepository.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB(){
        save(new Games(1, "CounterStrike", GameType.FPS, LocalDate.of(2012,9,11)));
        save(new Games(2, "Witcher", GameType.RPG, LocalDate.of(2014,5,17)));
    }


}
