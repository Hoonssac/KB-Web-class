package org.scoula.pokedex.dto;

import java.util.List;
import lombok.Data;

@Data
public class PokemonDTO {
	private int id;
	private String name;
	private int height;
	private int weight;
	private Sprites sprites;
	private List<TypesItem> types;
	private List<StatsItem> stats;
}