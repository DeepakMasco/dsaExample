package leetcode.binarySearch;


// The below solution can be used in the bitonic array also. It means first array is strictly increasing and then decreasing.
// So now there will be only 1 peak element in the array.
public class FindPeakElement {

    public static void main(String[] args) {
        int ans = findPeakElement(new int[] {1,2,4,5,3,70,6});
        System.out.println(ans);
    }

    public static int findPeakElement(int[] nums) {
        int n = nums.length;
        //checking for base case.
        if(nums.length==1)
        {
            return 0;
        }

        //checking for both ends
        //checking for both ends because they are elements with only one neighbour
        //and if they are bigger than their neigbours than we got our answer.
        //so you just check for extreme cases  earlier and rest of the things are same as Sir Ad approach.
        if(nums[0]>nums[1])
        {return 0;}

        if(nums[n-1]>nums[n-2])
        {return n-1;}

        int lo =1 , hi =n-2;

        while(lo<=hi)
        {
            int mid = lo + (hi-lo)/2;

            //for a element to be a peak element. it has to be greater than its prev and next element
            //this condition is only for elements between 1st and last element of array
            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1])
            {
                return mid;
            }

            //here i am deciding to jump in which side if i didnt find the peak element above
            //if the element is greater than prev but lesser than next then its not peak element, and i will jump onto the
            //right side because the condition failed while checking for next, so there is a possibility to find on right
            //on left side since the condtion already passed for prev, there wont be peak on left in this case

            if(nums[mid+1]>nums[mid])
            {
                lo=mid+1;
            }
            else
            {
                //similarly i jump onto the left side if the condition failed on left and passed on right
                hi=mid-1;
            }

        }
        return -1;

    }
}
