package cn.zhumouren.leetcode.swordoffer;

import java.util.HashMap;
import java.util.Map;

public class Offer7 {

    //标记中序遍历
    private final Map<Integer, Integer> dic = new HashMap<>();
    private int[] preorder;

    public static void main(String[] args) {
        TreeNode root = new Offer7().buildTree(new int[]{1, 2, 4, 7, 3, 5, 6, 8}, new int[]{4, 7, 2, 1, 5, 3, 8, 6});
        pre(root);
        System.out.println();
        ino(root);
    }

    public static void pre(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + "\t");
            pre(root.left);
            pre(root.right);
        }
    }

    public static void ino(TreeNode root) {
        if (root != null) {
            ino(root.left);
            System.out.print(root.val + "\t");
            ino(root.right);
        }
    }

    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
     * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            dic.put(inorder[i], i);
        }
        return recur(0, 0, inorder.length - 1);
    }

    private TreeNode recur(int root, int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[root]);
        int i = dic.get(preorder[root]);
        //左子树的根的索引为先序中的根节点+1
        //递归左子树的左边界为原来的中序in_left
        //递归左子树的右边界为中序中的根节点索引-1
        node.left = recur(root + 1, left, i - 1);
        //右子树的根的索引为先序中的 当前根位置 + 左子树的数量 + 1
        //递归右子树的左边界为中序中当前根节点+1
        //递归右子树的右边界为中序中原来右子树的边界
        node.right = recur(root + i - left + 1, i + 1, right);
        return node;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}

