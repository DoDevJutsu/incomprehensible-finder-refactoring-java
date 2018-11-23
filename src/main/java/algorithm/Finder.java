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

		for (Person outerPerson : people) {
			for (Person innerPerson : people) {
				if (innerPerson != outerPerson) {
					tr.add(Pair.fromUnordered(outerPerson, innerPerson));
				}
			}
		}

        return tr.stream().reduce(sortBy::choose);
    }
}
