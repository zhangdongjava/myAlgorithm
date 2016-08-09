package binaryTree;

import java.util.*;

/**二叉树 小的在左边 大于等于在右边
 * 链表表示
 * Created by dell_2 on 2016/8/6.
 */
public class BinaryTree<E extends Comparable> {

    private Node<E> root;

    /**
     * 值长度
     */
    private Integer valueLen = 4;
    /**
     * 节点连线2行间的x距离
     */
    private Integer lineSpace = valueLen>>2;

    public Node<E> get(Object key){
        Node<E> c = root;
        while(c!=null){
            //c的key比他大 说明他实在c的左子节点那边
            if(c.value.compareTo(key)>0){
                c = c.left;
            }else{
                if(c.value.compareTo(key)==0)
                    return c;
                c = c.right;
            }
        }
        return null;
    }



    public boolean add(E e){
        Node<E> node = new Node();
        node.value = e;
        if(root==null){
            root = node;
        }else{
            Node<E> c = root;
            while(c!=null){
                //c的key比他大 说明他实在c的左子节点那边
                if(c.value.compareTo(e)>0){
                    if(c.left==null){
                        c.left = node;
                        node.parent =c;
                        break;
                    }
                    c = c.left;
                }else{
                    if(c.right==null){
                        c.right = node;
                        node.parent =c;
                        break;
                    }
                    c = c.right;
                }
            }
        }
        return true;
    }


    /**
     * 删除一个节点
     * @param e
     */
    public void remove(E e){
        Node<E> c = root;
        Node<E> parent = null;
        Integer flag = 0;//1左 2 右
        while(c!=null){
            //c的key比他大 说明他在c的左子节点那边
            if(c.value.compareTo(e)>0){
                parent = c;
                c = c.left;
                flag = 1;
            }else if(c.value.compareTo(e)==0){
                remove(parent,c,flag);
                break;
            }else{
                parent = c;
                c = c.right;
                flag = 2;
            }
        }
    }


    /**
     * 删除一个节点
     * @param parent 删除节点父节点
     * @param c 删除的节点
     * @param flag 删除节点在父节的位置 1 左 2 右
     */
    private void remove(Node parent, Node c,Integer flag){
        if(c.left==null && c.right ==null){
            deleteNoChildNode(parent,flag);
        }else if(c.left==null || c.right ==null){
            deleteOneChildNode(parent,c,flag);
        }else{
            deleteTwoChildNode(parent,c,flag);
        }
    }




    /**
     * 删除没有子节点的节点
     * @param parent
     * @param flag
     */
    private void deleteNoChildNode(Node parent,Integer flag){
        if(parent==null){
            root = null;
        }else if(flag==1){
            parent.left = null;
        }else if(flag==2){
            parent.right = null;
        }
    }

    /**
     * 删除只有一个子节点的节点
     * @param parent
     * @param flag
     */
    private void deleteOneChildNode(Node parent,Node c,Integer flag){
        //获取要删除节点唯一的子节点
        Node childNode = c.left==null? c.right:c.left;
        if(parent==null){//当前节点是root节点
            root = childNode;
        }else if(flag==1){//当前节点在父节点左边
            parent.left = childNode;
        }else if(flag==2){//当前节点在父节点右边边
            parent.right = childNode;
        }

    }

    /**
     * 删除二个子节点的节点
     * @param parent
     * @param flag
     */
    private void deleteTwoChildNode(Node parent,Node c,Integer flag){
        //获取要删除节点的后继节点
       Node successor =  getSuccessor(c);
        if(parent==null){//当前节点是root节点
            root = successor;
        }else if(flag==1){//当前节点在父节点左边
            parent.left = successor;
        }else if(flag==2){//当前节点在父节点右边边
            parent.right = successor;
        }
        successor.left = c.left;
    }

    /**
     * 寻找后继节点 就是比curr大的最小节点
     * @param curr
     * @return
     */
    private Node getSuccessor(Node curr){
        Node c  = curr.right;
        Node successor = curr.right;
        Node parent = curr;
        while(c!=null){
            parent = successor;
            successor = c;
            c = c.left;
        }
        //后继节点不是删除节点的右节点 需要安排好后继节点的右子节点(就是放到后继节点父节点的左边)
        //安排好删除节点的右边节点( 删除节点的右就是后继节点的右)
        //删除节点左边后面安排
        if(successor != curr.right){
            parent.left =   successor.right;
            successor.right = curr.right;
        }

        return successor;
    }


