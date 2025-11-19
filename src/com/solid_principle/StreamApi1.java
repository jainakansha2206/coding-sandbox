package com.solid_principle;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApi1 {

	public static void main(String[] args) {
		
		List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana");
		System.out.println(words.stream().collect(Collectors.groupingBy(w->w , Collectors.counting())));
		
		/*
		 * “Funny Monkeys Dance Slowly, Laughing Silly People”
		 * 
		 * F → Filter
		 * 
		 * M → Map
		 * 
		 * D → Distinct
		 * 
		 * S → Sorted
		 * 
		 * L → Limit
		 * 
		 * S → Skip
		 * 
		 * P → Peek
		 */
		
		
	}
}
