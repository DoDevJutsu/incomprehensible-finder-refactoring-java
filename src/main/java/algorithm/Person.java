package algorithm;

import java.util.Date;

public class Person {
	private String name;
	private Date birthDate;

	public Person(String name, Date birthDate) {
		this.name = name;
		this.birthDate = birthDate;
	}

	Boolean isYoungerThan(Person anotherPerson) {
		return birthDate.getTime() < anotherPerson.birthDate.getTime();
	}

	long ageDifferenceWith(Person anotherPerson) {
		return birthDate.getTime() - anotherPerson.birthDate.getTime();
	}
}

