package tree;

public class FloorAndCeil {

    static int minDiff(Node  root, int K)
    {
        // Write your code here
        int floor = findFloor(root,K);
        int ceil = findCeil(root,K);

        return Math.min(Math.abs(K-floor),Math.abs(K-ceil));
    }

    public static int findFloor(Node root, int k) {
        int ans = Integer.MAX_VALUE;

        while(root!=null) {
            if(root.data==k) {
                return k;
            } else if(root.data>k) {
                root = root.left;
            }
            // As root data is already greated then K then it does not come for floor value as that is always small
            else {
                ans = root.data;
                root = root.right;
            }
        }

        return ans;
    }


    public static int findCeil(Node root, int k) {
        int ans = Integer.MAX_VALUE;

        while(root!=null) {
            if(root.data==k) {
                return k;
            } else if(root.data>k) {
                ans = root.data;
                root = root.left;
            }
            // As the value is already small then K it does it qualify for ceil value as it is always greater than K
            else {
                root = root.right;
            }
        }

        return ans;
    }
}
