package tree;

import java.util.HashSet;
import java.util.Set;

public class TwoSumInBst {

    public int isPairPresent(Node root, int target)
    {
        // Write your code here
        Set<Integer> set = new HashSet<>();

        return check(root, target, set) ==true ? 1 : 0;

    }

// We will do inorder traversal. and apply the same logic to find the 2 sum in array using set or map
    public boolean check(Node root, int target, Set<Integer> set) {
        if(root==null) {
            return false;
        }

        if(check(root.left,target,set)) {
            return true;
        }

        if(set.contains(root.data)) {
            return true;
        } else {
            set.add(target-root.data);
        }

        return check(root.right,target,set);
    }
}
