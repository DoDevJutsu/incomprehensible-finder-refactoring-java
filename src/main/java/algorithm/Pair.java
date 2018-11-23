package algorithm;

import java.util.Objects;

public class Pair {
	private Person youngest;
	private Person oldest;

	private Pair(Person youngest, Person oldest) {
		this.youngest = youngest;
		this.oldest = oldest;
	}

	public static Pair fromUnordered(Person personA, Person personB) {
		return new Pair(
				personA.youngest(personB),
				personA.oldest(personB));
	}

	private long ageDifference() {
		return oldest.ageDifferenceWith(youngest);
	}

	private boolean isCloserInAgeThan(Pair answer) {
		return ageDifference() < answer.ageDifference();
	}

	Pair closestInAge(Pair anotherPair) {
		return isCloserInAgeThan(anotherPair) ? this : anotherPair;
	}

	Pair furthestInAge(Pair anotherPair) {
		return isCloserInAgeThan(anotherPair) ? anotherPair : this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Pair pair = (Pair) o;
		return Objects.equals(youngest, pair.youngest) &&
				Objects.equals(oldest, pair.oldest);
	}

	@Override
	public int hashCode() {
		return Objects.hash(youngest, oldest);
	}
}
