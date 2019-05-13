import java.util.Arrays;

public class RedBlackBST {
    private class Node {
        int key;
        int value;
        int size;
        boolean isRed;
        Node left;
        Node right;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.size = 1;
            this.isRed = true;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    ", size=" + size +
                    ", isRed=" + isRed +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    private Node root;

    /*
        10----node
      /    \\
    5       12    --right
  /   \    /  \
         11    13

        ||
        \/

        12
      //   \
    10      13
  /   \    /  \
 5     11

        9
      // \\
    5     12

            12
          //
         9
        //
        5


    9  --c - ro
     \\
      12 - c.r - right
     /



 */

    private Node rotateLeft(Node node) {
        if (node == null || node.right == null) return node;
        Node right = node.right;
        Node rLeft = right.left;
        right.left = node;
        node.right = rLeft;
        right.isRed = false;
        node.isRed = true;

        return right;
    }


    /*
            10----node
          //   \
left -- 5       12
      /   \    /  \
     3     6

        ||
        \/

         5
      /   \\
    3      10
  /   \   /  \
         6    12


 */

    private Node rotateRight(Node node) {
        if (node == null || node.left == null) return node;
        Node left = node.left;
        Node lRight = left.right;
        node.left = lRight;
        left.right = node;
        node.isRed = true;
        left.isRed = false;
        return left;
    }

    private void flipColors(Node node) {
        if (node.left == null || node.right == null) {
            return;
        }
        node.left.isRed = false;
        node.right.isRed = false;
        node.isRed = true;
    }

    public boolean insert(int key, int val) {
        root = insert(key, val, root);
        return root != null;
    }

    private int getSize(Node node) {
        if (node == null) return 0;
        return node.size;
    }

    private Node insert(int key, int val, Node current) {
        if (current == null) {
            return new Node(key, val);
        }

        if (key == current.key) {
            current.value = val;
        } else if (key > current.key) {
            current.right = insert(key, val, current.right);
        } else {
            current.left = insert(key, val, current.left);
        }

        // Assigning Size
        current.size = 1 + getSize(current.left) + getSize(current.right);

        // Balancing the Tree (Black Balance)
        if (current.right != null && current.right.isRed) {
            current = rotateLeft(current);
        }

        if (current.left != null && current.left.isRed && current.left.left != null && current.left.left.isRed) {
            current = rotateRight(current);
        }

        if (current.left != null && current.left.isRed && current.right != null && current.right.isRed) {
            flipColors(current);
        }

        return current;
    }

    public Node getMin() {
        return getMin(root);
    }

    private Node getMin(Node current) {
        if (current == null) return null;
        if (current.left == null) return current;
        return getMin(current.left);
    }

    public Node getMax() {
        return getMax(root);
    }

    private Node getMax(Node current) {
        if (current == null) return null;
        if (current.right == null) return current;
        return getMax(current.right);
    }

    public int getRank(int key) {
        return getRank(key, root, getSize(root));
    }

    private int getRank(int key, Node current, int incomingRank) {
        if (current == null) return -1;
        int currentRank = incomingRank - getSize(current.right);
        if (key == current.key) {
            return currentRank;
        } else if (key > current.key) {
            return getRank(key, current.right, currentRank + getSize(current.right));
        } else {
            return getRank(key, current.left, currentRank - 1);
        }
    }

    public Node ceil(int key) {
        return ceil(key, root);
    }

    private Node ceil(int key, Node current) {
        if (current == null) return null;
        if (current.key == key) {
            return current;
        } else if (current.key > key) {
            if ((current.left != null && current.left.key > key)
                    || (current.left != null && current.left.right != null && current.left.right.key > key)
            ) {
                return ceil(key, current.left);
            } else {
                return current;
            }
        } else {
            return ceil(key, current.right);
        }
    }

    public Node floor(int key) {
        return floor(key, root);
    }

    private Node floor(int key, Node current) {
        if (current == null) return null;
        if (current.key == key) {
            return current;
        } else if (current.key < key) {
            if ((current.right != null && current.right.key < key)
                    || (current.right != null && current.right.left != null && current.right.left.key < key)
            ) {
                return floor(key, current.right);
            } else {
                return current;
            }
        } else {
            return floor(key, current.left);
        }
    }

    public Node getNthRank(int rank) {
        if (rank < 1 && rank > getSize(root)) return null;
        return getNthRank(rank, root, getSize(root));
    }

