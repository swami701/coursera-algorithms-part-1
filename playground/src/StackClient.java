import Common.Node;

class LinkedStack {
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

class ArrayStack {
    private String[] arrStrings;
    private int endPtr = -1;

    public ArrayStack(int size) {
        arrStrings = new String[size];
    }

    public void push(String newItem) {
        if (arrStrings.length > 0) {
            arrStrings[++endPtr] = newItem;
            System.out.println("Pushed Element: " + newItem);
        } else {
            System.out.println("Size of the stack is Zero!");
        }
    }

    public String pop() {
        if (isEmpty())
            return null;
        String res = arrStrings[endPtr];
        System.out.println("Popped Element: " + res);
        arrStrings[endPtr--] = null;
        return res;
    }

    public String peek() {
        String res;
        if (isEmpty()) {
            res = null;
        } else {
            res = arrStrings[endPtr];
        }
        System.out.println("Peek: " + res);
        return res;
    }

    public int size() {
        System.out.println("Size: " + (endPtr + 1));
        return endPtr + 1;
    }

    public boolean isEmpty() {
        boolean res = arrStrings.length == 0 || endPtr < 0;
        System.out.println("isEmpty: " + res);
        return res;
    }

    public void print() {
        System.out.println();
        for (int i = endPtr; i >= 0; i--) {
            System.out.print("\t" + arrStrings[i]);
        }
        System.out.println();
    }
}

public class StackClient {
    public static void main(String[] args) {
        System.out.println("------ LinkedList based Stack --------");
        LinkedStack linkedStack = new LinkedStack();
        linkedStack.isEmpty();
        linkedStack.peek();
        linkedStack.pop();
        linkedStack.size();
        linkedStack.push("5");
        linkedStack.push("6");
        linkedStack.push("7");
        linkedStack.print();
        linkedStack.size();
        linkedStack.pop();
        linkedStack.print();
        linkedStack.size();
        linkedStack.peek();
        linkedStack.push("4");
        linkedStack.size();
        linkedStack.print();

        System.out.println("------ Array based Stack --------");
        ArrayStack arrayStack = new ArrayStack(10);
        arrayStack.isEmpty();
        arrayStack.peek();
        arrayStack.pop();
        arrayStack.size();
        arrayStack.push("5");
        arrayStack.push("6");
        arrayStack.push("7");
        arrayStack.print();
        arrayStack.size();
        arrayStack.pop();
        arrayStack.print();
        arrayStack.size();
        arrayStack.peek();
        arrayStack.push("4");
        arrayStack.size();
        arrayStack.print();
    }
}