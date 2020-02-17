package string;

import java.util.StringJoiner;

public class StrJoiner {
	public static void main(String[] args) {
		StringJoiner joinNames1 = new StringJoiner(",","@","#");   
		StringJoiner joinNames2 = new StringJoiner(",", "[", "]");   // passing comma(,) and square-brackets as delimiter   
		// Adding values to StringJoiner  
        joinNames1.add("Rahul");  
        joinNames1.add("Raju");  
        joinNames2.add("Peter");  
        joinNames2.add("Raheem");  
                  
        System.out.println(joinNames1);
        System.out.println(joinNames2);
        System.out.println(joinNames2.merge(joinNames1));  
	}
}
