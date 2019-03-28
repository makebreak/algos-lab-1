// You have a heist getaway sack with a capacity, and n items in front of you
// with sizes and worths. Figure out the maximum value you could
// get with the items.

// You are encouraged to make helper functions!


public class Robbery {

	// Using DP: Get the maximum value with capacity C and n items
	public int maximizeRobWorthRecur(
		int capacity,
		int[] sizes,
		int[] worths
	) {
	    int totes = 0; 
	    // base case no items
	    if (sizes.length == 0)
		return 0;

	    // base case one item - exceeds capacity
	    if (sizes.length == 1 && sizes[0] > capacity)
		return 0;
	    
	    // base case one item - meets capacity
	    if (sizes.length == 1 && sizes[0] <= capacity)
		return worths[0];
	    
	    // return max of either optimal worth including nth item or excluding it
	    return maxVal(capacity, sizes, worths, sizes.length-1);
	}

    public int maxVal(int capacity,int sizes[], int worths[], int n) {
	// takes array and searches the first n entries
	// returns highest value combination within capacity, given sizes

	if (n < 0) return 0;
	if (n == 0) return worths[n];
	return Math.max(maxVal(capacity, sizes, worths, n-1),
			maxVal(capacity, sizes, worths, n-1) + worths[n]);
	// if 3 items, at n=2 return maxVal at n=1, of 2 items
	// then, with 2 items, at n=1 return maxVal at n=0, of 1 item
	// then, with 1 item, at n=0, return "worth" value of that item 
	// back to 2 items, we calculate the max between two values,
	//   worth of first item only or of worth of first item + worth of current
	// back to 3 items, we calculate max between two values,
	//   worth of first 2 items only or of worth of first 2 items + worth of current  
    }

    
    // Need to save data in a table 
    public int maximizeRobWorthBottomUp (
		int capacity,
		int[] sizes,
		int[] worths
	) {
		// fill in here, change the return
		return 0;
	}

/**
* Bonus: figure out which items exactly
* Takes in a DP DPTable
* Returns an int array of the individual worths of the items you took
*/
	public int[] takeRobInventory(int[][] DPTable) {
		// fill in here, change the return
		return new int[DPTable.length];
	}

	public static void main(String[] args) {
		Robbery r = new Robbery();
		int bagCapacity = 40;
		int[] itemSizes = {2, 25, 6, 13, 1, 15, 8, 5, 17, 4};
		int[] itemWorths = {35, 120, 900, 344, 29, 64, 67, 95, 33, 10};

		int maxWorthRecur = r.maximizeRobWorthRecur(bagCapacity, itemSizes, itemWorths);
		System.out.println("Max worth of the bag: " + maxWorthRecur);
		int maxWorthBottomUp = r.maximizeRobWorthBottomUp(bagCapacity, itemSizes, itemWorths);
		System.out.println("Max worth of the bag: " + maxWorthBottomUp);

		// Bonus: Fill in the helper method takeRobInventory that could help you
		//figure out which items go into the bag that make it max worth. Feel free
		//to change up the parameters and returned types + values of the helper
		// methods above.
		// int[] itemsPicked = r.takeRobInventory();
		// System.out.println("The items we take are worth:")
		// for (int i = 0; i < results.length; i++) {
		// 	System.out.print(results[i] + " ");
	}
}
