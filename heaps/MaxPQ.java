public interface MaxPQ<Item extends Comparable<Item>> {
    public void add(Item x);
    public Item max();
    public Item removeMax();
    public int size();
}
