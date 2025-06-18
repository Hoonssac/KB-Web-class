package org.scoula.pokedex.dto;

import java.util.List;
import lombok.Data;

@Data
public class HeldItemsItem{
	private Item item;
	private List<VersionDetailsItem> versionDetails;
}