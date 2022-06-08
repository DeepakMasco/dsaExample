package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Testing {

    public static void main(String[] args) {
        int[] T = new int[] {0,3,0,0,5,0,5};
        int[] A = new int[] {4,2,6,1,0};
        int result = 0;
        Set<Integer> set = new HashSet<>();
        for(int skill: A) {
            result+= countSkill(T, skill, set);
            set.add(skill);
        }
       System.out.println(result);
    }


    // write your code in Java SE 8


    public static int countSkill(int[] T, int skill, Set<Integer> set) {
        if(set.contains(T[skill])) {
            return 1;
        }
        set.add(T[skill]);
        return countSkill(T, T[skill], set)+1;
    }
}
