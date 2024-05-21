package Common;

class ArrayQueue<Item> implements IQueue<Item> {
    private Item[] arrQueue;
    private int start;
    private int end;

    public ArrayQueue() {
        arrQueue = (Item[]) new Object[1];
        end = -1;
    }

    @Override
    public void enqueue(Item item) {
        System.out.println("Enqueue: " + item);
        arrQueue[end + 1] = item;
        end++;
        resizeQueue();
    }

    private void resizeQueue() {
        if (end - start >= arrQueue.length / 2) {
            Item[] newArr = (Item[]) new Object[arrQueue.length * 2];
            for (int i = start, j = 0; i <= end; newArr[j] = arrQueue[i], i++, j++);
            end = end - start;
            start = 0;
            arrQueue = newArr;
        } else if (end > 0 && end - start < arrQueue.length / 4) {
            Item[] newArr = (Item[]) new Object[arrQueue.length / 2];
            for (int i = start, j = 0; i <= end; newArr[j] = arrQueue[i], i++, j++);
            end = end - start;
            start = 0;
            arrQueue = newArr;
        }
    }

    @Override
    public Item dequeue() {
        if (!isEmpty()) {
            Item res = arrQueue[start];
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
    public Item peek() {
        if (isEmpty()) {
            Item res = arrQueue[start];
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
