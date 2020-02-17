package lambdaExpSession.lambda;

@FunctionalInterface
public interface FilterPredicate<T> {
	boolean test(T t);
}
