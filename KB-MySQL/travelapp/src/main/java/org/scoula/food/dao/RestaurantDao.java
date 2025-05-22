package org.scoula.food.dao;

import org.scoula.food.domain.RestaurantReviewVO;
import org.scoula.food.domain.RestaurantVO;

public interface RestaurantDao {
	void insert(RestaurantVO restaurant);
	void insertReview(RestaurantReviewVO review);
}
