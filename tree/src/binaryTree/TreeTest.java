package binaryTree;

import java.util.Iterator;

/**
 * 测试二叉树类
 * Created by dell_2 on 2016/8/6.
 */
public class TreeTest {

    public static void main(String[] args) {
       BinaryTree<Integer> br = new BinaryTree<>();
        br.add(1);
        br.add(5);
        br.add(3);
        br.add(2);
        br.add(4);
        br.add(6);
        br.add(7);
        br.add(8);
        Iterator<Integer> it = br.iterator();
        while(it.hasNext()){
            Integer i = it.next();
            if(i>5)
                it.remove();
        }
        for (Integer integer : br) {
            System.out.println(integer);
        }
    }
}
