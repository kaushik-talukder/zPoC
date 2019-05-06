package javaprog.classconcept;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Point extends PointAbs {
	protected final static Point origin = new Point(0, 0);

	Point(int x, int y) {
		super(x, y);
	}
}
