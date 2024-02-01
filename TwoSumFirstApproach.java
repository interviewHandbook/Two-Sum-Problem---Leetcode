package com.interviewPrep.leetcode.easy.twosum;

/**
 * 
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

   You may assume that each input would have exactly one solution, and you may not use the same element twice.

    You can return the answer in any order.
 *
 */
public class TwoSumFirstApproach {

	public static void main(String[] args) {
		
		int[] nums =  {3,3,4};
		int target = 6;
		
		
		TwoSumFirstApproach ts = new TwoSumFirstApproach();
		int[] sol = ts.twoSumFirstApproach(nums, target);
		
		System.out.println("indices are: " + sol[0] + ", " + sol[1]);
	}
	
	 public int[] twoSumFirstApproach(int[] nums, int target) {
	        
		 	int[] sol = new int[2];
		 	for(int i=0; i< nums.length; i++) {
		 		
		 		int first = nums[i];
		 		for(int j=i+1; j<nums.length; j++) {
		 			
		 			int second = nums[j];
		 			if(first + second == target) {
		 				
		 				sol[0] = i;
		 				sol[1] = j; 
		 				
		 				 
		 				return sol;
		 				
		 			} // end if
		 			
		 		}// end for
		 		
		 	}//end for
		 	
		 	
		 	return sol;
	    }
	 	
}
