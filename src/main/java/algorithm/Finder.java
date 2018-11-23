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
		if (!areThereAnyPairs()) {
			return Optional.empty();
		}

		List<Pair> tr = new ArrayList<>();

		for (int i = 0; i < people.size() - 1; i++) {
			for (int j = i + 1; j < people.size(); j++) {
				tr.add(Pair.fromUnordered(people.get(i), people.get(j)));
			}
		}

		Pair answer = tr.stream().reduce(sortBy::choose).get();

		return Optional.of(answer);
	}

	private boolean areThereAnyPairs() {
		return people.size() >= 2;
	}

}
