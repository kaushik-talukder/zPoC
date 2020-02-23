package com.learncs.zpoc.poc.algorithm;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class PassDay {

	private static Map<String, String> dayScretMap = new HashMap<>();

	static {
		dayScretMap.put("SUN", "ISOTOPE");
		dayScretMap.put("MON", "PROTOND");
		dayScretMap.put("TUE", "NEUTRON");
		dayScretMap.put("WED", "KAUSHIK");
		dayScretMap.put("THU", "TALUKDE");
		dayScretMap.put("FRI", "PASSDAY");
		dayScretMap.put("SAT", "JAVACLA");
	}

	private static String generatePasswordOfTheday(final String dayMonth, final String daySecretKey) {
		StringBuilder daySecret = new StringBuilder(daySecretKey);
		StringBuffer passOfTheDay = new StringBuffer();
		String day = dayMonth.substring(0, dayMonth.length() / 2);
		String month = dayMonth.substring((dayMonth.length() / 2));
		String binMul = "0000" + Integer.toBinaryString(Integer.valueOf(day) * Integer.valueOf(month));
		String binKey = binMul.substring(binMul.length() - 4);

		for (int i = 0; i < dayMonth.length(); i++) {
			int charOfInterest = Integer.valueOf(String.valueOf(dayMonth.charAt(i))) % daySecret.length();
			if (binKey.charAt(i) == '0') {
				char charIn = daySecret.charAt(charOfInterest);
				String charBin = Integer.toBinaryString(charIn);
				String lastCharBin = charBin.substring(charBin.length() - 1);
				passOfTheDay.append(lastCharBin);
			} else {
				char charIn = daySecret.charAt(charOfInterest);
				passOfTheDay.append(charIn);
			}
			daySecret.deleteCharAt(charOfInterest);
		}

		return passOfTheDay.toString();
	}

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("MMdd");
		SimpleDateFormat dayFormat = new SimpleDateFormat("EEE");
		System.out.println(generatePasswordOfTheday(sdf.format(new Date()),
				dayScretMap.get(dayFormat.format(new Date()).toUpperCase())));
	}
}
