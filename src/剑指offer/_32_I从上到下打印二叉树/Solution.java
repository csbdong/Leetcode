package 剑指offer._32_I从上到下打印二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
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
 * 返回：
 *
 * [3,9,20,15,7]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<Integer> result = new ArrayList();
        List<TreeNode> node = new ArrayList();
        node.add(root);
        int index = 0;
        while (index < node.size()) {
            int length = node.size() - index;
            for (int i = 0; i < length; i++) {
                TreeNode t = node.get(index++);
                result.add(t.val);
                if (t.left != null) {
                    node.add(t.left);
                }
                if (t.right != null) {
                    node.add(t.right);
                }
            }
        }
        int[] res = new int[result.size()];
        index = 0;
        for (Integer i : result) {
            res[index++] = i;
        }
        return res;

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
