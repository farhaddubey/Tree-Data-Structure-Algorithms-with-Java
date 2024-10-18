class BinaryTreeNode{
    int data; 
    BinaryTreeNode left, right; 
    BinaryTreeNode(int data){
        this.data=data; 
        left=right=null;
    }
}

public class BinaryTree{
    public static BinaryTreeNode root; 
    public BinaryTreeNode insert(BinaryTreeNode root, int data){
        // Base case or the terminating case or the stopping case 
        if(root==null){
            root=new BinaryTreeNode(data);
            return root;
        }
        // Inserting int the lft side as per BST 
        if(data<root.data){
            root.left=insert(root.left, data);
        }
        // if the dataue is greate 
        if(data>root.data){
            root.right=insert(root.right, data);
        }
        return root; 
    }
    // Prefix Traversal 
    public void preOrder(BinaryTreeNode root){
        if(root!=null){
            // root, left, right 
            System.out.println(root.data); // Visiting the root
            preOrder(root.left); // Traversing the left subtree 
            preOrder(root.right); // Traversing the right subtree 
        }
    }
    public void inOrder(BinaryTreeNode root){
        if(root!=null){
            // left root right 
            inOrder(root.left); 
            System.out.println(root.data); 
            inOrder(root.right); 
        }
    }
    public void postOrder(BinaryTreeNode root){
        if(root!=null){
            postOrder(root.left);
            postOrder(root.right); 
            System.out.println(root.data);
        }
    }
    // Delete Function 
    public BinaryTreeNode delete(BinaryTreeNode root, int key){
        if(root==null) return root; 
        // Searching if the elemenr is greate or lesser 
        if(key<root.data){
            root.left=delete(root.left, key);
        }else if(key>root.data){
            root.right=delete(root.right, key);
        }else{
            // We have got the elements for 1ly 1 child case 
            if(root.left==null){
                return root.right; 
            }
            else if(root.right==null){
                return root.left; 
            }
            // When having 2 children 
            root.data=mindata(root.right); 
            // Deleting the inOrder succsor 
            root.right=delete(root.right, root.data);
        }
        return root; 
    }
    private int mindata(BinaryTreeNode root){
        int minv=root.data;
        while(root.left!=null){
            minv=root.left.data; 
            root=root.left; 
        }
        return minv; 
    }
    public static void main(String[] args){
        BinaryTree tree=new BinaryTree();
        // Inserting dataues into the tree and assigning back to tree node  
        tree.root=tree.insert(tree.root, 50); 
        tree.insert(tree.root, 30);
        tree.insert(tree.root, 70);
        tree.insert(tree.root, 20);
        tree.insert(tree.root, 40);
        tree.insert(tree.root, 60);
        tree.insert(tree.root, 100);
        System.out.println("Post-Order Traversal: ");
        tree.postOrder(tree.root);
        System.out.println("Deleting the 50.........."); 
        tree.delete(tree.root, 50);
        System.out.println("After deletion..");
        tree.preOrder(tree.root);
    }
}