package algorithm;
import java.util.ArrayList;
import java.util.List;

public class Finder {
	private final List<Person> people;

	public Finder(List<Person> people) {
		this.people = people;
	}

	public Pair Find(SortBy sortBy) {
		List<Pair> tr = new ArrayList<Pair>();

		for (int i = 0; i < people.size() - 1; i++) {
			for (int j = i + 1; j < people.size(); j++) {
				Pair pair = new Pair();
				Person personA = people.get(i);
				Person personB = people.get(j);
				if (personA.isYoungerThan(personB)) {
					pair.personA = personA;
					pair.personB = personB;
				} else {
					pair.personA = personB;
					pair.personB = personA;
				}
				tr.add(pair);
			}
		}

		if (tr.size() < 1) {
			return new Pair();
		}

		Pair answer = tr.get(0);
		for (Pair pair : tr) {
			switch (sortBy) {
				case Closer:
					if (pair.areCloserInAgeThan(answer)) {
						answer = pair;
					}
					break;

				case Further:
					if (pair.areFurtherInAgeThan(answer)) {
						answer = pair;
					}
					break;
			}
		}

		return answer;
	}
}
