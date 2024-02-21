package leetcode.每日一题._106从中序与后序遍历序列构造二叉树;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;
        Map<Integer, Integer> indexMap = new HashMap();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTree(inorder, postorder, 0, n - 1, 0, n - 1, indexMap);
    }

    TreeNode buildTree(int[] inorder, int[] postorder, int postorder_left, int postorder_right, int inorder_left,
                       int inorder_right,
                       Map<Integer, Integer> indexMap) {
        if (postorder_left > postorder_right) {
            return null;
        }
        int postorder_index = postorder_right;
        TreeNode root = new TreeNode(postorder[postorder_index]);
        int inorder_root = indexMap.get(postorder[postorder_index]);
        int subTreeLeftSize = inorder_root - inorder_left;
        root.left = buildTree(inorder, postorder, postorder_left, postorder_left + subTreeLeftSize - 1, inorder_left,
                inorder_root - 1,
                indexMap);
        root.right = buildTree(inorder, postorder, postorder_left + subTreeLeftSize, postorder_right - 1,
                inorder_root + 1,
                inorder_right, indexMap);
        return root;

    }

    public static void main(String[] args) {
        new Solution().buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
