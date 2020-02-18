package com.example.poc.string;

import java.util.Objects;

import org.apache.commons.lang.StringUtils;

public class RemoveZeros {
	public static String removeLeadingZeros(String str){
		return Objects.nonNull(str)?StringUtils.stripStart(str,"0"):"";
	}
	public static void main(String[] args) {
		System.out.println(removeLeadingZeros("00"));
	}
}
