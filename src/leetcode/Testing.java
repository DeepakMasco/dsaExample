package leetcode;

import java.util.*;

public class Testing {

    public static void main(String[] args) {
       List<List<Integer>> result = threeSum(new int[] {-1,0,1,2,-1,-4});
       result.forEach(System.out::println);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<>();

            for(int i=0;i<nums.length;i++) {
                int sum = - nums[i];
                Map<Integer, Integer> map = new HashMap<>();
                for(int j=i+1;j<nums.length;j++) {
                    if (i!=j) {
                        int remaining = sum - nums[j];
                        if(map.containsKey(remaining)) {
                            List<Integer> pair = new ArrayList<>();
                            pair.add(nums[i]);
                            pair.add(nums[j]);
                            pair.add(remaining);
                            result.add(pair);
                        } else {
                            map.put(nums[j],j);
                        }
                    }
                }
            }

            return result;
        }

}
