package org.scoula.food.domain;

import com.opencsv.bean.CsvBindByName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantReviewVO {
	private Long no;

	@CsvBindByName(column = "restaurant_id")
	private Long restaurantId;

	@CsvBindByName
	private String writer;

	@CsvBindByName
	private String content;

	@CsvBindByName
	private int score;
}
