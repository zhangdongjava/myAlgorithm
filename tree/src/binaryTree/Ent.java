package binaryTree;

/**
 * 一个节点存储对象
 * Created by dell_2 on 2016/8/6.
 */
public class Ent<K,V> {

    private K key;
    private V value;

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
