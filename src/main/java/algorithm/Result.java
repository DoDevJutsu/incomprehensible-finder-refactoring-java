package algorithm;
public class Result {
	public Person P1;
	public Person P2;

	private long ageDifference() {
		return P2.ageDifferenceWith(P1);
	}

	boolean hasCloserAgesThan(Result answer) {
		return ageDifference() < answer.ageDifference();
	}

	boolean hasFartherAgesThan(Result answer) {
		return !hasCloserAgesThan(answer);
	}
}
