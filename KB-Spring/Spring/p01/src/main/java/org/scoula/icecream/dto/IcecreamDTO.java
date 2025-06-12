package org.scoula.icecream.dto;

import java.time.LocalDateTime;

import org.scoula.icecream.domain.IcecreamVO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IcecreamDTO {
	private Integer no;
	private String name;
	private String flavor;
	private Integer price;
	private LocalDateTime regDate;

	// VO -> DTO
	public static IcecreamDTO of (IcecreamVO vo) {
		return vo == null ? null : IcecreamDTO.builder()
			.no(vo.getNo())
			.name(vo.getName())
			.flavor(vo.getFlavor())
			.price(vo.getPrice())
			.regDate(vo.getRegDate())
			.build();
	}

	// DTO -> VO
	public IcecreamVO toVo() {
		return IcecreamVO.builder()
			.no(no)
			.name(name)
			.flavor(flavor)
			.price(price)
			.regDate(regDate)
			.build();
	}
}
