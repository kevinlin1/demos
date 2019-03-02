import java.util.LinkedList;

public class UnorderedLLMaxPQ<Item extends Comparable<Item>> implements MaxPQ<Item> {
    private LinkedList<Item> list;

    public UnorderedLLMaxPQ() {
        this.list = new LinkedList<>();
    }

    public void add(Item x) {
        this.list.add(x);
    }

    public Item max() {
        Item max = null;
        for (Item item : this.list) {
            if (max == null || item.compareTo(max) > 0) {
                max = item;
            }
        }
        return max;
    }

    public Item removeMax() {
        Item max = this.max();
        this.list.remove(max);
        return max;
    }

    public int size() {
        return this.list.size();
    }

    public static void main(String[] args) {
        MaxPQ<TwitterTopic> trending = new UnorderedLLMaxPQ<>();
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
}
