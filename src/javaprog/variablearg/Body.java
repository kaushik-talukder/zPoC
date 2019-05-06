package javaprog.variablearg;

public class Body {
	public static void display(int num, String... chs) {
		System.out.println(chs.length);
	}
	
	public static void main(String[] args) {
		display(12,"qw","a","fgfd");
	}
}
