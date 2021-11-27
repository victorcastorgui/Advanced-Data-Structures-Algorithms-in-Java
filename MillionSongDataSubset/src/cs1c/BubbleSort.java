package cs1c;
/**
 * Performs a basic sorting algorithm of a generic array of objects.
 * @author CS1C, Foothill College, Bita Mazloom
 * @version 1.0
 */
public class BubbleSort {	

	// generic method for sorting an array of elements
	public 	// method visibility
	static <E extends Comparable<? super E>>  // defining the generic type E
	void 	// return type
	sortArray(E [] unsorted)
	{
		for (int i = unsorted.length - 1; i >= 0; i--) 
		{
	        for (int j = 1; j <= i; j++) {
	            if (unsorted[j-1].compareTo(unsorted[j]) > 0) 
	            {
	                E current = unsorted[j-1];
	                unsorted[j-1] = unsorted[j];
	                unsorted[j] = current;
	            }
	        }
	    }
	}
}
