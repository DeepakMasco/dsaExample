package slidingWindow;

import java.util.ArrayList;
import java.util.List;

public class FirstNegativeIntegerInArray {

    public static void main(String[] args) {
        int[] arr = new int[] {-10,20,-30,-4,5,6};
        int k = 3;
        int size = arr.length;

        int i=0;
        int j=0;

        List<Integer> negativeNumbers = new ArrayList<>();


        while(j<size) {
            if(j-i+1 == k) {
                //calc
                i++;
            }
            j++;
        }

        negativeNumbers.forEach(System.out::println);

    }
}
