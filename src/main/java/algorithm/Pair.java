package algorithm;
public class Pair {
	public Person personA;
	public Person personB;

	private long ageDifference() {
		return personB.ageDifferenceWith(personA);
	}

	boolean areCloserInAgeThan(Pair answer) {
		return ageDifference() < answer.ageDifference();
	}

	boolean areFurtherInAgeThan(Pair answer) {
		return !areCloserInAgeThan(answer);
	}
}
