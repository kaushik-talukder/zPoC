package javaprog.iconcept;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class Square extends Rectangle {

	private int length;

	@Override
	public Double area() {
		return Math.pow(this.length, 2);
	}

	Square(int length) {
		System.out.println("Square Constructor");
		this.length = length;
	}
}
