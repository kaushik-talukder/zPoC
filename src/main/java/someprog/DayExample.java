package someprog;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DayExample {

	public static String getDayOfCurrentDate() {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("EEE");
		return sdf.format(date);
	}

	public static void main(String[] args) {
		System.out.println(getDayOfCurrentDate());
	}
}
