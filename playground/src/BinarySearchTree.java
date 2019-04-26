public class BinarySearchTree {
    public class Node {
        private int key;
        private int value;
        private int size;
        private Node left;
        private Node right;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    ", size=" + size +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    private Node root;

    public void preOrder(Node current) {
        if (current == null) return;
        System.out.println(current);
        preOrder(current.left);
        preOrder(current.right);
    }

    public boolean insert(int key, int val) {
        root = insert(root, key, val);
        return root != null;
    }

    private Node insert(Node current, int key, int val) {
        if (current == null) {
            return new Node(key, val);
        }
        if (key == current.key) {
            current.value = val;
        } else if (key > current.key) {
            current.right = insert(current.right, key, val);
        } else {
            current.left = insert(current.left, key, val);
        }
        return current;
    }

    private int sizeOfNode(Node node) {
        if (node == null) return 0;
        return 1 + sizeOfNode(node.left) + sizeOfNode(node.right);
    }

    public Node getMin() {
        if (root == null) return null;
        return getMin(root);
    }

    private Node getMin(Node node) {
        if (node.left == null) return node;
        return getMin(node.left);
    }

    public Node getMax() {
        if (root == null) return null;

        return getMax(root);
    }

    private Node getMax(Node node) {
        if (node.right == null) return node;
        return getMax(node.right);
    }

    public Node get(int val) {

        return null;
    }

    public Node ceil(int key) {
        return getCeil(key, root);
    }

    private Node getCeil(int key, Node current) {
        if (current == null) return null;
        if (current.key == key) return current;
        if (current.key > key) {
            if (current.left != null && current.left.key >= key) return getCeil(key, current.left);
            else return current;
        }
        return getCeil(key, current.right);
    }

    public Node floor(int val) {

        return null;
    }

    public int rank(int val) {

        return val;
    }

    public Node getNthRank(int val) {

        return null;
    }

    public static void main(String[] args) {
        System.out.println("Binary Search tree");
        BinarySearchTree bst = new BinarySearchTree();
        System.out.println("Insert: 7 - " + bst.insert(7, 7));
        System.out.println("Insert: 5 - " + bst.insert(5, 5));
        System.out.println("Insert: 9 - " + bst.insert(9, 9));
        System.out.println("Insert: 4 - " + bst.insert(4, 4));
        System.out.println("Insert: 6 - " + bst.insert(6, 6));

        System.out.println(bst.root);

        // Min
        System.out.println("Get Min: " + bst.getMin());

        // Max
        System.out.println("Get Max: " + bst.getMax());

        // Size
        System.out.println("Size of root: " + bst.sizeOfNode(bst.root));

        // Ceil
        System.out.println("Ceil of 4 : " + bst.ceil(4));
        System.out.println("Ceil of 10 : " + bst.ceil(10));
    }
}

/*
            7
          /   \
        5       9
      /   \   /   \
     4     6 8
 */
