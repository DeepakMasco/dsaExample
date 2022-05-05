package slidingWindow;

import java.util.ArrayList;
import java.util.List;

public class FirstNegativeIntegerInArray {

    //We will return 0 if there is no negative integer in the sub array
    public static void main(String[] args) {
        int[] arr = new int[] {-10,20,-30,-4,5,6,8};
        int k = 3;
        int size = arr.length;

        int i=0;
        int j=0;

        List<Integer> negativeNumbers = new ArrayList<>();


        while(j<size) {
            if (arr[j]<0) {
                negativeNumbers.add(arr[j]);
            }
            if(j-i+1 == k) {
                if(negativeNumbers.size()>0) {
                    System.out.println(negativeNumbers.get(0));
                    if (arr[i]==negativeNumbers.get(0)) {
                        negativeNumbers.remove(0);
                    }
                } else {
                    System.out.println(0);
                }
                i++;
            }
            j++;
        }
    }
}
