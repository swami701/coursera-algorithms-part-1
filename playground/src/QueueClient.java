import Common.Node;

interface IQueue {
    public void enqueue(String item);

    public String dequeue();

    public boolean isEmpty();

    public String peek();

    public int size();

    public void print();
}

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

class ArrayQueue implements IQueue {
    private String[] arrQueue;
    private int start;
    private int end;

    public ArrayQueue() {
        arrQueue = new String[1];
        end = -1;
    }

    @Override
    public void enqueue(String item) {
        System.out.println("Enqueue: " + item);
        arrQueue[end + 1] = item;
        end++;
        resizeQueue();
    }

    private void resizeQueue() {
        if (end - start >= arrQueue.length / 2) {
            String[] newArr = new String[arrQueue.length * 2];
            for (int i = start, j = 0; i <= end; newArr[j] = arrQueue[i], i++, j++);
            end = end - start;
            start = 0;
            arrQueue = newArr;
        } else if (end > 0 && end - start < arrQueue.length / 4) {
            String[] newArr = new String[arrQueue.length / 2];
            for (int i = start, j = 0; i <= end; newArr[j] = arrQueue[i], i++, j++);
            end = end - start;
            start = 0;
            arrQueue = newArr;
        }
    }

    @Override
    public String dequeue() {
        if (!isEmpty()) {
            String res = arrQueue[start];
            start++;
            System.out.println("Dequeue: " + res);
            if (start > end) {
                start = 0;
                end = -1;
            }
            resizeQueue();
            return res;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        boolean res = start > end;
        System.out.println("IsEmpty: " + res);
        return res;
    }

    @Override
    public String peek() {
        if (isEmpty()) {
            String res = arrQueue[start];
            System.out.println("Peek: " + res);
        }
        return null;
    }

    @Override
    public int size() {
        int res = (end - start) + 1;
        System.out.println("Size: " + res + " ArrLength: " + arrQueue.length);
        return res;
    }

    @Override
    public void print() {
        System.out.println("--- Print ---");
        for (int i = start; i <= end; i++) {
            System.out.print("\t" + arrQueue[i]);
        }
        System.out.println();
    }

}

public class QueueClient {
    public static void main(String[] args) {
        System.out.println("------ LinkedList based Queue --------");
        IQueue linkedQueue = new LinkedListQueue();
        linkedQueue.isEmpty();
        linkedQueue.peek();
        linkedQueue.dequeue();
        linkedQueue.size();
        linkedQueue.enqueue("5");
        linkedQueue.size();
        linkedQueue.enqueue("6");
        linkedQueue.size();
        linkedQueue.enqueue("7");
        linkedQueue.size();
        linkedQueue.enqueue("8");
        linkedQueue.size();
        linkedQueue.enqueue("9");
        linkedQueue.print();
        linkedQueue.size();
        linkedQueue.dequeue();
        linkedQueue.print();
        linkedQueue.size();
        linkedQueue.peek();
        linkedQueue.enqueue("4");
        linkedQueue.dequeue();
        linkedQueue.size();
        linkedQueue.dequeue();
        linkedQueue.size();
        linkedQueue.dequeue();
        linkedQueue.size();
        linkedQueue.dequeue();
        linkedQueue.size();
        linkedQueue.print();

        System.out.println("------ Array based Queue --------");
        IQueue arrQueue = new ArrayQueue();
        arrQueue.isEmpty();
        arrQueue.peek();
        arrQueue.dequeue();
        arrQueue.size();
        arrQueue.enqueue("5");
        arrQueue.size();
        arrQueue.enqueue("6");
        arrQueue.size();
        arrQueue.enqueue("7");
        arrQueue.size();
        arrQueue.enqueue("8");
        arrQueue.size();
        arrQueue.enqueue("9");
        arrQueue.print();
        arrQueue.size();
        arrQueue.dequeue();
        arrQueue.print();
        arrQueue.size();
        arrQueue.peek();
        arrQueue.enqueue("4");
        arrQueue.dequeue();
        arrQueue.size();
        arrQueue.dequeue();
        arrQueue.size();
        arrQueue.dequeue();
        arrQueue.size();
        arrQueue.dequeue();
        arrQueue.size();
        arrQueue.print();
    }
}
