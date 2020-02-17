package javaprog.hashandequal;

import lombok.Data;

public class HashAndEqual {
	public static void main(String[] args) {
		Student s1 = new Student(1, "SA");
		Student s2 = new Student(1, "SA");
		System.out.println(s1.hashCode());
		System.out.println(s2.toString());
	}
}

@Data
class Student {
	private int id;
	private String name;

	public Student(int id, String name) {
		this.id = id;
		this.name = name;
	}
}