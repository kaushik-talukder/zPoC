package poc.lambdaExpSession.apple;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Apple {
	private String color;
	private int weight;
}
