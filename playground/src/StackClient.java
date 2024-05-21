import Common.ArrayStack;
import Common.LinkedStack;

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