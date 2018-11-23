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
				tr.add(Pair.fromUnordered(people.get(i), people.get(j)));
			}
		}

		if (tr.size() < 1) {
			return Optional.empty();
		}

		Pair answer = tr.get(0);
		for (Pair pair : tr) {
            answer = sortBy.choose(answer, pair);
        }

		return Optional.of(answer);
	}

}
