package binaryTree;

/**
 *二叉树节点
 * Created by dell_2 on 2016/8/6.
 */
public class Node<N extends  Comparable> {

    public N value;
    public Node left;//左子节点
    public Node right;//右子节点
    public Node parent;
    public boolean isLeft = false;

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
