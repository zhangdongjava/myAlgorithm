package binaryTree;

import java.util.*;

/**二叉树 小的在左边 大于等于在右边
 * Created by dell_2 on 2016/8/6.
 */
public class BinaryTree<E extends Comparable> {

    private Node<E> root;

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



    public void insert(E e){
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
                        break;
                    }
                    c = c.left;
                }else{
                    if(c.right==null){
                        c.right = node;
                        break;
                    }
                    c = c.right;
                }
            }
        }
    }




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


    public Set<E> toSet(){
        Set<E> s = new HashSet<>();
        toSet(root,0,s);
        return s;
    }

    public List<E> toList(){
        List<E> s = new LinkedList<>();
        toSet(root,0,s);
        return s;
    }

    public void toSet(Node<E> node,int lev,Collection<E> set){
        lev ++;
        if(node ==null)return;
        toSet(node.left,lev,set);
        set.add(node.value);
        toSet(node.right,lev,set);
    }
}
