package org.scoula.app;

import org.scoula.config.ProjectConfig;
import org.scoula.domain.Parrot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		// Spring Context 생성
		var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

		// 해당 타입의 bean을 context에서 꺼내온다
		Parrot p = context.getBean(Parrot.class);
		System.out.println(p.getName());

		// 동일한 타입에 대해서는 하나의 bean만 추출 가능
		// 같은 타입의 bean이 여러개면 예외 발생
		String s = context.getBean(String.class);
		System.out.println(s);

		Integer n = context.getBean(Integer.class);
		System.out.println(n);
	}
}
