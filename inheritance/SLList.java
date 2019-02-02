/** Singly-linked list implementation. */
public class SLList<Item> {
    private class Node {
        private Item item;
        private Node next;

        private Node(Item x, Node n) {
            item = x;
            next = n;
        }
    }

    private Node sentinel;
    private int size;

    /** Creates an empty list. */
    public SLList() {
        size = 0;
        sentinel = new Node(null, null);
    }

    /** Creates a list containing the item x. */
    public SLList(Item x) {
        size = 1;
        sentinel = new Node(null, null);
        sentinel.next = new Node(x, null);
    }

    /** Adds an item of the front. */
    public void addFirst(Item x) {
        Node oldFrontNode = sentinel.next;
        Node newNode = new Node(x, oldFrontNode);
        sentinel.next = newNode;
        size += 1;
    }

    /** Gets the front item of the list. */
    public Item getFirst() {
        return sentinel.next.item;
    }

    /** Puts an item at the back of the list. */
    public void addLast(Item x) {
        size += 1;

        Node p = sentinel;

        while (p.next != null) {
            p = p.next;
        }

        p.next = new Node(x, null);
    }

    /** Returns the back node of our list. */
    private Node getLastNode() {
        Node p = sentinel;

        while (p.next != null) {
            p = p.next;
        }
        return p;
    }

    /** Returns last item */
    public Item getLast() {
        Node back = getLastNode();
        return back.item;
    }

    /** Deletes and returns last item. */
    public Item removeLast() {
        Node back = getLastNode();
        if (back == sentinel) {
            return null;
        }

        Node p = sentinel;

        while (p.next != back) {
            p = p.next;
        }
        p.next = null;
        return back.item;
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Gets the item at the given index of the list. */
    public Item get(int index) {
        if (index == 0) {
            return getFirst();
        }
        Node currentNode = sentinel.next.next;
        while (index > 1 && currentNode.next != null) {
            index -= 1;
            currentNode = currentNode.next;
        }

        return currentNode.item;
    }

    /** Inserts item into given index. */
    public void insert(Item x, int index) {
        if (sentinel.next == null || index == 0) {
            addFirst(x);
            return;
        }

        Node currentNode = sentinel.next.next;
        while (index > 1 && currentNode.next != null) {
            index -= 1;
            currentNode = currentNode.next;
        }

        Node newNode = new Node(x, currentNode.next);
        currentNode.next = newNode;
    }

    /** Prints the list. */
    public void print() {
        for (Node p = sentinel.next; p != null; p = p.next) {
            System.out.print(p.item + " ");
        }
    }
}
