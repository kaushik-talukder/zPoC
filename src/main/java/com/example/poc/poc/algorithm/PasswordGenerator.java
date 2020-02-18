package com.example.poc.poc.algorithm;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Class that generates the Password of the day for Offline Staff Login.
 */
public class PasswordGenerator {

	private static final int PWOD_CHAR_LIMIT = 4;

	public PasswordGenerator() {
	}

	/**
	 * Gets the Password of the day
	 *
	 * @return - 4-digit alpha-numerical password of the day
	 */
	public String getPasscode() {

		String formattedDate = getTodaysDate();
		String keyword = getKeywordOfTheDay();

		return generatePasscode(formattedDate, keyword);
	}

	/**
	 * Returns todays date in MM/dd format
	 * 
	 * @return formatted date in String
	 */
	private String getTodaysDate() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd");
		return dateFormat.format(calendar.getTime());
	}

	/**
	 * Returns the keyword based on the day of the week
	 *
	 * @return - keyowrd of the day in Uppercase String
	 */
	private String getKeywordOfTheDay() {
		Calendar calendar = Calendar.getInstance();
		int day = calendar.get(Calendar.DAY_OF_WEEK);
		String[] keyword = { "negative", "zygote", "semblance", "quirk", "exhale", "fallowed", "jalapeno" };
		return keyword[day].toUpperCase();
	}

	/**
	 * Gets the character provided the position in a String. if the length of the
	 * string is lesser than the position then the count is reset from the start of
	 * the string.
	 *
	 * @param s
	 * @param pos
	 * @return - character at position in a given String
	 */
	private Character getCharAtPos(String s, int pos) {
		if (s.length() <= pos) {
			return s.charAt(pos % s.length());
		} else {
			return s.charAt(pos);
		}
	}

	/**
	 * Constructs the passcode for a given date and keyword.
	 *
	 * @param formattedDate - Date in String format(MM/dd)
	 * @param keyword       - keyword in String
	 * @return - 4 digit alpha numerical passcode
	 */
	private String generatePasscode(String formattedDate, String keyword) {

		// String Builder to build the 4 digit Passode
		StringBuilder pwod = new StringBuilder(PWOD_CHAR_LIMIT);
		StringBuilder key = new StringBuilder(keyword);

		// splitting the formatted string into date and month
		String s[] = formattedDate.split("/");
		String date = s[0];
		String month = s[1];
		String dateMonth = date + month;

		// getting the last 4 digit of binary product from date and month
		// to determine the digit of the passcode - alphabet or numerical
		String last4BinaryDigits = getBinaryProduct(new int[] { Integer.parseInt(date), Integer.parseInt(month) });

		// construction of the passcode
		for (int i = 0; i < PWOD_CHAR_LIMIT; i++) {
			char binaryDigit = last4BinaryDigits.charAt(i);

			// position determined from the i'th digit in date+month string
			int position = Character.getNumericValue(getCharAtPos(dateMonth, i));

			// character obtained from keyword at position
			char character = getCharAtPos(key.toString(), position);

			// if the binary digit at given position
			// 0 : append the last digit of ascii of character
			// 1 : append the character
			if (binaryDigit == '0') {
				pwod.append((int) character % 10);
			} else {
				pwod.append(character);
			}

			// once a character or its ascii value is counted for passcode
			// remove the character from the key
			if (key.length() <= position) {
				key.deleteCharAt(position % key.length());
			} else {
				key.deleteCharAt(position);
			}
		}

		return pwod.toString();
	}

	/**
	 * Gets the Binary Product with provided 2 integers.
	 *
	 * @param num - 2 positive integers in array
	 * @return - Binary Product in String
	 */
	private String getBinaryProduct(int[] num) {
		String binaryProduct = null;
		String defaultBinaryProduct = "1010";

		if (num.length == 2) {
			int prod = num[0] * num[1];
			binaryProduct = Integer.toBinaryString(prod);

			// adds leading zeroes
			binaryProduct = "0000" + binaryProduct;
			binaryProduct = binaryProduct.substring(binaryProduct.length() - 4);

		} else {
			binaryProduct = defaultBinaryProduct;
		}
		return binaryProduct;
	}

	public static void main(String[] args) {
		PasswordGenerator pg = new PasswordGenerator();
		System.out.println(pg.getPasscode());
	}

}
