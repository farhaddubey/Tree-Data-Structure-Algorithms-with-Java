import java.util.Stack; 

// We'll be using here explicit or external stack. While recursion the inbuilt stack of recursion was utilised 
public class BinaryTreeInOrder{
    TreeNode root; 
    // Iterative InOrder Traversal 
    void inOrderTraversal(){
        if(root==null) return; 
        Stack<TreeNode> stack=new Stack<>(); 
        TreeNode currentNode=root; 
        while(currentNode!=null || !stack.isEmpty()){
            while(currentNode!=null){
                stack.push(currentNode); 
                currentNode=currentNode.left; 
            }
            // After all the nodes of left tree has been added now we're at the end so 'll be popping the end now
            //& 'll be handling the cases to print the root and the right also 
            currentNode=stack.pop(); // last node is being pointed by the current Node 
            System.out.println(currentNode.data); 
            // Moving to the right child fo the node 
           currentNode=currentNode.right; 
        }
    }
     public static void main(String[] args){
             BinaryTreeInOrder inOrder=new BinaryTreeInOrder(); 
             inOrder.root=new TreeNode(1); 
             inOrder.root.left=new TreeNode(2);  
             inOrder.root.right=new TreeNode(3); 
             inOrder.root.left.left=new TreeNode(4); 
             inOrder.root.left.right=new TreeNode(5); 
             System.out.println("Traversing using iterative inOrder:..");
             inOrder.inOrderTraversal();
    }
}