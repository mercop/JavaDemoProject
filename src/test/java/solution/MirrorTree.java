package solution;

import org.junit.Test;


/**
 * Created by mercop on 2017/7/5.
 *
 * 二叉树的镜像定义：源二叉树
            8
         /  \
         6   10
         / \  / \
         5  7 9 11
         镜像二叉树
            8
         /  \
         10   6
         / \  / \
         11 9 7  5
 */
public class MirrorTree {

    TreeNode treeNode = null;
    public void Mirror(TreeNode root) {
        if(root == null)
            return;
        treeNode = root.left;
        root.left = root.right;
        root.right = treeNode;

        Mirror(root.left);
        Mirror(root.right);
    }

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public void printTree(TreeNode node){
        if(node ==null)
            return;
        System.out.println(node.val);
        printTree(node.left);
        printTree(node.right);
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(9);
        root.right.left = new TreeNode(11);
        root.right.right = new TreeNode(15);
        //printTree(root);
        Mirror(root);
        printTree(root);
    }
}


