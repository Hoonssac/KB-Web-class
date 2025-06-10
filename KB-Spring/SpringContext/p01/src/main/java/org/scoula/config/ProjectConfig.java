package org.scoula.config;

import org.scoula.domain.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.scoula")
public class ProjectConfig {

	// @Bean(name="꼬미")
	// Dog dog1() {
	// 	Dog dog = new Dog("꼬미", "푸들");
	// 	return dog;
	// }
	//
	// @Bean(name="밤비")
	// Dog dog2() {
	// 	Dog dog = new Dog("밤비", "시바견");
	// 	return dog;
	// }
	//
	// @Bean(name="해피")
	// Dog dog3() {
	// 	Dog dog = new Dog("해피", "진돗개");
	// 	return dog;
	// }

}
