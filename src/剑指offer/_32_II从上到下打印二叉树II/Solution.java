package 剑指offer._32_II从上到下打印二叉树II;

import java.util.ArrayList;
import java.util.List;

/**
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 *
 *  
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        if (root == null) {
            return result;
        }
        List<TreeNode> node = new ArrayList();
        node.add(root);
        int index = 0;
        while (index < node.size()) {
            int length = node.size() - index;
            List<Integer> tmp = new ArrayList();
            for (int i = 0; i < length; i++) {
                TreeNode t = node.get(index++);
                tmp.add(t.val);
                if (t.left != null) {
                    node.add(t.left);
                }
                if (t.right != null) {
                    node.add(t.right);
                }
            }
            result.add(tmp);
        }
        return result;

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

