package com.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MergeSorter implements Callable<List<Integer>> {

	private List<Integer> arrayTosort;
	private final ExecutorService executorService;
	
		public MergeSorter(List<Integer> arrayTosort, ExecutorService executorService) {
		super();
		this.arrayTosort = arrayTosort;
		this.executorService = executorService;
	}



	@Override
	public List<Integer> call() throws Exception {
		System.out.println("Unsorted Array in call() "+arrayTosort);
		if (arrayTosort.size() <= 1) {
			return arrayTosort;
		}

		int mid = arrayTosort.size() / 2;
		List<Integer> left = arrayTosort.subList(0, mid);

		List<Integer> right = arrayTosort.subList(mid, arrayTosort.size());

		MergeSorter leftSorter = new MergeSorter(left,executorService);
		MergeSorter rightSorter = new MergeSorter(right,executorService);

		ExecutorService executor = Executors.newFixedThreadPool(2);
		Future<List<Integer>> fls = executor.submit(leftSorter);
		Future<List<Integer>> frs = executor.submit(rightSorter);

		List<Integer> ls = fls.get();
		List<Integer> rs = frs.get();

		List<Integer> mergedArray = new ArrayList<>();
		int i = 0, j = 0;

		while (i < ls.size() && j < rs.size()) {
			if (ls.get(i) <= rs.get(j)) {
				mergedArray.add(ls.get(i));
				System.out.println("IF Left side "+ls.get(i) +"And right side "+ rs.get(j));
				i++;
			} else {
				mergedArray.add(rs.get(j));
				System.out.println("ELSE Left side "+ls.get(i) +"And right side "+ rs.get(j));
				j++;
			}
		}
		
		while(i<ls.size()) {
			mergedArray.add(ls.get(i));
			System.out.println("DOWN Left side "+ls.get(i));
			i++;
		}
		
		while(j<rs.size()) {
			mergedArray.add(rs.get(j));
			System.out.println("DOWN righT side "+ rs.get(j));
			j++;
		}

		return mergedArray;
	}

}
