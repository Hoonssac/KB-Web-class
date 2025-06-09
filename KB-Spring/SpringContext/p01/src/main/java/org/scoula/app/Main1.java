package org.scoula.app;

import org.scoula.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main1 {
	public static void main(String[] args) {
		var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

		System.out.println("[1] 등록된 강아지 목록:");
		System.out.println(context.getBean("꼬미"));
		System.out.println(context.getBean("밤비"));
		System.out.println(context.getBean("해피"));
	}
}
