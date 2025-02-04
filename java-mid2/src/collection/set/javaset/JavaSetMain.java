package collection.set.javaset;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class JavaSetMain {

	public static void main(String[] args) {

		run(new HashSet<String>());
		run(new LinkedHashSet<String>());
		run(new TreeSet<String>());
	}

	private static void run(Set<String> set) {
		System.out.println("set = " + set.getClass());

		set.add("C");
		set.add("B");
		set.add("A");
		set.add("1");
		set.add("2");

		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println();
	}
}
