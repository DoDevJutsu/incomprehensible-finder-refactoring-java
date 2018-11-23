package algorithm;

import java.util.Date;

public class Person {
	private Date birthDate;

	public Person(Date birthDate) {
		this.birthDate = birthDate;
	}

	private Boolean isYoungerThan(Person anotherPerson) {
		return birthDate.getTime() < anotherPerson.birthDate.getTime();
	}

	long ageDifferenceWith(Person anotherPerson) {
		return birthDate.getTime() - anotherPerson.birthDate.getTime();
	}

	Person youngest(Person anotherPerson) {
		return isYoungerThan(anotherPerson) ? this : anotherPerson;
	}

	Person oldest(Person anotherPerson) {
		return isYoungerThan(anotherPerson) ? anotherPerson : this;
	}
}

