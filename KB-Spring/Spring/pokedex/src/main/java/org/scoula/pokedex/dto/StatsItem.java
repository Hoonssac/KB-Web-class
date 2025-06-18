package org.scoula.pokedex.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class StatsItem{
	private Stat stat;
	@JsonProperty("base_stat")
	private int baseStat;
}