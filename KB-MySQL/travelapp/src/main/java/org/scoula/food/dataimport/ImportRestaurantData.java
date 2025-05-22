package org.scoula.food.dataimport;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.scoula.database.JDBCUtil;
import org.scoula.food.dao.RestaurantDao;
import org.scoula.food.dao.RestaurantDaoImpl;
import org.scoula.food.domain.RestaurantVO;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;

public class ImportRestaurantData {
	public static void main(String[] args) throws CsvValidationException, IOException {
		RestaurantDao dao = new RestaurantDaoImpl();

		List<RestaurantVO> restaurants = new CsvToBeanBuilder<RestaurantVO>(new FileReader("restaurant.csv"))
			.withType(RestaurantVO.class)
			.build()
			.parse();

		restaurants.forEach(restaurant -> {
			System.out.println(restaurant);
			dao.insert(restaurant);
		});

		JDBCUtil.close();
	}
}
