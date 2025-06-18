package org.scoula.pokedex.dto;

import lombok.Data;

@Data
public class AbilitiesItem{
	private boolean isHidden;
	private Object ability;
	private int slot;
}