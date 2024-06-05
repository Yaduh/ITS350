package search.BTS;

public class BinaryTreeSearch {
    TreeNode root;
    void insert(int data){
        TreeNode node = new TreeNode(data);  // Create a new node with the given data
        if(root == null)  // If the tree is empty, set the root to the new node
            root = node;
        else{
            TreeNode current = root;  // Start from the root
            TreeNode parent;
            while(true){
                parent = current;  // Keep track of the parent node
                if(data < current.data){  // Go to the left subtree if data is smaller
                    current = current.leftChild; 
                    if(current == null){  // If the left child is null, insert the node here
                        parent.leftChild = node;
                        return;
                    }
                }else{  // Go to the right subtree if data is larger or equal
                    current = current.rightChild;
                    if(current == null){  // If the right child is null, insert the node here
                        parent.rightChild = node;
                        return;
                    }
                }
            }
        }
    }
    
    public TreeNode find(int key){
        TreeNode temp = root;  // Start from the root
        while(temp != null){  // Traverse the tree until the node is found or null is reached
            if(temp.data == key)  // If the current node's data matches the key, return it
                return temp;
            if(key < temp.data)  // Go to the left subtree if key is smaller
                temp = temp.leftChild;
            else  // Go to the right subtree if key is larger
                temp = temp.rightChild;
        }
        return temp;  // Return null if the key is not found
    }
    
    public void inOrder(TreeNode root){
        if(root != null){  // Traverse the tree in in-order fashion
            inOrder(root.leftChild);  // Visit left subtree
            System.out.println(root.data);  // Visit root
            inOrder(root.rightChild);  // Visit right subtree
        }
    }
    
    public void preOrder(TreeNode root){
        if(root != null){  // Traverse the tree in pre-order fashion
            System.out.println(root.data);  // Visit root
            preOrder(root.leftChild);  // Visit left subtree
            preOrder(root.rightChild);  // Visit right subtree
        }
    }
    
    public TreeNode min(){
        TreeNode min = root;  // Start from the root
        while(min.leftChild != null){  // Go to the leftmost node
            min = min.leftChild;
        }
        return min;  // Return the leftmost node
    }
    
    public TreeNode minR(TreeNode root){
        if(root.leftChild == null)  // If the left child is null, return the current node
            return root;
        else
            return minR(root.leftChild);  // Recursively find the leftmost node
    }
    
    public boolean delete(int key){
        boolean isLeft = false;
        TreeNode parent = root;
        TreeNode current = root;
        while(current.data != key){  // Traverse the tree to find the node to delete
            parent = current;
            if(current.data > key){
                isLeft = true;
                current = current.leftChild;
            }else{
                isLeft = false;
                current = current.rightChild;
            }
            if(current == null)
                return false;  // Return false if the key is not found
        }
        // Case 1: Deleting a leaf node
        if(current.leftChild == null && current.rightChild == null){
            if(current == root)
                root = null;
            else{
                if(isLeft)
                    parent.leftChild = null;
                else
                    parent.rightChild = null;
            }
        }
        // Case 2: Deleting a node with only one child
        else if(current.leftChild == null){
            if(current == root)
                root = current.rightChild;
            else{
                if(isLeft)
                    parent.leftChild = current.rightChild;
                else
                    parent.rightChild = current.rightChild;
            }
        }else if(current.rightChild == null){
            if(current == root)
                root = current.leftChild;
            else{
                if(isLeft)
                    parent.leftChild = current.leftChild;
                else
                    parent.rightChild = current.leftChild;
                }
            }
        // Case 3: Deleting a node with two children
        else{
            TreeNode succ = getSuccessor(current);  // Find the successor
            if(isLeft)
                parent.leftChild = succ;
            else
                parent.rightChild = succ;
            succ.leftChild = current.leftChild;  // Connect the successor to the left subtree
        }
        return true;
    }
    
    public TreeNode getSuccessor(TreeNode node){
        TreeNode sParent = node;
        TreeNode succ = node;
        TreeNode tmp = node.rightChild;
        while(tmp != null){  // Find the minimum node in the right subtree
            sParent = succ;
            succ = tmp;
            tmp = tmp.leftChild;
        }
        if(succ != node.rightChild){
            sParent.leftChild = succ.rightChild;  // Adjust the parent's left child
            succ.rightChild = node.rightChild;  // Adjust the successor's right child
        }
        return succ;  // Return the successor
    }
    
    public static void main(String args[]){
        BinaryTreeSearch bTree = new BinaryTreeSearch();
        bTree.insert(23);
        bTree.insert(9);
        bTree.insert(34);
        bTree.insert(30);
        bTree.insert(90);
        bTree.insert(4);
        bTree.insert(15);
        bTree.insert(13);
        bTree.insert(1);
        bTree.inOrder(bTree.root);
        System.out.println(bTree.delete(30));
        System.out.println(bTree.delete(4));
        bTree.inOrder(bTree.root);
    }
}

