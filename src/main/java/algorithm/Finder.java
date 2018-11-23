package algorithm;
import java.util.ArrayList;
import java.util.List;

public class Finder {
	private final List<Person> people;

	public Finder(List<Person> people) {
		this.people = people;
	}

	public Result Find(FT ft) {
		List<Result> tr = new ArrayList<Result>();

		for (int i = 0; i < people.size() - 1; i++) {
			for (int j = i + 1; j < people.size(); j++) {
				Result result = new Result();
				Person personA = people.get(i);
				Person personB = people.get(j);
				if (personA.isYoungerThan(personB)) {
					result.P1 = personA;
					result.P2 = personB;
				} else {
					result.P1 = personB;
					result.P2 = personA;
				}
				tr.add(result);
			}
		}

		if (tr.size() < 1) {
			return new Result();
		}

		Result answer = tr.get(0);
		for (Result result : tr) {
			switch (ft) {
				case One :
					if (result.hasCloserAgesThan(answer)) {
						answer = result;
					}
					break;

				case Two :
					if (result.hasFartherAgesThan(answer)) {
						answer = result;
					}
					break;
			}
		}

		return answer;
	}
}
