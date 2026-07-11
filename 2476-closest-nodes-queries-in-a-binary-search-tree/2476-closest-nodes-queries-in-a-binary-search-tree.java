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

    List<Integer> inorder = new ArrayList<>();

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        inorderTraversal(root);

        List<List<Integer>> ans = new ArrayList<>();

        for (int q : queries) {
            ans.add(findClosest(q));
        }

        return ans;
    }

    private void inorderTraversal(TreeNode node) {
        if (node == null) return;

        inorderTraversal(node.left);
        inorder.add(node.val);
        inorderTraversal(node.right);
    }

    private List<Integer> findClosest(int target) {
        int floor = -1;
        int ceil = -1;

        int left = 0;
        int right = inorder.size() - 1;

        // Find floor
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (inorder.get(mid) <= target) {
                floor = inorder.get(mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        left = 0;
        right = inorder.size() - 1;

        // Find ceil
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (inorder.get(mid) >= target) {
                ceil = inorder.get(mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return Arrays.asList(floor, ceil);
    }
}