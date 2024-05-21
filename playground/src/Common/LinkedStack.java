package Common;

public class LinkedStack {
    private Node root;

    public void push(String newItem) {
        if (root == null) {
            System.out.println("Root is null");
            root = new Node();
            root.value = newItem;
            root.nextNode = null;
        } else {
            System.out.println("Root is not null");
            Node newNode = new Node();
            newNode.value = newItem;
            newNode.nextNode = root;
            root = newNode;
        }
        System.out.println("Pushed Element: " + newItem);
    }

    public String pop() {
        if (isEmpty())
            return null;
        Node currNode = root;
        root = root.nextNode;
        String res = currNode.value;
        currNode = null;
        System.out.println("Popped Element: " + res);
        return res;
    }

    public String peek() {
        String res;
        if (isEmpty()) {
            res = null;
        } else {
            res = root.value;
        }
        System.out.println("Peek: " + res);
        return res;
    }

    public int size() {
        int res = 0;
        for (Node n = root; n != null; n = n.nextNode, res++)
            ;
        System.out.println("Size: " + res);
        return res;
    }

    public boolean isEmpty() {
        System.out.println("isEmpty: " + (root == null));
        return root == null;
    }

    public void print() {
        System.out.println();
        for (Node curNode = root; curNode != null; curNode = curNode.nextNode) {
            System.out.print("\t" + curNode.value);
        }
        System.out.println();
    }
}
