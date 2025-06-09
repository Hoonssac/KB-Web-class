package org.scoula.beans;

import org.springframework.beans.factory.annotation.Qualifier;

public class Person {

	private String name = "Elia";

	private final Parrot parrot;

	public Person(@Qualifier("parrot2") Parrot parrot) {
		this.parrot = parrot;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Parrot getParrot() {
		return parrot;
	}
}
