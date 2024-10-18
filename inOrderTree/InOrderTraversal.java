// InOrder Traversal ie. Traversing InOrdering the Tree ie Travelling throught the Entire Tree 
class TreeNode{
    int data; |  |  |  |
    TreeNode left, right; 
    TreeNode(int data){
        this.data=data; 
        left=right=null;
    }
}

public class InOrderTraversal{
    // Recursive InOrder Traversal
    public void inOrderRecursive(TreeNode root){
        if(root!=null){
            inOrderRecursive(root.left);
            System.out.println(root.data);
            inOrderRecursive(root.right);
        }
    }
    public static void main(String[] args){
        // Creataing the binary Tree 
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.left.left=new TreeNode(4);
        root.right=new TreeNode(3);
        root.left.right=new TreeNode(5);
        // Performing InOrder Traversal 
        InOrderTraversal tree=new InOrderTraversal();
        System.out.println("Recursive InOrder Traversal: ");
        tree.inOrderRecursive(root);

    }
}