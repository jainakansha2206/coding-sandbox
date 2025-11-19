package com.multithreading;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MergeShortWithCollable {

	public static void main(String[] args) throws  ExecutionException, InterruptedException {

		List<Integer> array = List.of(38, 27, 39, 12, 56, 76, 2, 4);
		System.out.println("Unsorted Array "+array);
			
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		MergeSorter sorter = new MergeSorter(array , executorService);
		
		Future<List<Integer>> sortedFutureArray = executorService.submit(sorter);
		
		List<Integer> sortedArray = sortedFutureArray.get();
		
		System.out.println("Sorted Array :- ");
		printArr(sortedArray);
	}
	
	public static void printArr(List<Integer> arr) {
		for(int num : arr) {
			System.out.println(num+ " "+Thread.currentThread().getName());
		}
	}

}
