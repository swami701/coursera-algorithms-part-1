import java.util.LinkedList;
import java.util.Queue;

class MinPQ {
    private final int[] arr;
    private int ptr = 0;

    public MinPQ(int size) {
        arr = new int[size + 1];
    }

    public void add(int element) {
        System.out.println("Add element: " + element);
        if (ptr >= arr.length - 1) {
            System.out.println("Array overflow");
            return;
        }
        arr[++ptr] = element;
        swim();
    }

    public int pop() {
        if (ptr < 1) {
            System.out.println("Error, empty PQ");
            return -1;
        }

        int element = arr[1];
        arr[1] = arr[ptr--];
        sink();
        System.out.println("pop element: " + element);
        return element;
    }

    private void sink() {
        int i = 1;
        while (i <= ptr / 2) {
            int left = 2 * i, right = left + 1;
            if (less(left, i) || less(right, i)) {
                int min = less(left, right) ? left : right;
                exch(min, i);
                i = min;
            } else {
                break;
            }
        }
    }

    private void swim() {
        int i = ptr;
        while (i > 1) {
            if (less(i, i / 2)) {
                exch(i, i / 2);
                i = i / 2;
            } else {
                break;
            }
        }
    }

    private boolean less(int idx1, int idx2) {
        if (idx1 > ptr || idx2 > ptr)
            return idx1 < idx2;
        return arr[idx1] < arr[idx2];
    }

    private void exch(int srcIdx, int destIdx) {
        int element = arr[srcIdx];
        arr[srcIdx] = arr[destIdx];
        arr[destIdx] = element;
    }

    public void print() {
        System.out.println();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        recursivePrint(queue);
    }

    public void recursivePrint(Queue<Integer> queue) {
        System.out.println();
        if (queue.isEmpty()) {
            return;
        }
        System.out.println();
        int queueSize = queue.size();
        for (int i = 0; i < queueSize; i++) {
            int idx = queue.poll();
            if (idx > ptr)
                break;
            System.out.print("\t" + arr[idx]);
            if (idx * 2 <= ptr) {
                queue.offer(idx * 2);
            }
            if ((idx * 2) + 1 <= ptr) {
                queue.offer((idx * 2) + 1);
            }
        }
        recursivePrint(queue);
    }
}

public class MinHeapPQ {
    public static void main(String[] args) {
        MinPQ minPQ = new MinPQ(10);
        minPQ.add(3);
        minPQ.print();
        minPQ.add(4);
        minPQ.print();
        minPQ.add(5);
        minPQ.print();
        minPQ.add(7);
        minPQ.print();
        minPQ.add(2);
        minPQ.print();
        minPQ.add(1);
        minPQ.print();
        minPQ.pop();
        minPQ.print();
        minPQ.pop();
        minPQ.print();
        minPQ.add(6);
        minPQ.print();
        minPQ.add(8);
        minPQ.print();
        minPQ.add(1);
        minPQ.print();
        minPQ.add(2);
        minPQ.print();
        minPQ.add(10);
        minPQ.print();
        minPQ.add(11);
        minPQ.print();
        minPQ.add(12);
        minPQ.print();
    }
}

/**
 * 3
 * 4
 * 3
 * 4
 * 3 4
 * 
 */