package algorithm;

import java.util.Objects;

public class Pair {
	private Person personA;
	private Person personB;

	public Pair(Person personA, Person personB) {
		this.personA = personA;
		this.personB = personB;
	}

	private long ageDifference() {
		return personB.ageDifferenceWith(personA);
	}

	boolean areCloserInAgeThan(Pair answer) {
		return ageDifference() < answer.ageDifference();
	}

	boolean areFurtherInAgeThan(Pair answer) {
		return !areCloserInAgeThan(answer);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Pair pair = (Pair) o;
		return Objects.equals(personA, pair.personA) &&
				Objects.equals(personB, pair.personB);
	}

	@Override
	public int hashCode() {
		return Objects.hash(personA, personB);
	}
}
