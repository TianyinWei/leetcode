/*
Design and implement a TwoSum class. It should support the following operations: add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.

For example,
add(1); add(3); add(5);
find(4) -> true
find(7) -> false
*/

public class TwoSum {
    List<Integer> nums = new ArrayList<Integer>();
    // Add the number to an internal data structure.
	public void add(int number) {
        nums.add(number);
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    if (nums.size() == 0)   return false;
	    HashSet<Integer> set = new HashSet<Integer>();
	    for (int oneNum : nums) {
	        if (!set.contains(oneNum))   set.add(value-oneNum);
	        else return true;
	    }
	    return false;
	}
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);
