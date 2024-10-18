class BinaryTree{
    TreeNode root; 
    // Inserting a new node in the Binary Tree 
    public TreeNode insert(TreeNode root, int val){
        if(root==null){
            root=new TreeNode(val);
            return root; 
        }
        if(val<root.val){
            root.left=insert(root.left, val); // Inserting a new node with the speicified value in the left side 
        }else if(val>root.val){
            root.right=insert(root.right, val);
        }
        return root; // A root has been created. 
    }
    // Deleting a node from the binary tree 
    public TreeNode delete(TreeNode root, int key){
        if(root==null) return root; 
        if(key<root.val){
            root.left=delete(root.left, key); // key is in the left subtree then 
        }else if(key>root.val){
            root.right=delete(root.right, key);
        }else{
            // Node with only one child or no child 
            if(root.left==null) return root.right; 
            else if(root.right==null) return root.left; 
            root.val=minValue(root.right);
            // Node with 2 cchildren 
            root.val = minValue(root.right);
            // Delete the inOrder successor 
            root.right = delete(root.right, root.val);
        }
        return root;
    }
    // Finding the smallest value 
    private int minValue(TreeNode root){
        int minv=root.val;
        while(root.left!=null){
            minv=root.left.val;
            root=root.left; 
        }
        return minv;
    }
    // Pre-Order Traversal 
    public void preOrder(TreeNode root){
        if(root!=null){
            System.out.println(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    // In-Order Traversal 
    public void inOrder(TreeNode root){
        if(root!=null){
            inOrder(root.left);
            System.out.println(root.val);
            inOrder(root.right);
        }
    }
    // Post-Order traversal
    public void postOrder(TreeNode root){
        if(root!=null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.val);
        }
    }
    public static void main(String[] args){
        BinaryTree tree=new BinaryTree();
        tree.root=tree.insert(tree.root, 50);
        tree.insert(tree.root, 30);
        tree.insert(tree.root, 20);
        tree.insert(tree.root, 40);
        tree.insert(tree.root, 70);
        tree.insert(tree.root, 60);
        tree.insert(tree.root, 80);

        System.out.println("In-order traversal: ");
        tree.inOrder(tree.root);
        System.out.println("Pre-Order Traversal: ");
        tree.preOrder(tree.root);
        System.out.println("Post Order traversal: ");
        tree.postOrder(tree.root);
        // Deleting node with value 20 
        System.out.println("\n\nDeleting.. 20");
        tree.root=tree.delete(tree.root, 20); 
        System.out.println("In Order traversal after deleting 20: "); 
        tree.inOrder(tree.root);
    }
}