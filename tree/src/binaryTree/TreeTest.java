package binaryTree;

/**
 * 测试二叉树类
 * Created by dell_2 on 2016/8/6.
 */
public class TreeTest {

    public static void main(String[] args) {
        BinaryTree<String,Integer> bt = new BinaryTree<>();
        bt.insert("8",8);
        bt.insert("8",88);
        bt.insert("3",3);
        bt.insert("5",5);
        bt.insert("2",2);
        bt.insert("10",10);
        System.out.println(bt.get("8"));
        bt.display();
    }
}
