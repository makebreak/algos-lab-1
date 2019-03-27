// You have a heist getaway sack with a capacity, and n items in front of you
// with sizes and worths. Figure out the maximum value you could
// get with the items.

// You are encouraged to make helper functions!
import Math.*;

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
	    if (sizes.length == 1 && size[0] > capacity)
		return 0;
	    
	    // base case one item - meets capacity
	    if (sizes.length == 1 && size[0] <= capacity)
		return worth[0];
	    
	    // return max of either optimal worth including nth item or excluding it
	    return Math.max(maxVal(capacity, sizes, worths, sizes.length-1),
				     maxVal(capacity, sizes, worths, sizes.length-1) + worths[sizes.length]);
	}

    public int maxVal(int capacity,int sizes[], int worths[], int n) {
	// takes array and searches the first n entries
	// returns highest value combination within capacity, given sizes

	if (n == 0) return 0;
	if (n == 1) return worths[n];
	return Math.max(maxVal(capacity, sizes, worths, n-1),
			maxVal(capacity, sizes, worths, n-1) + worths[n]);
	
    }

    
    // Need to save data in a table 
	public int maximizeRobWorthBottomUp
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
