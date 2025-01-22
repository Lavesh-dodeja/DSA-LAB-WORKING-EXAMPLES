class AVLTree {

    class Node {
        int key;
        Node left, right;
        int height;

        public Node(int key) {
            this.key = key;
            this.height = 1;
        }
    }

    private Node root;

   
    private int height(Node node) {
        return (node == null) ? 0 : node.height;
    }

   
    private int getBalance(Node node) {
        return (node == null) ? 0 : height(node.left) - height(node.right);
    }

    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

     
        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }


    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

    
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    
    private Node deleteNode(Node root, int key) {
        if (root == null) return root;


        if (key < root.key) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.key) {
            root.right = deleteNode(root.right, key);
        } else {
    
            if (root.left == null || root.right == null) {
                Node temp = root.left != null ? root.left : root.right;

        
                if (temp == null) {
                    root = null;
                } else {
                    root = temp;
                }
            } else {
            
                Node temp = minValueNode(root.right);

                
                root.key = temp.key;

        
                root.right = deleteNode(root.right, temp.key);
            }
        }


        if (root == null) return root;


        root.height = Math.max(height(root.left), height(root.right)) + 1;

        
        int balance = getBalance(root);

        if (balance > 1 && getBalance(root.left) >= 0) {
            return rightRotate(root);
        }


        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }


        if (balance < -1 && getBalance(root.right) <= 0) {
            return leftRotate(root);
        }

        
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    private Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    
    public void delete(int key) {
        root = deleteNode(root, key);
    }


    private void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }

    public void inorder() {
        inorder(root);
        System.out.println();
    }


    public void insert(int key) {
        root = insert(root, key);
    }


    private Node insert(Node node, int key) {
        if (node == null) return new Node(key);

    
        if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        } else {
            return node; 
        }

        
        node.height = Math.max(height(node.left), height(node.right)) + 1;

    
        int balance = getBalance(node);


    
        if (balance > 1 && key < node.left.key) {
            return rightRotate(node);
        }

    
        if (balance < -1 && key > node.right.key) {
            return leftRotate(node);
        }

    
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }


        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

}   

public class Q1
{

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        tree.insert(20);
        tree.insert(10);
        tree.insert(30);
        tree.insert(5);
        tree.insert(15);
        tree.insert(25);
        tree.insert(35);

        System.out.println("Inorder traversal before deletion:");
        tree.inorder(); 

        tree.delete(30); 

        System.out.println("Inorder traversal after deletion:");
        tree.inorder();
    }
}
