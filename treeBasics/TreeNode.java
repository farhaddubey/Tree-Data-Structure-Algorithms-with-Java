// Define a basic tree node class
class TreeNode {
    int data;           // Value of the node
    TreeNode left;      // Reference to the left child
    TreeNode right;     // Reference to the right child
    
    // Constructor to create a new node
    public TreeNode(int value) {
        data = value;
        left = right = null;
    }
}