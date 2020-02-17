package gfg;

/*
Given two arrays of N and M integers. 
The task is to find the number of unordered pairs formed of elements from both arrays 
in such a way that their sum is an odd number.
Note: An element can only be one pair.
*/
public class SumOddNum {

	private int countOddSum(int[] n, int[] m) {
		int oddSumCount = 0;
		int odd1Ct = 0, even1Ct = 0, odd2Ct = 0, even2Ct = 0;

		for (int num : n) {
			if (num % 2 == 0) {
				even1Ct++;
			} else {
				odd1Ct++;
			}
		}

		for (int num : m) {
			if (num % 2 == 0) {
				even2Ct++;
			} else {
				odd2Ct++;
			}
		}

		oddSumCount = Math.min(even1Ct, odd2Ct) + Math.min(even2Ct, odd1Ct);

		return oddSumCount;
	}

	public static void main(String[] args) {
		SumOddNum obj = new SumOddNum();
		int[] n = new int[] { 2, 2, 4 };
		int[] m = new int[] { 2, 3, 4 };
		System.out.println(obj.countOddSum(n, m));
	}
}
