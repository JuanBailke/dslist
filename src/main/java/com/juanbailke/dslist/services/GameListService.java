package com.juanbailke.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.juanbailke.dslist.dto.GameListDTO;
import com.juanbailke.dslist.projections.GameMinProjection;
import com.juanbailke.dslist.repositories.GameListRepository;
import com.juanbailke.dslist.repositories.GameRepository;
import com.juanbailke.dslist.services.exceptions.InvalidPositionException;

/* Camada de Serviço
 * Implementa as regras de negócio do sistema para habilitar a persistência no banco
 */

@Service
public class GameListService {
	
	@Autowired
	private GameListRepository gameListRepository;
	
	@Autowired
	private GameRepository gameRepository;
	
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll(){
		var result = gameListRepository.findAll();
		return result.stream().map(x -> new GameListDTO(x)).toList();
	}

	@Transactional
	public void move(Long listId, int sourceIndex, int destinationIndex) {
		try {
			var list = gameRepository.searchByList(listId);
			GameMinProjection obj = list.remove(sourceIndex);
			list.add(destinationIndex, obj);
			
			int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
			int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;
			
			for(int i=min; i<=max; i++) {
				gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
			}
		}catch(IndexOutOfBoundsException e) {
			throw new InvalidPositionException(e.getMessage());
		}
		
	}
	
}
