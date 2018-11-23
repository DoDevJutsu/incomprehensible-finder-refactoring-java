package algorithm;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Finder {
	private final List<Person> people;

	public Finder(List<Person> people) {
		this.people = people;
	}

	public Optional<Pair> Find(SortBy sortBy) {
		List<Pair> tr = new ArrayList<>();

		for (int i = 0; i < people.size() - 1; i++) {
			for (int j = i + 1; j < people.size(); j++) {
				Person personA = people.get(i);
				Person personB = people.get(j);
				Pair pair;
				if (personA.isYoungerThan(personB)) {
					pair = new Pair(personA, personB);
				} else {
					pair = new Pair(personB, personA);
				}
				tr.add(pair);
			}
		}

		if (tr.size() < 1) {
			return Optional.empty();
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

		return Optional.of(answer);
	}
}
