package com.juanbailke.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.juanbailke.dslist.dto.GameDTO;
import com.juanbailke.dslist.dto.GameMinDTO;
import com.juanbailke.dslist.repositories.GameRepository;
import com.juanbailke.dslist.services.exceptions.ResourceNotFoundException;

/* Camada de Serviço
 * Implementa as regras de negócio do sistema para habilitar a persistência no banco
 * 
 * 
 */

@Service
public class GameService {

	@Autowired
	private GameRepository gameRepository;

	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll() {
		var result = gameRepository.findAll();
		return result.stream().map(x -> new GameMinDTO(x)).toList();
	}

	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		var result = gameRepository.findById(id);
		return new GameDTO(result.orElseThrow(() -> new ResourceNotFoundException(id)));
	}

	@Transactional(readOnly = true)
	public List<GameMinDTO> findByList(Long listId) {
		var result = gameRepository.searchByList(listId);
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		if (dto.isEmpty()) 
			throw new ResourceNotFoundException(listId);
		return dto;
	}
}
