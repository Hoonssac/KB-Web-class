package org.scoula.service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.scoula.domain.Dog;
import org.springframework.stereotype.Component;

@Component
public class RescueCenter {

	private final List<Dog> dogs;

	public RescueCenter(List<Dog> dogs) {
		this.dogs = dogs;
	}

	private final Map<String, Integer> priorityMap = Map.of(
		"진돗개", 1,
		"시바견", 2,
		"푸들", 3
	);

	@PostConstruct
	public void init() {
		dogs.sort(Comparator.comparingInt(dog -> priorityMap.getOrDefault(dog.getBreed(), 100)));
		System.out.println("📋구조 우선순위에 따라 구조를 시작합니다!");
		for (Dog dog : dogs) {
			System.out.println("🐻안아줌 완료: " + dog);
		}
	}
}
