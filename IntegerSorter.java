import java.util.ArrayList;

public class IntegerSorter {
	ArrayList<Integer> myList = new ArrayList<Integer>();
	public void read(ArrayList<Integer> arr) {
		if (arr.size() == 0) {
			System.out.println("Sorry but you must have at least one value stored in the array list in order to print.");
			return;
		}
		partition(arr, 0, arr.size());
		for (int i = arr.size(); i >= 0; i--) {
			System.out.println(arr.get(i));
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
