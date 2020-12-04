package com.collection;

import java.util.*;

public class HashTag {

	public static List<String> getHashTag(String line) {
		String parsedStr = line.replaceAll("[^a-zA-Z ]", ""); //To remove punctuation
		List<String> out = new LinkedList<>();
		LinkedHashMap<String, Integer> hm = new LinkedHashMap<String, Integer>();

		for (String word : parsedStr.split(" ")) {
			hm.put(word, word.length());
		}

		hm.entrySet().stream()
		.sorted(Map.Entry.<String,Integer>comparingByValue(Comparator.reverseOrder()))
		.forEach(e -> {
					out.add("\"#" + e.getKey().toLowerCase() + "\"");
				});
		List<String> result = out.size() >= 3 ? out.subList(0, 3) : out.subList(0, out.size()); //selecting first 3 longest word
		//System.out.print(result);
		return result;
	}

	public static void main(String[] args) {
		getHashTag("How the Avocado Became the Fruit of the Global Trade");
		// getHashTag("why you will probably pay more for your christmas tree this
		// year");
		// getHashTag("Hey parents, surprise, fruit juice is not fruit");
		// getHashTag("visualizing science");
	}
}