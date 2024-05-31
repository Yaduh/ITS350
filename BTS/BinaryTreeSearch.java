package BTS;

public class BinaryTreeSearch {
    TreeNode root;
    void insert(int data){
        TreeNode node = new TreeNode(data);
        if(root==null)
            root=node;
        else{
            TreeNode current = root;
            TreeNode parent;
            while(true){
                parent = current;
                if(data < current.data){
                    current = current.leftChild;
                    if(current==null){
                        parent.leftChild = node;
                        return;
                    }
                }else{
                    current = current.rightChild;
                    if(current==null){
                        parent.rightChild = node;
                        return;
                    }
                }
            }
        }
    }
    public TreeNode find(int key){
        TreeNode temp=root;
        while(temp!=null){
            if(temp.data == key)
                return temp;
            if(key<temp.data)
                temp = temp.leftChild;
            else
                temp = temp.rightChild;
        }
        return temp;
    }
    public void inOrder(TreeNode root){
        if(root!=null){
            inOrder(root.leftChild);
            System.out.println(root.data);
            inOrder(root.rightChild);
        }
    }
    public void preOrder(TreeNode root){
        if(root!=null){
            System.out.println(root.data);
            preOrder(root.leftChild);
            preOrder(root.rightChild);
        }
    }
    public TreeNode min(){
        TreeNode min = root;
        while(min.leftChild!=null){
            min = min.leftChild;
        }
        return min;
    }
    public TreeNode minR(TreeNode root){
        if(root.leftChild==null)
            return root;
        else
            return minR(root.leftChild);
    }
    public boolean delete(int key){
        boolean isLeft = false;
        TreeNode parent = root;
        TreeNode current = root;
        while(current.data != key){
            parent = current;
            if(current.data>key){
                isLeft = true;
                current = current.leftChild;
            }else{
                isLeft = false;
                current = current.rightChild;
            }
            if(current==null)
                return false;
        }//Case 1
        if(current.leftChild == null && current.rightChild == null){
            if(current==root)
                root = null;
            else{
                if(isLeft)
                    parent.leftChild = null;
                else
                    parent.rightChild = null;
            }
        }//Case 2
        else if(current.leftChild == null){
            if(current==root)
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
        }//Case 3
        else{
            TreeNode succ = getSuccessor(current);
            if(isLeft)
                parent.leftChild = succ;
            else
                parent.rightChild = succ;
            succ.leftChild = current.leftChild;
        }
        return true;
    }
    public TreeNode getSuccessor(TreeNode node){
        TreeNode sParent = node;
        TreeNode succ = node;
        TreeNode tmp = node.rightChild;
        while(tmp != null){
            sParent = succ;
            succ = tmp;
            tmp = tmp.leftChild;
        }
        if(succ != node.rightChild){
            sParent.leftChild = succ.rightChild;
            succ.rightChild = node.rightChild;
        }
        return succ;
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

