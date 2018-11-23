package algorithm;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Finder {
	private final List<Person> people;

	public Finder(List<Person> people) {
		this.people = people;
	}

	public Optional<Pair> Find(SortBy sortBy) {
		return pairs().reduce(sortBy::choose);
    }

	private Stream<Pair> pairs() {
		return people.stream().flatMap(this::combineAllWith);
	}

	private Stream<Pair> combineAllWith(Person person) {
		List<Optional<Pair>> pairs = new ArrayList<>();

		for (Person innerPerson : people) {
			pairs.add(Pair.fromUnordered(person, innerPerson));
		}

		return pairs.stream()
				.filter(Optional::isPresent)
				.map(Optional::get);
	}
}
