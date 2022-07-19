package leetcode.binarySearch;

public class ShipWeights {

    public static void main(String[] args) {
        System.out.println(shipWithinDays(new int[]{7,18,15,15,8,3,19,8,14,4,5,14,19,10,1,1,2},2));
    }

    public static int shipWithinDays(int[] weights, int days) {
        // find the mimimum capacity and the maximum capacity
        // the minimum should be the max weight present as even if we ship 1 weight in 1 day. Then we need the max weight
        // to be handled by ship., the maximum should be the weight sum
        int low = Integer.MIN_VALUE, high = 0;
        for(int weight : weights){
            low = Math.max(low, weight);
            high += weight;
        }

        // use the binary search to check the least valid capacity
        while(low <= high){
            int middle = low + (high - low) / 2;

            if(finish(weights, middle, days)){ // if current capacity could finish, we check the lower one
                high = middle - 1;
            }
            else{
                low = middle + 1; // if not, we check the higher one
            }
        }

        return high + 1;
    }

    public static boolean finish(int[] weights, int capacity, int days){
        int sum = 0;
        for(int weight : weights){
            // if current sum is smaller than capacity, we try more
            if(sum + weight <= capacity){
                sum += weight;
            }
            // if we can't add load current weight item
            else{
                if(sum > capacity){ // if the current sum is invalid already, returnf alse
                    return false;
                }
                // otherwise, we load current and reset sum
                days --;
                sum = weight;
            }
        }

        // if sum remain, check it
        if(sum > 0){
            if(sum > capacity){
                return false;
            }
            days--;
        }

        // if we have days at least as 0, we finish our job
        return days >= 0;
    }
}
