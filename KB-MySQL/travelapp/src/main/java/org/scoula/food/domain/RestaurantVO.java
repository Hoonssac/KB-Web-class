package org.scoula.food.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantVO {
	private String name; // 맛집 이름
	private String category; // 맛집 카테고리
	private String address; // 주소
	private String description; // 설명
}
