package org.scoula.pokedex.dto;

import lombok.Data;

@Data
public class VersionGroupDetailsItem{
	private int levelLearnedAt;
	private VersionGroup versionGroup;
	private MoveLearnMethod moveLearnMethod;
	private Object order;
}