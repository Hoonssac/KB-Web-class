package org.scoula.food.dataimport;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.scoula.database.JDBCUtil;
import org.scoula.food.dao.RestaurantDao;
import org.scoula.food.dao.RestaurantDaoImpl;
import org.scoula.food.domain.RestaurantReviewVO;
import org.scoula.food.domain.RestaurantVO;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;

public class ImportReviewData {
	public static void main(String[] args) throws CsvValidationException, IOException {
		RestaurantDao dao = new RestaurantDaoImpl();

		List<RestaurantReviewVO> reviews = new CsvToBeanBuilder<RestaurantReviewVO>(new FileReader("reviews_pokemon.csv"))
			.withType(RestaurantReviewVO.class)
			.build()
			.parse();

		reviews.forEach(review -> {
			System.out.println(review);
			dao.insertReview(review);
		});

		JDBCUtil.close();
	}
}
