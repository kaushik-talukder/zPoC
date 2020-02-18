package com.example.poc.enumconcept;

public enum Day {
	SUNDAY("SUN", "Sunday"), MONDAY("MON", "Monday");

	private final String key;
	private final String value;

	private Day(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return this.key;
	}

	public String getValue() {
		return this.value;
	}
}
