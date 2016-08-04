import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 双向链表
 * Created by dell_2 on 2016/8/4.
 */
public class DoublyLinked {

    private class Link {

        public Integer value;

        public Link next;

        public Link prev;

        public Link(Integer value, Link next, Link prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }


    private Link first;

    private Link last;

    /**
     * 添加
     *
     * @param value
     */
    public void add(Integer value) {
        Link link = new Link(value, null, null);
        if (first == null) {
            first = link;
        } else {
            link.prev = last;
            last.next = link;
        }
        last = link;
    }

    /**
     * 添加第一个
     *
     * @param value
     */
    public void addFirst(Integer value) {
        Link link = new Link(value, first, null);
        if (first != null) {
            first.prev = link;

        } else {
            last = link;
        }
        first = link;
    }

    /**
     * 添加最后一个
     *
     * @param value
     */
    public void addLast(Integer value) {
        add(value);
    }

    /**
     * 向下迭代输出
     */
    public void displayNext() {
        Link c = first;
        while (c != null) {
            System.out.print(c.value + " ");
            c = c.next;
        }
        System.out.println();
    }

    /**
     * 向上迭代输出
     */
    public void displayPrev() {
        Link c = last;
        while (c != null) {
            System.out.print(c.value + " ");
            c = c.prev;
        }
        System.out.println();
    }

    /**
     * 删除第一个
     *
     * @return
     */
    public Integer removeFirst() {
        if (first == null) return null;
        Integer v = first.value;
        first = first.next;
        first.prev = null;
        return v;
    }

    /**
     * 删除最后一个
     *
     * @return
     */
    public Integer removeLast() {
        if (last == null) return null;
        Integer v = last.value;
        last = last.prev;
        last.next = null;
        return v;
    }


    /**
     * 删除指定值
     *
     * @param value
     */
    public void remove(Integer value) {
        Link c = last;
        while (c != null) {
            if (c.value == value) {
                //第一个
                if (c.prev == null) {
                    removeFirst();
                } else if (c.next == null) {//最后一个
                    removeLast();
                } else {
                    c.prev.next = c.next;
                    c.next.prev = c.prev;
                }
            }
            c = c.prev;
        }
    }

    public MyIteratot getIteratot() {
        return new MyIteratot();
    }

    /**
     * 迭代器
     */
    private class MyIteratot {

        Link current = null;

        public void remove() {
            if (current == null) return;
            if (current == first) removeFirst();
            if (current == last) removeLast();
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }

        public boolean hasNext() {
            if (current == null) {
                return first != null;
            }
            return current.next != null;
        }

        public Integer next() {
            if (current == null) {
                current = first;
            } else {
                current = current.next;
            }
            return current.value;
        }

        /**
         * 插入当前迭代后面
         * @param v
         */
        public void insertAfter(Integer v){
            if(current==null)return;
            if(current==last){
                addLast(v);
            }
            else{
                Link l = new Link(v,current.next,current);
                current.next.prev = l;
                current.next = l;
            }

        }

        /**
         * 插入当前迭代前面
         * @param v
         */
        public void insertBefore(Integer v){
            if(current==null)return;
            if(current==first){
                addFirst(v);
            }
            else{
                Link l = new Link(v,current,current.prev);
                current.prev.next = l;
                current.prev = l;
            }

        }
    }


    public static void main(String[] args) throws NoSuchMethodException {
        DoublyLinked linked = new DoublyLinked();
        linked.add(1);
        linked.add(2);
        linked.add(3);
        linked.add(4);
        MyIteratot it = linked.getIteratot();
        while (it.hasNext()) {
            Integer v = it.next();
            if (v == 3) {
                it.insertBefore(6);
            }
        }
        linked.displayNext();
    }

}
