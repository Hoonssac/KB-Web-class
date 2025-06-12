package org.scoula.icecream.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class IcecreamVO {
	private Integer no;
	private String name;
	private String flavor;
	private Integer price;
	private LocalDateTime regDate;
}
