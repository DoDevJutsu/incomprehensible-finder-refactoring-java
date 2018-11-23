package algorithm;

import java.util.Date;

public class Person {
	public String name;
	public Date birthDate;

	Boolean isYoungerThan(Person anotherPerson) {
		return birthDate.getTime() < anotherPerson.birthDate.getTime();
	}
}

