package com.juanbailke.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juanbailke.dslist.dto.GameListDTO;
import com.juanbailke.dslist.dto.GameMinDTO;
import com.juanbailke.dslist.dto.ReplacementDTO;
import com.juanbailke.dslist.services.GameListService;
import com.juanbailke.dslist.services.GameService;

/* Camada de Controle REST
 * 
 * implementadas requisições GET para busca dos dados já inseridos no banco
 * e uma requisição POST para atualização de posição de um jogo na lista através do corpo JSON
 * 
 */

@RestController
@RequestMapping(value="/lists")
public class GameListController {
	
	@Autowired
	private GameListService gameListService;
	
	@Autowired
	private GameService gameService;
	
	@GetMapping
	public List<GameListDTO> findAll(){
		List<GameListDTO> result = gameListService.findAll();
		return result;
	}
	
	@GetMapping(value="/{listId}/games")
	public List<GameMinDTO> findById(@PathVariable Long listId){
		List<GameMinDTO> result = gameService.findByList(listId);
		return result;
	}
	
	@PostMapping(value="/{listId}/replacement")
	public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body){
		gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
	}

}
