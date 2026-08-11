// 11/08/2026

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val , TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Practice {
    
    // ------------------------------------------------------------------
    // wrote from memory 
    // ------------------------------------------------------------------
    
    static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    static int countLeafNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int leftLeafCount  = countLeafNodes(root.left);
        int rightLeafCount  = countLeafNodes(root.right);

        return leftLeafCount + rightLeafCount ;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(7);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(12);
        root.left.left.left = new TreeNode(71);

        System.out.println(height(root));
        System.out.println(countLeafNodes(root));
        System.out.println(contains(root,1));
        System.out.println(sumNodes(root));
        System.out.println(isBalanced(root));
    }
    
    // ------------------------------------------------------------------
    // new concepts today - 
    // ------------------------------------------------------------------
    
    static boolean contains(TreeNode root,int target) {
        if (root == null) {
            return false;
        }
        if (root.val == target) {
            return true;
        }

        boolean inLeft = contains(root.left,target);
        boolean inRight = contains(root.right,target);

        return (inLeft || inRight);
    }

    static int sumNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSum = sumNodes(root.left);
        int rightSum = sumNodes(root.right);

        return leftSum + rightSum + root.val;
    }

    // not completed , still some issues in this code 
    static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if (Math.abs(leftHeight - rightHeight) <= 1) {
            return true;
        }
        else {
            return false;
        }
    }
}