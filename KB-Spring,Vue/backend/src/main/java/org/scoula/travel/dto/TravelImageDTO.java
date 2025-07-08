package org.scoula.travel.dto;

import org.scoula.travel.domain.TravelImageVO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TravelImageDTO {
	private static final String BASE = System.getProperty("user.home") + "/Desktop/KB-web-class/KB-Spring,Vue/travel-image/";
	private long no;
	private String filename;
	private long travelNo;

	public static TravelImageDTO of (TravelImageVO vo) {
		return TravelImageDTO.builder()
			.no(vo.getNo())
			.filename(vo.getFilename())
			.travelNo(vo.getTravelNo())
			.build();
	}

	@JsonIgnore // JSON 변환에서 제외
	public String getPath() {
		String fullPath = BASE + filename;
		System.out.println("Attempting to access image at path: " + fullPath);
		return fullPath;
	}

	// 프론트엔드에서 사용할 url 프로퍼티
	public String getUrl() {
		return "/api/travel/image/" + no;
	}
}
