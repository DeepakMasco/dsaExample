package slidingWindow.fixed;

public class MinSwaps {

    public static void main(String[] args) {
        int[] input = new int[]{1,0,1,0};
        System.out.println(findMinSwaps(input));
    }
//    0 1 0 1 0 1 1 1 1 1 0
    private static int findMinSwaps(int[] input) {
        int i = 0;
        int j = 0;
        int n = input.length;
        int max = 0;
        int current = 0;
        int windowSize = 0;

        for(int m: input) {
            windowSize+=m;
        }

        while(j<n) {
            current+= input[j];
            if((j-i+1)==windowSize) {
                max = Math.max(current,max);
                if(input[i]==1) {
                    current--;
                }
                i++;
            }

            j++;

        }

        return windowSize-max;
    }


}
