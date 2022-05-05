package slidingWindow;

import java.util.ArrayList;
import java.util.List;

public class SubArrayMaxNumber {

    public static void main(String[] args) {

        int[] arr = new int[] {-10,20,-30,-4,5,6,8};
        int k = 3;
        int size = arr.length;

        int i=0;
        int j=0;

        List<Integer> maxNumbers = new ArrayList<>();

        while(j<size) {
            if (maxNumbers.isEmpty()) {
                maxNumbers.add(arr[j]);
            }
            else if(arr[j]>maxNumbers.get(0)) {
               maxNumbers.remove(0);
               maxNumbers.add(arr[j]);
            }

            if(j-i+1 == k) {
                System.out.println(maxNumbers.get(0));
                if(maxNumbers.get(0)==arr[i]) {
                    maxNumbers.remove(0);
                }
                i++;
            }

            j++;
        }
    }
}
