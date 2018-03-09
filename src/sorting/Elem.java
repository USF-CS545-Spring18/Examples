package sorting;

/** Represents an element in an array. Has key and data */
public class Elem {
    private int key;
    private Object data;

    public Elem(int key, Object data) {
        this.key = key;
        this.data = data;
    }

    public int key() {
        return key;
    }

    public Object data() {
        return data;
    }

    public String toString() {
        return key + " " + data + "; ";
    }
}

