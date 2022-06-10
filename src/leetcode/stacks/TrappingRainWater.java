package leetcode.stacks;

public class TrappingRainWater {

    public static void main(String[] args) {
    int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};

//The below method is for brute force on2 complexity
   /*     int ans = 0;
        for(int i=0;i<height.length;i++) {
            int right_max = 0;
            int left_max = 0;

            for(int j=i+1;j<height.length;j++) {
                if(height[j] >right_max)
                {
                    right_max = height[j];
                }
            }
            for(int k=0;k<i;k++) {
                if(height[k] >left_max)
                {
                    left_max = height[k];
                }
            }
            if(Math.min(left_max,right_max) - height[i] >0)
            ans+= Math.min(left_max,right_max) - height[i];
        }

System.out.println(ans);*/

    int len = height.length;
    int ans = 0;
    int[] maxR = new int[len];
    int[] maxL = new int[len];
    maxR[0] = height[0];
        maxL[len-1] = height[len-1];
    for(int i=1;i<len;i++) {
        maxR[i] = Math.max(height[i], maxR[i-1]);
    }

        for(int i=len-2;i>=0;i--) {
            maxL[i] = Math.max(height[i], maxL[i+1]);
        }

        for(int i=0;i<len;i++) {
            ans+= Math.min(maxR[i], maxL[i]) - height[i];
        }

        System.out.println(ans);

    }
}
