public class TwitterTopic implements Comparable<TwitterTopic> {
    String topic;
    int count;

    public TwitterTopic(String topic, int count) {
        this.topic = topic;
        this.count = count;
    }

    public int compareTo(TwitterTopic other) {
        return this.count - other.count;
    }

    public String toString() {
        return "TwitterTopic(\"" + topic + "\", " + count + ")";
    }
}
