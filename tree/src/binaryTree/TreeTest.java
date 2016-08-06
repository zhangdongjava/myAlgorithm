package binaryTree;

/**
 * 测试二叉树类
 * Created by dell_2 on 2016/8/6.
 */
public class TreeTest {

    public static void main(String[] args) {
        TreeMap<String, String> tm = new TreeMap<>();
        tm.put("1", "11");
        tm.put("2", "22");
        tm.put("3", "33");
        tm.put("4", "44");
        tm.put("5", "55");
        tm.put("6", "66");
        tm.put("7", "77");
        tm.put("1", "1");
        tm.put("3","2");
        tm.put("3","2");
        tm.put("3","2");
        tm.put("3","2");
        for (Entry<String, String> stringStringEntry : tm.entrySet()) {
            System.out.println(stringStringEntry);
        }
    }
}
