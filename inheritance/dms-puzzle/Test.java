public class Test {
    public static void main(String[] args) {
        Dog d = new Chihuahua();
        Chihuahua c = new Chihuahua();
        d.sniff(c);
        c.bark(c);
        d.bark(c);
    }
}
