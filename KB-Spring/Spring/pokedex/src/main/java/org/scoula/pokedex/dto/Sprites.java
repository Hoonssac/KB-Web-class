package org.scoula.pokedex.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Sprites{
	@JsonProperty("front_default")
	private String frontDefault;
}