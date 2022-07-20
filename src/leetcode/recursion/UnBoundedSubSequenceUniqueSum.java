package leetcode.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//https://leetcode.com/problems/combination-sum-ii/
public class UnBoundedSubSequenceUniqueSum {


    public static void main(String[] args) {
        int[] input = new int[]{10,1,2,7,6,1,5};
        System.out.println(combinationSum2(input,8));
        System.out.println(combinationSum21(input,8));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        findingCombination(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }


    public static void findingCombination(int index, int []arr, int target,        List<List<Integer>> ans, List<Integer> list){
        if(index == arr.length){
            if(target == 0){
                ans.add(new ArrayList<> (list));
            }
            return;
        }

        if (arr[index] <= target){
            list.add(arr[index]);
            findingCombination(index+1, arr, target - arr[index], ans, list);
            list.remove(list.size() - 1);
        }

        while(index+1<arr.length && arr[index]==arr[index+1]){
            index++;
        }
        findingCombination(index + 1, arr, target, ans, list);
    }






    //Another short way
    public static List<List<Integer>> combinationSum21(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        findingCombination(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }


    public static void findingCombination1(int index, int []arr, int target,        List<List<Integer>> ans, List<Integer> list){

        if(target == 0){
            ans.add(new ArrayList<> (list));
            return;
        }


        for(int i=index;i<arr.length;i++) {
            if(i>index && arr[i]==arr[i-1]) continue;

            if(arr[i]>target) break;


            list.add(arr[i]);
            findingCombination(i+1, arr, target - arr[i], ans, list);
            list.remove(list.size() - 1);


        }
    }
}
