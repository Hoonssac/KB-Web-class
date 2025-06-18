package org.scoula.pokedex.dto;

import java.util.List;
import lombok.Data;

@Data
public class PastAbilitiesItem{
	private List<AbilitiesItem> abilities;
	private Generation generation;
}