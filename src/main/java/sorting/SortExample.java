package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortExample {
	public static void main(String[] args) {
		List<Student> studList = new ArrayList<>();
		Student s1 = new Student(1, "Kaushik");
		Student s2 = new Student(2, "Joyantee");
		studList.add(s1);
		studList.add(s2);
		
		Comparator<Student> comp = Comparator.comparing(Student::getId).reversed().thenComparing(Student::getName);
		
		Collections.sort(studList, comp);
		
		studList.stream().forEach(s -> System.out.println(s));
	}
}
