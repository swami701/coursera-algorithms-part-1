package Common;

class LinkedListQueue implements IQueue {
    private Node rootNode;
    private Node endNode;

    @Override
    public void enqueue(String item) {
        Node newNode = new Node();
        newNode.value = item;
        if (isEmpty()) {
            rootNode = newNode;
            endNode = newNode;
        } else {
            endNode.nextNode = newNode;
            endNode = newNode;
        }
        System.out.println("Enqueued: " + item);
    }

    @Override
    public String dequeue() {
        String res;
        if (isEmpty()) {
            endNode = null;
            res = null;
        } else {
            Node currNode = rootNode;
            res = currNode.value;
            rootNode = rootNode.nextNode;
            currNode = null;
        }
        System.out.println("Dequeue: " + res);
        return res;
    }

    @Override
    public boolean isEmpty() {
        System.out.println("isEmpty: " + (rootNode == null));
        return rootNode == null;
    }

    @Override
    public String peek() {
        String res = isEmpty() ? null : rootNode.value;
        System.out.println("Peek: " + res);
        return res;
    }

    @Override
    public void print() {
        System.out.println("Print values");
        for (Node currNode = rootNode; currNode != null; currNode = currNode.nextNode) {
            System.out.print("\t" + currNode.value);
        }
        System.out.println();
    }

    @Override
    public int size() {
        int res = 0;
        for (Node currNode = rootNode; currNode != null; res++, currNode = currNode.nextNode)
            ;
        System.out.println("Size: " + res);
        return res;
    }
}
