import java.util.Arrays;

import java.util.stream.Collectors;

public class HeapMaxPQ<Item extends Comparable<Item>> implements MaxPQ<Item> {
    private Item[] items;
    private int size;

    public static void main(String[] args) {
        MaxPQ<TwitterTopic> trending = new HeapMaxPQ<>();
        trending.add(new TwitterTopic("@MichelleObama", 27));
        trending.add(new TwitterTopic("magnitude", 38));
        trending.add(new TwitterTopic("earthquake", 73));
        trending.add(new TwitterTopic("@iamcardib", 19));
        System.out.println("max: " + trending.max());
        System.out.println("removeMax: " + trending.removeMax());
        System.out.println("max: " + trending.max());
        System.out.println("removeMax: " + trending.removeMax());
        System.out.println("max: " + trending.max());
    }

    @SuppressWarnings("unchecked")
    public HeapMaxPQ() {
        items = (Item[]) new Comparable[100]; // no resizing
        size = 0;
    }

    public void add(Item x) {
        if (x == null) {
            throw new IllegalArgumentException("Cannot add null item");
        }
        items[size] = x;
        swim(size);
        size += 1;
    }

    public Item max() {
        return items[0];
    }

    public Item removeMax() {
        Item max = items[0];
        items[0] = items[size - 1];
        items[size - 1] = null;
        size -= 1;
        sink(0);
        return max;
    }

    public void swim(int i) {
        while (i > 0) {
            Item parent = items[parent(i)];
            if (gt(parent, items[i])) {
                return;
            } else {
                items[parent(i)] = items[i];
                items[i] = parent;
                i = parent(i);
            }
        }
    }

    public void sink(int i) {
        while (leftChild(i) < size) {
            Item left = items[leftChild(i)];
            Item right = null;
            if (rightChild(i) < size) {
                right = items[rightChild(i)];
            }
            if (gt(items[i], left) && gt(items[i], right)) {
                return;
            } else if (gt(left, right)) {
                items[leftChild(i)] = items[i];
                items[i] = left;
                i = leftChild(i);
            } else {
                items[rightChild(i)] = items[i];
                items[i] = right;
                i = rightChild(i);
            }
        }
    }

    private boolean gt(Item one, Item two) {
        if (one == null) {
            return false;
        } else if (two == null) {
            return true;
        } else {
            return one.compareTo(two) >= 0;
        }
    }

    public int parent(int i) {
        return (i - 1) / 2;
    }

    public int leftChild(int i) {
        return i * 2 + 1;
    }

    public int rightChild(int i) {
        return i * 2 + 2;
    }

    public int size() {
        return size;
    }

    public String toString() {
        return "{" +
            Arrays.stream(items).limit(size)
                                .map(Object::toString)
                                .collect(Collectors.joining(",\n "))
            + "}";
    }
}