    /**
     * 转list结集合
     * @return
     */
    public List<E> toList(){
        List<E> s = new LinkedList<>();
        toCollection(root,0,s);
        return s;
    }

    public void toCollection(Node<E> node,int lev,Collection<E> set){
        lev ++;
        if(node ==null)return;
        toCollection(node.left,lev,set);
        set.add(node.value);
        toCollection(node.right,lev,set);
    }

    private int minX=0;
    private int minY=0;
    private int maxX=0;
    private int maxY=0;
    private Map<String,Object> map = new HashMap<>();
    /**
     * 打印树结构
     *  采用坐标方法 先构建出map
     * @return
     */
    public void disPlay(){
        buildMap(root,0,0);
        printMap();
    }


    /**
     * 打印构建的map
     *
     */
    private void printMap(){
        for (int y = maxY ; y >= minY; y--) {
            Set<Integer> currLine = new HashSet<>();
            Map<String,Boolean> m = new HashMap<>();
            for (int x = minX; x <= maxX; x++) {
                String key = x+","+y;
                Object v = map.get(key);
                if(map.containsKey(key+"left")){
                    currLine.add(x);
                    m.put(x+"left",true);
                }
                if(map.containsKey(key+"right")){
                    currLine.add(x);
                    m.put(x+"right",true);
                }
                if(v==null)v=" ";
                v =  buildValueLen(v.toString());
                System.out.print(v);
            }
            System.out.println();
            StringBuffer line1 = getLine(maxX-minX+1);
            StringBuffer line2 = getLine(maxX-minX+1);
            StringBuffer line3 = getLine(maxX-minX+1);
            for (Integer x : currLine) {
                if(m.containsKey(x+"left")){
                    line1.setCharAt((x-minX)*valueLen-lineSpace,'*');
                    line2.setCharAt((x-minX)*valueLen-lineSpace-lineSpace,'*');
                    line3.setCharAt((x-minX)*valueLen-lineSpace-lineSpace-lineSpace,'*');
                }
                if(m.containsKey(x+"right")){
                    line1.setCharAt((x-minX)*valueLen+lineSpace,'*');
                    line2.setCharAt((x-minX)*valueLen+lineSpace+lineSpace,'*');
                    line3.setCharAt((x-minX)*valueLen+lineSpace+lineSpace+lineSpace,'*');
                }

            }
            System.out.println(line1.toString());
            System.out.println(line2.toString());
            System.out.println(line3.toString());

        }
    }

    private String buildValueLen(String val){
        StringBuffer buffer = new StringBuffer(val);
        int len = val.length();
        for (; len < valueLen; len++) {
            buffer.append(" ");

        }
        return buffer.toString();
    }

    private StringBuffer getLine(int len){
        StringBuffer line1 = new StringBuffer("");
        for (int i = 0; i < len*valueLen; i++) {
            line1.append(" ");

        }
        return line1;
    }

    /**
     * 计算节点的xy
     * @param node 当前节点
     * @param x 当前节点的x轴
     * @param y 当前节点 y轴
     */
    private void buildMap(Node<E> node,int x,int y){
        if(minX>x)minX = x;
        if(maxX<x)maxX = x;
        if(minY>y)minY = y;
        if(maxY<y)maxY = y;
        if(node ==null)return;
        if(node.left!=null){
            map.put(x+","+y+"left",true);
        }
        if(node.right!=null){
            map.put(x+","+y+"right",true);
        }
        buildMap(node.left,x-1,y-1);
        map.put(x+","+y,node.value);
        buildMap(node.right,x+1,y-1);
    }

    public static void main(String[] args) {
        double a= 0.0/0.0;
        System.out.println(a==a);
        BinaryTree<Integer> br = new BinaryTree<>();
        br.add(511);
        br.add(532);
        br.add(5432);
        br.add(545);
        br.add(6);
        br.add(2534);
        br.add(4543);
        br.add(1);
        br.add(7543);
        br.add(3);
        br.add(9);
        br.disPlay();
    }
}
