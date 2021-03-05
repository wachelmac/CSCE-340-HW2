//Rachel McMullan
//George O'Malley
//Group 7

import java.util.ArrayList;
import java.util.Collections;
import java.io.*;

public class IntegerSorter {

	ArrayList<Integer> myList = new ArrayList<Integer>();

	IntegerSorter(ArrayList<Integer> arr) throws IOException{

		myList=arr;
		sort();
		Collections.sort(myList, Collections.reverseOrder());
	} 

	public void sort() throws IOException{

		PrintWriter output=new PrintWriter("integers.txt");

		if (myList.size() == 0)
			System.out.println("There are no values to print.");

		else{
			partition(myList, 0, myList.size()-1);
			Collections.sort(myList);
			for (int i = myList.size()-1; i >= 0; i--) {
				output.println(myList.get(i));

			}
			output.close();
		}
	} 
	private int partition(ArrayList<Integer> arr, int lo, int hi) {
		int i = lo, j = hi+1;

		while (true) {
			// find item on the left to swap
			while (less(arr.get(++i), arr.get(0))) if (i == hi) break;

			// find item on the right to swap
			while (less(arr.get(lo), arr.get(--j))) if (j == lo) break;

			// check if pointers cross, then swap
			if (i >= j) break;
			exchange(arr, i, j);
		}

		exchange(arr, lo, j); // swap with the partitioning item
		return j; // return index of the item now known to be in place
	}

	static boolean less(Integer integer, Integer w) {
		return integer.compareTo(w) < 0;
	}

	static void exchange(ArrayList<Integer> a, int i, int j) {
		Integer t = a.get(i);
		a.set(i, a.get(j));
		a.set(j, t);
	}

}