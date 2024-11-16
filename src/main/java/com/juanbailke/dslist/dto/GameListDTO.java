package com.juanbailke.dslist.dto;

import com.juanbailke.dslist.entities.GameList;

/* Data Transfer Objects (DTO)
 * Padrão para transferência de objetos conforme atributos necessários
 * 
 * Classe utilizada para método GET findAll, retornando todas as listas salvas
 * 
 */

public class GameListDTO {
	
	private Long id;
	private String name;
	
	public GameListDTO() {
		
	}
	
	public GameListDTO(GameList entity) {
		id = entity.getId();
		name = entity.getName();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	
}
