package 剑指offer._32_III从上到下打印二叉树III;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
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
 *   [20,9],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof
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
        boolean dir = true;
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
            if (!dir) {
                Collections.reverse(tmp);
            }
            result.add(tmp);
            dir = !dir;
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


