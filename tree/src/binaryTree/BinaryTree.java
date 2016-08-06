package binaryTree;

/**二叉树
 * Created by dell_2 on 2016/8/6.
 */
public class BinaryTree<K> {

    private Node<Entry<K,Integer>> root;

    public Integer get(K key){
        //TODO
        return null;
    }

    public void insert(K key,Integer value){
        Entry<K,Integer> entry = new Entry<>(key,value);
        Node<Entry<K,Integer>> node = new Node();
        node.value = entry;
        if(root==null){
            root = node;
        }else{
            Node<Entry<K,Integer>> c = root;
            while(c!=null){
                //c的value比他大 说明他实在c的左子节点那边
                if(c.value.getValue()>value){
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




    public void remove(Integer value){
        Node<Entry<K,Integer>> c = root;
        Node<Entry<K,Integer>> parent = null;
        Integer flag = 0;//1左 2 右
        while(c!=null){
            //c的value比他大 说明他在c的左子节点那边
            if(c.value.getValue()>value){
                parent = c;
                c = c.left;
                flag = 1;
            }else if(c.value.getValue()==value){
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
        //获取要删除节点唯一的子节点
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

        if(successor != curr.right){
            parent.left =   successor.right;
            successor.right = curr.right;
        }

        return successor;
    }


    public void display(){
        display(root,0);
    }

    public void display(Node node,int lev){
        lev ++;
        if(node ==null)return;
        display(node.left,lev);
        System.out.println(lev+":"+node.value);
        display(node.right,lev);
    }
}
