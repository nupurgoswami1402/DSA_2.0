/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    private Map<Integer, TreeNode> roots = new HashMap<>();

    public TreeNode canMerge(List<TreeNode> trees) {
        Map<Integer, Integer> count = new HashMap<>();

        // Store all roots
        for (TreeNode tree : trees) {
            roots.put(tree.val, tree);
            count.put(tree.val, count.getOrDefault(tree.val, 0) + 1);

            if (tree.left != null)
                count.put(tree.left.val, count.getOrDefault(tree.left.val, 0) + 1);

            if (tree.right != null)
                count.put(tree.right.val, count.getOrDefault(tree.right.val, 0) + 1);
        }

        TreeNode root = null;

        // Find the unique root
        for (TreeNode tree : trees) {
            if (count.get(tree.val) == 1) {
                root = tree;
                break;
            }
        }

        if (root == null) return null;

        roots.remove(root.val);

        if (!dfs(root, Long.MIN_VALUE, Long.MAX_VALUE))
            return null;

        if (!roots.isEmpty())
            return null;

        return root;
    }

    private boolean dfs(TreeNode node, long min, long max) {
        if (node == null)
            return true;

        if (node.val <= min || node.val >= max)
            return false;

        // Merge another tree at a leaf
        if (node.left == null && node.right == null && roots.containsKey(node.val)) {
            TreeNode merge = roots.remove(node.val);
            node.left = merge.left;
            node.right = merge.right;
        }

        return dfs(node.left, min, node.val) &&
               dfs(node.right, node.val, max);
    }
}