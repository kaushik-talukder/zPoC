package com.learncs.zpoc.anagram;

import java.util.HashMap;
import java.util.Map;

public class AnagramEx {

	boolean checkAnagram(String a, String b) {
		Map<Character, Integer> s1 = new HashMap<>();
        Map<Character, Integer> s2 = new HashMap<>();

        for(int i=0; i< a.length(); i++){
            if(s1.containsKey(a.charAt(i))){
                s1.put(a.charAt(i), s1.get(a.charAt(i))+1);
            }else {
                s1.put(a.charAt(i), 0);
            }
        }

        for(int i=0; i< b.length(); i++){
            if(s2.containsKey(b.charAt(i))){
                s2.put(b.charAt(i), s2.get(b.charAt(i))+1);
            }else {
                s2.put(b.charAt(i), 0);
            }
        }

        return s1.equals(s2);
	}

	public static void main(String[] args) {
		AnagramEx obj = new AnagramEx();
		System.out.println(obj.checkAnagram("forr", "fror"));
	}
}