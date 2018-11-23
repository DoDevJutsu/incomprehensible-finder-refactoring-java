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
				F r = new F();
				Person personA = people.get(i);
				Person personB = people.get(j);
				if (personA.isYoungerThan(personB)) {
					r.P1 = personA;
					r.P2 = personB;
				} else {
					r.P1 = personB;
					r.P2 = personA;
				}
				r.ageDifference = r.P2.ageDifferenceWith(r.P1);
				tr.add(r);
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
