package com.juanbailke.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.juanbailke.dslist.dto.GameListDTO;
import com.juanbailke.dslist.dto.GameMinDTO;
import com.juanbailke.dslist.repositories.GameListRepository;

@Service
public class GameListService {
	
	@Autowired
	private GameListRepository gameListRepository;

	@Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		var result = gameListRepository.findAll();
		return result.stream().map(x -> new GameListDTO(x)).toList();
	}

}
