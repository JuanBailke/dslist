package com.juanbailke.dslist.dto;

/* Data Transfer Objects (DTO)
 * Padrão para transferência de objetos conforme atributos necessários
 * 
 * Classe utilizada para método POST do GameListController, recebendo a posição inicial de um jogo e a posição de destino
 * 
 */

public class ReplacementDTO {

	private Integer sourceIndex;
	private Integer destinationIndex;
	
	
	public Integer getSourceIndex() {
		return sourceIndex;
	}
	public void setSourceIndex(Integer sourceIndex) {
		this.sourceIndex = sourceIndex;
	}
	public Integer getDestinationIndex() {
		return destinationIndex;
	}
	public void setDestinationIndex(Integer destinationIndex) {
		this.destinationIndex = destinationIndex;
	}
	
}
