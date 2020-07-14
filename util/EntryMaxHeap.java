package util;

public class EntryMaxHeap implements Comparable<EntryMaxHeap> {
    private int key;
    private int value;

    public EntryMaxHeap(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(EntryMaxHeap other) {
        return other.getKey() - this.getKey();
    }
}