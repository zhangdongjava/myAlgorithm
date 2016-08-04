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
     * @param value
     */
    public void add(Integer value){
        Link link = new Link(value,null,null);
        if(first==null){
            first = link;
        }else{
            link.prev = last;
            last.next = link;
        }
        last = link;
    }

    /**
     * 添加第一个
     * @param value
     */
    public void addFirst(Integer value){
        Link link = new Link(value,first,null);
        if(first !=null){
            first.prev = link;

        }else{
            last = link;
        }
        first = link;
    }

    /**
     * 添加最后一个
     * @param value
     */
    public void addLast(Integer value){
       add(value);
    }

    /**
     * 向下迭代输出
     */
    public void displayNext(){
        Link c = first;
        while(c!=null){
            System.out.print(c.value+" ");
            c = c.next;
        }
        System.out.println();
    }
    /**
     * 向上迭代输出
     */
    public void displayPrev(){
        Link c = last;
        while(c!=null){
            System.out.print(c.value+" ");
            c = c.prev;
        }
        System.out.println();
    }

    /**
     * 删除第一个
     * @return
     */
    public Integer removeFirst(){
        if(first==null)return null;
        Integer v = first.value;
        first = first.next;
        first.prev = null;
        return v;
    }

    /**
     * 删除最后一个
     * @return
     */
    public Integer removeLast(){
        if(last==null)return null;
        Integer v = last.value;
        last = last.prev;
        last.next = null;
        return v;
    }


    /**
     * 删除指定值
     * @param value
     */
    public void remove(Integer value){
        Link c = last;
        while(c!=null){
            if(c.value == value){
                //第一个
                if(c.prev==null){
                    removeFirst();
                }else if(c.next==null){//最后一个
                    removeLast();
                }else{
                    c.prev.next = c.next;
                    c.next.prev = c.prev;
                }
            }
            c = c.prev;
        }
    }



    public static void main(String[] args) {
        DoublyLinked linked = new DoublyLinked();
        linked.removeLast();
        linked.removeFirst();
        linked.addFirst(1);
        linked.addFirst(2);
        linked.addFirst(3);
        linked.removeFirst();
        linked.displayNext();
        linked.displayPrev();
    }

}
