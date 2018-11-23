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
				if (people.get(i).birthDate.getTime() < people.get(j).birthDate.getTime()) {
					r.P1 = people.get(i);
					r.P2 = people.get(j);
				} else {
					r.P1 = people.get(j);
					r.P2 = people.get(i);
				}
				r.D = r.P2.birthDate.getTime() - r.P1.birthDate.getTime();
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
					if (result.D < answer.D) {
						answer = result;
					}
					break;

				case Two :
					if (result.D > answer.D) {
						answer = result;
					}
					break;
			}
		}

		return answer;
	}
}
