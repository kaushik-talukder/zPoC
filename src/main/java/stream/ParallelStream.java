package stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.Data;

@Data
class Product {
	int id;
	String name;
	float price;

	public Product(int id, String name, float price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return id+":"+name+":"+price;
	}
}

public class ParallelStream {
	public static void main(String[] args) {
		
		/*List<Integer> l = Factory.getIntegerList(100); 
		Stream<Integer> a = l.parallelStream(); a.forEach(i -> System.out.println(LocalTime.now() + " - value: " + i + " - thread: " + Thread.currentThread().getName()));*/

		List<Product> productsList = new ArrayList<Product>();

		// Adding Products
		productsList.add(new Product(1, "HP", 25000f));
		productsList.add(new Product(2, "Dell", 30000f));
		productsList.add(new Product(3, "Lenevo", 28000f));
		productsList.add(new Product(4, "Sony", 28000f));
		productsList.add(new Product(5, "Apple", 90000f));
		
		//Product p = productsList.stream().max((p1, p2) -> p1.price > p2.price ? 1 : -1).get();
		Map<String, Integer> productPriceMap = productsList.stream().collect(Collectors.toMap(p->p.name, p->p.id));
		
		//System.out.println(p);
		
		System.out.println(productPriceMap);
		
		Comparator<Product> comp = Comparator.comparing(Product::getName).reversed();
		
		productsList = productsList.stream().sorted(comp).collect(Collectors.toList());
		
		Iterator<Product> it = productsList.iterator();
		while(it.hasNext()) {
			Product p = it.next();
			switch (p.getName()) {
			case "HP":
				System.out.println("I am inside case HP");
				break;
	
			default:
				System.out.println("I am at default");
				break;
			}
		}

	}
}