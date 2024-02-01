package com.interviewPrep.leetcode.easy.twosum;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

   You may assume that each input would have exactly one solution, and you may not use the same element twice.

   You can return the answer in any order.
 *
 */
public class TwoSumSecondApproach {

	public static void main(String[] args) {
		
		int[] nums =  {3,3,4};
		int target = 6;
		
		
		TwoSumSecondApproach ts = new TwoSumSecondApproach();
		
		int[] sol = ts.twoSumSecondApproach(nums, target);
		
		
		System.out.println("indices are: " + sol[0] + ", " + sol[1]);
	}
	
	 
	 public int[] twoSumSecondApproach(int[] nums, int target) {

		 int[] sol = new int[2];
		 
		 // create new Hashset
		 Map<Integer, HashSet> numsMap = new HashMap<Integer, HashSet>();
		 
		 /*
		  * Iterate over the input array and populate the HashMap with key as integer and value as its respective indices it occurred in the input array.
		  * eg: 3 occurs at indices 0 and 1 in the input array, so HashMap should have entry as [3, (0,1)] 
		  */
		 for(int i=0; i< nums.length; i++) {

			 Set<Integer> indexSet = new HashSet<>();
			 indexSet.add(i);
			
			 
			 if(numsMap.containsKey(nums[i])) {
				 
				 Set idxSet =  numsMap.get(nums[i]);
				 idxSet.add(i);
				 numsMap.put( nums[i],  (HashSet) idxSet);
				 
			 }
			 else {
				 numsMap.put( nums[i],  (HashSet) indexSet);
			 }

		 } // end for
		 
		 /*
		  * Now iterate the input array again. For every integer check if its complement i.e. difference from target is present in the map.
		  * If its present then return their respective indices
		  */
		 for(int i=0; i< nums.length-1; i++) {
			 
			 int rem = target - nums[i];
			 if(numsMap.containsKey(rem)) {
				 
				 if(nums[i+1] ==  rem && numsMap.get(rem).size()>1) {
					 
					 System.out.println(nums[i+1] + " " + rem);
					sol[0] = (int) numsMap.get(rem).toArray()[0];
					sol[1] = (int) numsMap.get(rem).toArray()[1];
					
				 }
				 else if(nums[i] !=  rem ) {
					 
					 sol[0] = i;
					 sol[1] =  (int) numsMap.get(rem).toArray()[0];
					 
				 }
				 
			 }
			 
		 }
		 
		 return sol;

	 } // end	 
	
}
