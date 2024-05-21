package Common;

public interface IQueue<Item> {
    public void enqueue(Item item);

    public Item dequeue();

    public boolean isEmpty();

    public Item peek();

    public int size();

    public void print();
}
