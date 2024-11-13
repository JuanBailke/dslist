package com.juanbailke.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juanbailke.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}
