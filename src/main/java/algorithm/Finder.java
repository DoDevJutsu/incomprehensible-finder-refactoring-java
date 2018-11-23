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
		return pairs().stream().reduce(sortBy::choose);
    }

	private List<Pair> pairs() {
		List<Pair> pairs = new ArrayList<>();

		for (Person outerPerson : people) {
			for (Person innerPerson : people) {
				if (innerPerson != outerPerson) {
					pairs.add(Pair.fromUnordered(outerPerson, innerPerson));
				}
			}
		}

		return pairs;
	}
}
