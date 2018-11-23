package algorithm;
import java.util.ArrayList;
import java.util.List;

public class Finder {
	private final List<Person> people;

	public Finder(List<Person> people) {
		this.people = people;
	}

	public F Find(FT ft) {
		List<F> tr = new ArrayList<F>();

		for (int i = 0; i < people.size() - 1; i++) {
			for (int j = i + 1; j < people.size(); j++) {
				F result = new F();
				Person personA = people.get(i);
				Person personB = people.get(j);
				if (personA.isYoungerThan(personB)) {
					result.P1 = personA;
					result.P2 = personB;
				} else {
					result.P1 = personB;
					result.P2 = personA;
				}
				result.ageDifference = result.P2.ageDifferenceWith(result.P1);
				tr.add(result);
			}
		}

		if (tr.size() < 1) {
			return new F();
		}

		F answer = tr.get(0);
		for (F result : tr) {
			switch (ft) {
				case One :
					if (result.ageDifference < answer.ageDifference) {
						answer = result;
					}
					break;

				case Two :
					if (result.ageDifference > answer.ageDifference) {
						answer = result;
					}
					break;
			}
		}

		return answer;
	}
}
