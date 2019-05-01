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
            this.size = 1;
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
        current.size = 1 + getSize(current.left) + getSize(current.right);
        return current;
    }

    private int getSize(Node node) {
        if (node == null) return 0;
        return node.size;
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
            Node left = getCeil(key, current.left);
            return left == null ? current : left;
        }
        return getCeil(key, current.right);
    }

    public Node floor(int key) {
        return getFloor(key, root);
    }

    private Node getFloor(int key, Node current) {
        if (current == null) return null;
        if (current.key == key) return current;
        if (current.key < key) {
            Node right = getFloor(key, current.right);
            return right == null ? current : right;
        } else return getFloor(key, current.left);
    }

    public int rank(int key) {
        if (root == null) return -1;
        return getRank(root, key, getSize(root));
    }

    private int getRank(Node current, int key, int cRank) {
        if (current == null) return -1;
        int nRank = cRank - getSize(current.right);
        if (key == current.key) return nRank;
        else if (key > current.key) return getRank(current.right, key, nRank + getSize(current.right));
        else return getRank(current.left, key, nRank - 1);
    }

    public Node getNthRank(int rank) {
        if (root == null) return null;
        return getNthRank(root, rank);
    }

    private Node getNthRank(Node current, int rank) {
        if (current == null) return null;
        int rightRank = current.right == null ? 0 : current.right.size;
        int currentRank = rank - rightRank;
        if (currentRank == rank) {
            return current;
        } else if (currentRank < rank) {
            return getNthRank(current.right, currentRank + 1);
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println("Binary Search tree");
        BinarySearchTree bst = new BinarySearchTree();
        System.out.println("Insert: 9 - " + bst.insert(9, 9));
        System.out.println("Insert: 5 - " + bst.insert(5, 5));
        System.out.println("Insert: 12 - " + bst.insert(12, 12));
        System.out.println("Insert: 3 - " + bst.insert(3, 3));
        System.out.println("Insert: 7 - " + bst.insert(7, 7));
        System.out.println("Insert: 10 - " + bst.insert(10, 10));

        System.out.println(bst.root);

        // Min
        System.out.println("Get Min: " + bst.getMin());

        // Max
        System.out.println("Get Max: " + bst.getMax());

        // Size
        System.out.println("Size of root: " + bst.getSize(bst.root));

        // Ceil
        System.out.println("Ceil of 4 : " + bst.ceil(4));
        System.out.println("Ceil of 8 : " + bst.ceil(8));
        System.out.println("Ceil of 10 : " + bst.ceil(10));

        // Floor
        System.out.println("Floor of 7: " + bst.floor(7));
        System.out.println("Floor of 6: " + bst.floor(6));
        System.out.println("Floor of 1: " + bst.floor(11));
        System.out.println("Floor of 9: " + bst.floor(9));

        // Rank
        System.out.println("Rank of 9: "+bst.rank(9));
        System.out.println("Rank of 6: "+bst.rank(6));
        System.out.println("Rank of 8: "+bst.rank(8));
        System.out.println("Rank of 3: "+bst.rank(3));
        System.out.println("Rank of 5: "+bst.rank(5));
        System.out.println("Rank of 7: "+bst.rank(7));
        System.out.println("Rank of 12: "+bst.rank(12));
        System.out.println("Rank of 10: "+bst.rank(10));
    }
}

/*
            9
         /      \
       5         12
     /   \     /    \
    3     7   10

 */
