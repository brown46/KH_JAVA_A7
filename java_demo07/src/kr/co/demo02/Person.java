package kr.co.demo02;

public class Person {

	private String name;
	private int age;
	private char gender;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return String.format("Person[name:%s, age:%d]", name, age);
	}

	@Override
	public boolean equals(Object obj) {
		Person person = (Person) obj;
		if (name.equals(person.getName()) && 
				age == person.getAge() && 
				gender == person.getGender()) {
			return true;
		}

		return false;
	}

}
