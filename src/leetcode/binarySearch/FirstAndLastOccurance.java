package leetcode.binarySearch;

public class FirstAndLastOccurance {

    public static void main(String[] args) {

        int [] ans = searchRange(new int[] {5,7,7,8,8,8,8,8,9,10}, 8);
        System.out.println(ans[0]);
        System.out.println(ans[1]);

        System.out.println("Count Of Elements Presenet " + (ans[1]-ans[0]+1));


    }

    public static int[] searchRange(int[] nums, int target) {
        int first = bsFirst(nums,target);
        int second = bsLast(nums,target);
        return new int[]{first,second};
    }


    public static int bsFirst(int[] nums, int target) {
        int result = -1;
        int low = 0;
        int high = nums.length-1;

        while(low<=high) {
            int mid = low + (high-low)/2;

            if(nums[mid]==target) {
                result = mid;
                high = mid -1;
            }
            else if(nums[mid]>target) {
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }

        return result;
    }

    public static int bsLast(int[] nums, int target) {
        int result = -1;
        int low = 0;
        int high = nums.length-1;

        while(low<=high) {
            int mid = low + (high-low)/2;

            if(nums[mid]==target) {
                result = mid;
                low = mid + 1;
            }
            else if(nums[mid]>target) {
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }

        return result;
    }
}
