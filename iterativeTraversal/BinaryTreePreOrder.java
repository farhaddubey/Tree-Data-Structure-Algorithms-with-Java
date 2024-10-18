import java.util.Stack; 
// PreOrder Traversal processes nodes in the following order: Root -> Left -> Right 
// Starting from the root node, processing it(printing or storing it) & pushing it's right child if any then left child  
// Continue by popping the stack, processing the node, and pushing it's children  
public class BinaryTreePreOrder{
    TreeNode root; 
    void preOrderTraversal(){
        if(root==null){
            return; 
        }
        Stack<TreeNode> stack=new Stack<>();  
        stack.push(root); // Step 1: Pushing the root node onto the stack 
        while(!stack.isEmpty()){
            // Step 2: Popping the top node from the stack and processing it 
            TreeNode currentNode=stack.pop(); 
            System.out.print(currentNode.data+ " "); // Node printed or could be added 
            // Step 3: Pushing the right child first, then the left tree (if they exist)
            if(currentNode.right!=null){
                stack.push(currentNode.right); 
            }
            if(currentNode.left!-null){
                stack.push(currentNode.left); 
            }
        }
    }
    public static void main(String[] args){
        BinaryTreePreOrder tree=new BinaryTreePreOrder(); 
        tree.root=new TreeNode(1); 
        tree.root.left=new TreeNode(2); 
        tree.root.right=new TreeNode(3); 
        tree.root.left.left=new TreeNode(4); 
        tree.root.left.right=new TreeNode(5); 
        System.out.println("PreOrder Traversal: "); 
        tree.preOrderTraversal(); 
    }
}