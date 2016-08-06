package binaryTree;

/**
 *二叉树节点
 * Created by dell_2 on 2016/8/6.
 */
public class Node<N> {

    public N value;
    public Node left;//左子节点
    public Node right;//右子节点


    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
