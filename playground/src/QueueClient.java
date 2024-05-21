import Common.Node;

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
