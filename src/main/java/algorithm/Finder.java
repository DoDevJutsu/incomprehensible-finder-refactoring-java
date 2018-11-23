package algorithm;
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
		return mapNotNull(people.stream()
				.map(innerPerson -> Pair.fromUnordered(innerPerson, person)));
	}

	private <T> Stream<T> mapNotNull(Stream<Optional<T>> in) {
		return in.filter(Optional::isPresent).map(Optional::get);
	}
}
