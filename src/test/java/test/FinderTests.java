package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

import algorithm.Pair;
import algorithm.SortBy;
import algorithm.Finder;
import algorithm.Person;

public class FinderTests {

	private Person sue = new Person("Sue", new Date(50, 0, 1));
	private Person greg = new Person("Greg", new Date(52, 5, 1));
	private Person sarah = new Person("Sarah", new Date(82, 0, 1));
	private Person mike = new Person("Mike", new Date(79, 0, 1));

	@Test
	public void Returns_Empty_Results_When_Given_Empty_List() {
		List<Person> list = new ArrayList<Person>();
		Finder finder = new Finder(list);

		Optional<Pair> pair = finder.Find(SortBy.Closer);

		assertFalse(pair.isPresent());
	}

	@Test
	public void Returns_Empty_Results_When_Given_One_Person() {
		List<Person> list = new ArrayList<Person>();
		list.add(sue);

		Finder finder = new Finder(list);

		Optional<Pair> pair = finder.Find(SortBy.Closer);

		assertFalse(pair.isPresent());
	}

	@Test
	public void Returns_Closest_Two_For_Two_People() {
		List<Person> list = new ArrayList<Person>();
		list.add(sue);
		list.add(greg);
		Finder finder = new Finder(list);

		Optional<Pair> pair = finder.Find(SortBy.Closer);

		Pair expectedPair = Pair.fromUnordered(sue, greg);
		assertTrue(pair.isPresent());
		assertEquals(expectedPair, pair.get());
	}

	@Test
	public void Returns_Furthest_Two_For_Two_People() {
		List<Person> list = new ArrayList<Person>();
		list.add(mike);
		list.add(greg);

		Finder finder = new Finder(list);

		Optional<Pair> pair = finder.Find(SortBy.Further);

		Pair expectedPair = Pair.fromUnordered(greg, mike);
		assertTrue(pair.isPresent());
		assertEquals(expectedPair, pair.get());
	}

	@Test
	public void Returns_Furthest_Two_For_Four_People() {
		List<Person> list = new ArrayList<Person>();
		list.add(sue);
		list.add(sarah);
		list.add(mike);
		list.add(greg);
		Finder finder = new Finder(list);

		Optional<Pair> pair = finder.Find(SortBy.Further);

		Pair expectedPair = Pair.fromUnordered(sue, sarah);
		assertTrue(pair.isPresent());
		assertEquals(expectedPair, pair.get());
	}

	@Test
	public void Returns_Closest_Two_For_Four_People() {
		List<Person> list = new ArrayList<Person>();
		list.add(sue);
		list.add(sarah);
		list.add(mike);
		list.add(greg);

		Finder finder = new Finder(list);

		Optional<Pair> pair = finder.Find(SortBy.Closer);

		Pair expectedPair = Pair.fromUnordered(sue, greg);
		assertTrue(pair.isPresent());
		assertEquals(expectedPair, pair.get());
	}

}
