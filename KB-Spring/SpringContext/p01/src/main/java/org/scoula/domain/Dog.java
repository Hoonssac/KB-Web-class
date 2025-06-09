package org.scoula.domain;

public class Dog {
	private String name;
	private String breed;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	@Override
	public String toString() {
		return "[DOG] 이름: " + name + ", 견종: " + breed;
	}


}
