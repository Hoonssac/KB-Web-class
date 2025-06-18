package org.scoula.pokedex.dto;

import java.util.List;
import lombok.Data;

@Data
public class MovesItem{
	private List<VersionGroupDetailsItem> versionGroupDetails;
	private Move move;
}