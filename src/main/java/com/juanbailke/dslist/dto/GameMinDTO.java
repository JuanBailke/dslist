package com.juanbailke.dslist.dto;

import com.juanbailke.dslist.entities.Game;
import com.juanbailke.dslist.projections.GameMinProjection;

/* Data Transfer Objects (DTO)
 * Padrão para transferência de objetos conforme atributos necessários
 * 
 * Classe utilizada para método GET findAll do GameController, retornando alguns atributos de todos os jogos para tela inicial
 * e para o método GET findById do GameListController, retornando alguns atributos dos jogos de uma lista
 * 
 */

public class GameMinDTO {
	
	private Long id;
	private String title;
	private Integer year;
	private String imgUrl;
	private String shortDescription;
	
	private GameMinDTO() {
		
	}

	public GameMinDTO(Game entity) {
		super();
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.year = entity.getYear();
		this.imgUrl = entity.getImgUrl();
		this.shortDescription = entity.getShortDescription();
	}
	
	public GameMinDTO(GameMinProjection projection) {
		super();
		this.id = projection.getId();
		this.title = projection.getTitle();
		this.year = projection.getGameYear();
		this.imgUrl = projection.getImgUrl();
		this.shortDescription = projection.getShortDescription();
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public Integer getYear() {
		return year;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public String getShortDescription() {
		return shortDescription;
	}
	
	

}
