package binaryTree;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dell_2 on 2016/8/6.
 */
public class TreeMap<K, V> {
    private BinaryTree<Entry<K, V>> b = new BinaryTree<>();

    public TreeMap<K, V> put(K key, V val) {
        Entry<K, V> e = new Entry(key, val);
        Node<Entry<K, V>> n = b.get(e);
        if (n != null) {//存在改变值
            n.value.setValue(val);
        } else {
            b.add(e);
        }

        return this;
    }

    public V get(K key) {
        Entry<K, V> e = new Entry<>(key, null);
        Node<Entry<K, V>> n = b.get(e);
        return n == null ? null : n.value.getValue();
    }

    public void remove(K key) {
        Entry<K, V> e = new Entry<>(key, null);
        b.remove(e);
    }

    public Set<Entry<K, V>> entrySet() {
        return b.toSet();
    }
}
