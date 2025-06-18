package org.scoula.pokedex.dto;

import java.util.List;

import lombok.Data;

@Data
public class PokemonListResponse {
	private List<PokemonListResult> results;
}
