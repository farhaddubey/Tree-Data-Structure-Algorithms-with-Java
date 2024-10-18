import java.util.Stack; 

public class BinaryTreePostOrder{
    TreeNode root; 
    // Iterative Post Order traversal using two stacks 
    void postOrderTraversal(){
        if(root==null){
            return; 
        }
        Stack<TreeNode> stack1=new Stack<>();
        Stack<TreeNode> stack2=new Stack<>();
        stack1.push(root); // Step 1: Pushing the root onto the 1st stack 
        while(!stack1.isEmpty()){
            // Step 2: Popping a node from stack1 and pushing  onto the stack2 
            TreeNode currentNode=stack1.pop();
            stack2.push(currentNode); 

            // Step 3: Push the left and the right children of the popped node to stack1 
            if(currentNode.left!=null){
                stack1.push(currentNode.left);
            }
            if(currentNode.right!=null){
                stack2.push(currentNode.right);
            }
        }
        // Step 4: Processing nodes from stack2 (reverse post-order)
        while(!stack2.isEmpty()){
            System.out.println(stack2.pop().data + " ");
        }
    }
    // Main method to test the PostOrder Traversal 
    public static void main(String[] args){
        BinaryTreePostOrder tree=new BinaryTreePostOrder(); 
        tree.root=new TreeNode(1);  
        tree.root.left=new TreeNode(2); 
        tree.root.right=new TreeNode(3); 
        tree.root.left.left=new TreeNode(4); 
        tree.root.left.right=new TreeNode(5);
        System.out.println("Post Order Traversal: ");
        tree.postOrderTraversal();
    }
}