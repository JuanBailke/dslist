package com.juanbailke.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.juanbailke.dslist.entities.GameList;

/* Camada de Repositório
 * Implementa acesso aos dados
 * 
 * Criada Query updateBelongingPosition para atualizar a posição de um jogo de uma lista
 */

public interface GameListRepository extends JpaRepository<GameList, Long> {

	@Modifying
	@Query(nativeQuery = true, value = "UPDATE tb_belonging SET position = :newPosition WHERE list_id = :listId AND game_id = :gameId")
	void updateBelongingPosition(Long listId, Long gameId, Integer newPosition);
}
