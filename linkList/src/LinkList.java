/**
 * Created by dell_2 on 2016/8/3.
 */
public class LinkList {

    public Link first;

    public Link end;

    public void add(Integer value){
        Link newLink = new Link(value,first);
        if(first==null){
            first = newLink;
            end = newLink;
        }else{//要进行排序
            Link next = first;
            Link prev = null;
            //找到合适自己的位置并记录上一个和下一个
            while(next!=null&&next.value > value){
                prev = next;
                next = next.next;
            }
            //找到了链接到上一个和下一个中间
            if(prev!=null){
                prev.next = newLink;
                newLink.next = next;
            }else{//没有找到合适的位置说明最大 加到最后
                first = newLink;
            }
        }

    }

//    public void addFirst(Integer value){
//        first = new Link(value,first);
//    }

    public Integer deleteFirst(){
        Integer v = first.value;
        first = first.next;
        return v;
    }

    public void delete(Integer value){
        Link c = first;
        Link prev = null;
        while(c!=null){
            if(c.value == value){
                prev.next = c.next;
            }
            prev = c;
            c = c.next;
        }
    }

    public void display(){
        Link c = first;
        while(c!=null){
            System.out.print(c.value+" ");
            c = c.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkList list = new LinkList();
        list.add(10);
        list.add(3);
        list.add(6);
        list.add(9);
        list.add(12);
        list.display();
    }
}
