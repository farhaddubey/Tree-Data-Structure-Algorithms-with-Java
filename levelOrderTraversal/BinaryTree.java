import java.util.LinkedList; 
import java.util.Queue; 

class BinaryTreeNode{
    int data; 
    BinaryTreeNode left, right; 
    BinaryTreeNode(int data){
        this.data=data; 
        left=right=null;
    }
}
public class BinaryTree{
    BinaryTreeNode root; // root node of the binary tree but of custom type BinaryTeeNode 
    // Level Order Traversal 
    void levelOrderTraversal(){
        if(root==null){ // Base case checking if the tree is empty 
            return;
        }
        // Initializing a queue to keep track of the nodes to visit 
        Queue<BinaryTreeNode> queue=new LinkedList<>(); 
        queue.add(root); // Adding the root node to the tree 
        // Looping until the queue is empty 
        while(!queue.isEmpty()){
            // Deque the node at the front of the queue 
            BinaryTreeNode currentNode =queue.poll(); 
            // Processing the current node 
            System.out.println(currentNode.data+ "  ");
            // Adding left child to the queue if it exists 
            if(currentNode.left!=null){
                queue.add(currentNode.left);
            }
            // Adding right child to the queue if it exists 
            if(currentNode.right!=null){
                queue.add(currentNode.right);
            }
        }
    }
    public static void main(String[] args){
        BinaryTree tree=new BinaryTree(); 
        tree.root=new BinaryTreeNode(1); // root with 1
        tree.root.left=new BinaryTreeNode(2); 
        tree.root.right=new BinaryTreeNode(3);
        tree.root.left.left=new BinaryTreeNode(4);
        tree.root.left.right=new BinaryTreeNode(5);
        // Performing level order traversals 
        System.out.println("Level order traversal of the binary tree....");
        tree.levelOrderTraversal();
    }
}