    private Node getNthRank(int queryRank, Node current, int incomingRank) {
        if (current == null) return null;
        int currentRank = incomingRank - getSize(current.right);
        if (queryRank == currentRank) {
            return current;
        } else if (queryRank > currentRank) {
            return getNthRank(queryRank, current.right, currentRank + getSize(current.right));
        } else {
            return getNthRank(queryRank, current.left, currentRank - 1);
        }
    }

    public int getRangeCount(int low, int high) {
        Node lNode = ceil(low);
        System.out.println("Ceil of " + low + " is :" + lNode.key);
        Node hNode = floor(high);
        return getRank(hNode.key) - getRank(lNode.key) + 1;
    }

    public Node[] getNodesBetween(int low, int high) {
        Node lNode = ceil(low);
        Node hNode = floor(high);
        int lRank = getRank(lNode.key);
        int hRank = getRank(hNode.key);
        Node[] nodes = new Node[hRank - lRank + 1];
        for (int i = lRank, j = 0; i <= hRank; i++) {
            nodes[j++] = getNthRank(i);
        }
        return nodes;
    }


    public static void main(String[] args) {
        System.out.println("Redblack BST");

        RedBlackBST redBlackBST = new RedBlackBST();
        System.out.println("Insert: 9 - " + redBlackBST.insert(9, 9));
        System.out.println("Insert: 5 - " + redBlackBST.insert(5, 5));
        System.out.println("Insert: 12 - " + redBlackBST.insert(12, 12));
        System.out.println("Insert: 3 - " + redBlackBST.insert(3, 3));
        System.out.println("Insert: 7 - " + redBlackBST.insert(7, 7));
        System.out.println("Insert: 10 - " + redBlackBST.insert(10, 10));

        System.out.println(redBlackBST.root);

        // Min
        System.out.println("Get Min: " + redBlackBST.getMin());

        // Max
        System.out.println("Get Max: " + redBlackBST.getMax());

        // Size
        System.out.println("Size of root: " + redBlackBST.getSize(redBlackBST.root));

        // Ceil
        System.out.println("Ceil of 4 : " + redBlackBST.ceil(4));
        System.out.println("Ceil of 8 : " + redBlackBST.ceil(8));
        System.out.println("Ceil of 10 : " + redBlackBST.ceil(10));

        // Floor
        System.out.println("Floor of 7: " + redBlackBST.floor(7));
        System.out.println("Floor of 6: " + redBlackBST.floor(6));
        System.out.println("Floor of 11: " + redBlackBST.floor(11));
        System.out.println("Floor of 9: " + redBlackBST.floor(9));

        // Rank
        System.out.println("Rank of 9: " + redBlackBST.getRank(9));
        System.out.println("Rank of 6: " + redBlackBST.getRank(6));
        System.out.println("Rank of 8: " + redBlackBST.getRank(8));
        System.out.println("Rank of 3: " + redBlackBST.getRank(3));
        System.out.println("Rank of 5: " + redBlackBST.getRank(5));
        System.out.println("Rank of 7: " + redBlackBST.getRank(7));
        System.out.println("Rank of 12: " + redBlackBST.getRank(12));
        System.out.println("Rank of 10: " + redBlackBST.getRank(10));

        // Get Nth Rank
        System.out.println("Nth Rank of 1: " + redBlackBST.getNthRank(1));
        System.out.println("Nth Rank of 2: " + redBlackBST.getNthRank(2));
        System.out.println("Nth Rank of 3: " + redBlackBST.getNthRank(3));
        System.out.println("Nth Rank of 4: " + redBlackBST.getNthRank(4));
        System.out.println("Nth Rank of 5: " + redBlackBST.getNthRank(5));
        System.out.println("Nth Rank of 6: " + redBlackBST.getNthRank(6));
        System.out.println("Nth Rank of 7: " + redBlackBST.getNthRank(7));
        System.out.println("Nth Rank of 0: " + redBlackBST.getNthRank(8));

        // Get Range Count
        System.out.println("Range count between 7 and 9: " + redBlackBST.getRangeCount(7, 9));
        System.out.println("Range count between 6 and 9: " + redBlackBST.getRangeCount(6, 9));
        System.out.println("Range count between 6 and 10: " + redBlackBST.getRangeCount(6, 10));

        // Get Nodes between two range
        System.out.println("Nodes between 7 and 9: " + Arrays.toString(redBlackBST.getNodesBetween(7, 9)));
        System.out.println("Nodes between 6 and 9: " + Arrays.toString(redBlackBST.getNodesBetween(6, 9)));
        System.out.println("Nodes between 6 and 10: " + Arrays.toString(redBlackBST.getNodesBetween(6, 10)));

    }
}

/*


 */
