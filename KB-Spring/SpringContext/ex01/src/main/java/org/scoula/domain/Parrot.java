package org.scoula.domain;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component // 디폴트 컴포넌트의 name: 클새스명의 camelCase - parrot
public class Parrot {
	private String name;

	@PostConstruct // bean이 생성된 후 자동으로 호출 -> 초기화
	public void init() {
		this.name = "Kiki";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
