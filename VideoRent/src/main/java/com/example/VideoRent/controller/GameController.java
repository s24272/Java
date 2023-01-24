package com.example.VideoRent.controller;

import com.example.VideoRent.entity.Games;
import com.example.VideoRent.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/games")
public class GameController {

    private GameService gameService;
    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/all")
    public Iterable<Games> getAll(){
        return gameService.findAll();
    }
    @GetMapping("{id}")
    public Optional<Games> findById(@PathVariable int id){
        return gameService.find(id);
    }
    @PostMapping("/add")
    public Games addGame(@RequestBody Games game){
        return gameService.save(game);
    }
    @PutMapping("/ubdate")
    public Games updateGame(@RequestBody Games game){
        return gameService.save(game);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        gameService.delete(id);
    }
}
