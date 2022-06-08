package leetcode.recursion;

import java.util.Arrays;

public class SortArray {

    public static void main(String[] args) {
        int[] input = new int[]{1 ,5 ,0 ,10 ,21 ,92 ,16 ,30};
        sortArray(input);
        Arrays.stream(input).boxed().forEach(System.out::println);
    }

    private static void sortArray(int[] input) {
    }
}
