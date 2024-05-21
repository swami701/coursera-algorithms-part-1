package Common;

public class ArrayStack<Item> {
    private Item[] arrStrings;
    private int endPtr = -1;

    public ArrayStack(int size) {
        arrStrings = (Item[]) new Object[size];
    }

    public void push(Item newItem) {
        if (arrStrings.length > 0) {
            arrStrings[++endPtr] = newItem;
            System.out.println("Pushed Element: " + newItem);
        } else {
            System.out.println("Size of the stack is Zero!");
        }
    }

    public Item pop() {
        if (isEmpty())
            return null;
        Item res = arrStrings[endPtr];
        System.out.println("Popped Element: " + res);
        arrStrings[endPtr--] = null;
        return res;
    }

    public Item peek() {
        Item res;
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
