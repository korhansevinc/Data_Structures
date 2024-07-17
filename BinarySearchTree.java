public class BinarySearchTree {

    class Node{
        public int data ;
        public Node left ; // leftChild
        public Node right ;  // rightChild

        public Node(int newData){
            data = newData ;
            left = null ;
            right = null ;
        }

    }

    public Node root ;

    public BinarySearchTree(){
        root = null ;
    }

    public void insert(int newData){
        root = insert(root,newData);
    }

    public Node insert(Node root , int newData){
        if(root == null){
            root = new Node(newData);
            return root;
        }
        else if(root.data >= newData){
            root.left = insert(root.left, newData);
        }
        else{
            root.right = insert(root.right, newData);
        }

        return root ;
    }

    public void preorder(){
        preorder(root);
    }

    public void preorder(Node root){
        if(root == null)
            return  ;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public int findMinimum(){
        Node position = root ;
        while(position !=null){
            position = position.left;
        }
        return position.data ;
    }

    public int findMaximum(){
        Node position = root ;
        while(position != null)
            position = position.right;
        return position.data ;
    }

    public boolean search(int data){
        return search(this.root, data);
    }

    private boolean search(Node root , int data){
        if(root == null)
            return false ;
        else if ( root.data == data)
            return true ;
        else if (root.data> data)
            return search(root.left,data);
        return search(root.right,data);
    }

    public void deleteAtNode(Node node){
        deleteAtNode(this.root,node);
    }

    private Node deleteAtNode(Node root, Node node) {
        // check for node initially
        if (root == null) {
            return null;
        } else if (node.data < root.data) {
            // process the left sub tree
            root.left = deleteAtNode(root.left, node);
        } else if (node.data > root.data) {
            // process the right sub tree
            root.right = deleteAtNode(root.right, node);
        } else if(root.data==node.data){
            // case 3: 2 child
            if (root.left != null && root.right != null) {
                int lmax = findMaxData(root.left);
                root.data = lmax;
                root.left = deleteAtNode(root.left, new Node(lmax));
                return root;
            }
            //case 2: one child
            // case i-> has only left child
            else if (root.left != null) {
                return root.left;
            }
            // case ii-> has only right child
            else if (root.right != null) {
                return root.right;
            }
            //case 1:- no child
            else {
                return null;
            }
        }
        return root;
    }

    public int findMaxData(Node root) {
        if (root.right != null) {
            return findMaxData(root.right);
        } else {
            return root.data;
        }
    }


}
