package binaryTree;

/**
 * 一个节点存储对象
 * Created by dell_2 on 2016/8/6.
 */
public class Entry<K,V> implements Comparable{

    private K key;
    private V value;

    private int hash;

    public int getHash() {
        return hash;
    }

    public void setHash(int hash) {
        this.hash = hash;
    }

    public Entry(K key, V value) {
        this.value = value;
        this.key = key;
        this.hash = key.hashCode();
    }

    public K getKey() {
        return key;
    }


    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if(!(o instanceof Entry)){
            throw new RuntimeException(o.getClass() +"not instanceof" +Entry.class );
        }
        Entry en = (Entry) o;
        return this.hash - en.hash;
    }
}
