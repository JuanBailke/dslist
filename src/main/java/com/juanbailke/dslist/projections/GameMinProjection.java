package com.juanbailke.dslist.projections;

/* 
 * Interface recebida na consulta personalizada da Query nativa do GameRepository
 */

public interface GameMinProjection {

	Long getId();
	String getTitle();
	Integer getGameYear();
	String getImgUrl();
	String getShortDescription();
	Integer getPosition();
}
