package LeetCodeSolution;

public class MinimumAbsoluteDifferenceInBST {
    int ans;
    int temp;

    public int getMinimumDifference(TreeNode root) {
        ans = Integer.MAX_VALUE;
        temp = -1;
        dps(root);
        return ans;
    }

    public void dps(TreeNode root) {
        if(root == null) return;
        dps(root.left);
        if (temp != -1) {
            ans = Math.min(ans, root.val - temp);
        }
        temp = root.val;
        dps(root.right);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(3);
        TreeNode root3 = new TreeNode(2);

        root1.right = root2;
        root2.left = root3;

        MinimumAbsoluteDifferenceInBST m = new MinimumAbsoluteDifferenceInBST();
        int result = m.getMinimumDifference(root1);
        System.out.println(result);
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){ val = x; }
}