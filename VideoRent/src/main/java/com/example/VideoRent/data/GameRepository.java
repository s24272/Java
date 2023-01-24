package com.example.VideoRent.data;

import com.example.VideoRent.entity.Games;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends CrudRepository<Games,Integer> {
}
