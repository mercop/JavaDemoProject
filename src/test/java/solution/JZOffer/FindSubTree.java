package solution.JZOffer;

import org.junit.Test;

/**
 * Created by mercop on 2017/7/5.
 *
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class FindSubTree {

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        if(root1 != null && root2 != null){
            if(root1.val == root2.val)
                result = findRootOfBTreeInATree(root1,root2);
            if(!result)
                result = findRootOfBTreeInATree(root1.left,root2);
            if(!result)
                result = findRootOfBTreeInATree(root1.right,root2);
        }

        return result;
    }

    private boolean findRootOfBTreeInATree(TreeNode root1, TreeNode root2) {
        if(root2 == null)
            return true;
        if(root1 == null)
            return false;
        if(root1.val == root2.val){
            return findRootOfBTreeInATree(root1.left,root2.left)
                    && findRootOfBTreeInATree(root1.right,root2.right);
        }
        return false;
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

        TreeNode rootB = new TreeNode(12);
        rootB.right = new TreeNode(15);


        System.out.println(new FindSubTree().HasSubtree(root,rootB));

    }


    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }


}

