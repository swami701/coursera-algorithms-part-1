import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public int getRank(int key) {
        if (root == null) return -1;
        return getRank(root, key, getSize(root));

    }

    private int getRank(Node current, int key, int incomingRank) {
        if (current == null) return -1;
        int currentRank = incomingRank - getSize(current.right);
        if (key == current.key) return currentRank;
        else if (key > current.key) return getRank(current.right, key, currentRank + getSize(current.right));
        else return getRank(current.left, key, currentRank - 1);
    }

    public Node getNthRank(int queryRank) {
        if (root == null) return null;
        if (queryRank < 1 || queryRank > getSize(root)) return null;
        return getNthRank(root, getSize(root), queryRank);
    }

    private Node getNthRank(Node current, int incomingRank, int queryRank) {
        if (current == null) return null; // Not possible
        int currentRank = incomingRank - getSize(current.right);
        if (currentRank == queryRank) {
            return current;
        } else if (currentRank < queryRank) {
            return getNthRank(current.right, currentRank + getSize(current.right), queryRank);
        } else {
            return getNthRank(current.left, currentRank - 1, queryRank);
        }
    }

    public int getRangeCount(int lowKey, int highKey) {
        Node lowNode = ceil(lowKey);
        Node highNode = floor(highKey);
        return getRank(highNode.key) - getRank(lowNode.key) + 1;
    }

    public int[] getNodesBetween(int lowKey, int highKey) {
        Node lowNode = ceil(lowKey);
        Node highNode = floor(highKey);

        int lowRank = getRank(lowNode.key);
        int highRank = getRank(highNode.key);

        int[] nodeKeys = new int[highRank - lowRank + 1];
        for (int i = lowRank, j = 0; i <= highRank; nodeKeys[j] = getNthRank(i).key, j++, i++) ;
        return nodeKeys;
    }

    public int[] getNodesBetweenV2(int lowKey, int highKey) {
        List<Node> nodeList = new ArrayList<>();
        getNodesBetweenV2(lowKey, highKey, root, nodeList);
        return nodeList.stream().mapToInt(obj -> obj.key).toArray();
    }

    public void getNodesBetweenV2(int lowKey, int highKey, Node currentNode, List<Node> result) {
        if (currentNode == null) return;

        if (isKeyBetween(currentNode.key, lowKey, highKey)) {
            result.add(currentNode);
            getNodesBetweenV2(lowKey, highKey, currentNode.left, result);
            getNodesBetweenV2(lowKey, highKey, currentNode.right, result);
        } else if (currentNode.key < lowKey) {
            getNodesBetweenV2(lowKey, highKey, currentNode.right, result);
        } else {
            getNodesBetweenV2(lowKey, highKey, currentNode.left, result);
        }
    }

    private boolean isKeyBetween(int givenKey, int lowKey, int highKey) {
        return givenKey >= lowKey && givenKey <= highKey;
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
        System.out.println("Rank of 9: " + bst.getRank(9));
        System.out.println("Rank of 6: " + bst.getRank(6));
        System.out.println("Rank of 8: " + bst.getRank(8));
        System.out.println("Rank of 3: " + bst.getRank(3));
        System.out.println("Rank of 5: " + bst.getRank(5));
        System.out.println("Rank of 7: " + bst.getRank(7));
        System.out.println("Rank of 12: " + bst.getRank(12));
        System.out.println("Rank of 10: " + bst.getRank(10));

        // Get Nth Rank
        System.out.println("Nth Rank of 1: " + bst.getNthRank(1));
        System.out.println("Nth Rank of 2: " + bst.getNthRank(2));
        System.out.println("Nth Rank of 3: " + bst.getNthRank(3));
        System.out.println("Nth Rank of 4: " + bst.getNthRank(4));
        System.out.println("Nth Rank of 5: " + bst.getNthRank(5));
        System.out.println("Nth Rank of 6: " + bst.getNthRank(6));
        System.out.println("Nth Rank of 7: " + bst.getNthRank(7));
        System.out.println("Nth Rank of 0: " + bst.getNthRank(8));

        // Get Range Count
        System.out.println("Range count between 7 and 9: " + bst.getRangeCount(7, 9));
        System.out.println("Range count between 6 and 9: " + bst.getRangeCount(6, 9));
        System.out.println("Range count between 6 and 10: " + bst.getRangeCount(6, 10));

        // Get Nodes between two range
        System.out.println("Nodes between 7 and 9: " + Arrays.toString(bst.getNodesBetween(7, 9)));
        System.out.println("Nodes between 6 and 9: " + Arrays.toString(bst.getNodesBetween(6, 9)));
        System.out.println("Nodes between 6 and 10: " + Arrays.toString(bst.getNodesBetween(6, 10)));

        // Get Nodes between two range - V2
        System.out.println("V2 - Nodes between 7 and 9: " + Arrays.toString(bst.getNodesBetweenV2(7, 9)));
        System.out.println("V2 - Nodes between 6 and 9: " + Arrays.toString(bst.getNodesBetweenV2(6, 9)));
        System.out.println("V2 - Nodes between 6 and 10: " + Arrays.toString(bst.getNodesBetweenV2(6, 10)));

    }
}

/*
            9
         /      \
       5         12
     /   \     /    \
    3     7   10

 */
