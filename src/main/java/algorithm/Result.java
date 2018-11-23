package algorithm;
public class Result {
	public Person P1;
	public Person P2;

	private long ageDifference() {
		return P2.ageDifferenceWith(P1);
	}

	boolean areCloserInAgeThan(Result answer) {
		return ageDifference() < answer.ageDifference();
	}

	boolean areFurtherInAgeThan(Result answer) {
		return !areCloserInAgeThan(answer);
	}
}
