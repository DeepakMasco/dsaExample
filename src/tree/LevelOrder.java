package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/binary-tree-level-order-traversal/
public class LevelOrder {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) {
            return ans;
        }

        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()) {
            int level = que.size();
            List<Integer> currLevel = new ArrayList<>();
            for(int i=0;i<level;i++) {
                TreeNode current = que.poll();
                currLevel.add(current.val);
                if(current.left!=null) {
                    que.add(current.left);
                }
                if(current.right!=null) {
                    que.add(current.right);
                }
            }
            ans.add(currLevel);
        }
        return ans;
    }
}
