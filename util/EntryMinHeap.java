package util;

public class EntryMinHeap implements Comparable<EntryMinHeap> {
    private int key;
    private int value;

    public EntryMinHeap(int key, int value) {
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
    public int compareTo(EntryMinHeap other) {
        return this.getKey() - other.getKey();
    }
}