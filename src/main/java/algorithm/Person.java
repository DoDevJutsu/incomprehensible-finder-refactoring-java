package algorithm;

import java.util.Date;

public class Person {
	private Date birthDate;

	public Person(Date birthDate) {
		this.birthDate = birthDate;
	}

	Boolean isYoungerThan(Person anotherPerson) {
		return birthDate.getTime() < anotherPerson.birthDate.getTime();
	}

	long ageDifferenceWith(Person anotherPerson) {
		return birthDate.getTime() - anotherPerson.birthDate.getTime();
	}
}

