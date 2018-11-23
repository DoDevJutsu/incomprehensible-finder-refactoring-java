package algorithm;
public class Result {
	public Person personA;
	public Person personB;

	private long ageDifference() {
		return personB.ageDifferenceWith(personA);
	}

	boolean areCloserInAgeThan(Result answer) {
		return ageDifference() < answer.ageDifference();
	}

	boolean areFurtherInAgeThan(Result answer) {
		return !areCloserInAgeThan(answer);
	}
}
