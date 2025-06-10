package org.scoula.ex03.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class SmapleDTOList {
	private List<SampleDTO> list;

	public SmapleDTOList() {
		list = new ArrayList<>();
	}
}
