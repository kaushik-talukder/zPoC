package javaprog.iconcept;

public abstract interface Shape {
	Double PI = 3.1415;

	abstract Double area();

	default Double area(String shape) {
		return 0.0;
	}
}
