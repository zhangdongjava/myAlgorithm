import java.util.*;

/**
 * 计算字符串算式的结果
 * Created by dell_2 on 2016/8/1.
 */
public class Test {

    static Map<Character, Integer> priority = new HashMap<>();

    public static void main(String[] args) {
        priority.put('+', 1);
        priority.put('-', 1);
        priority.put('*', 2);
        priority.put('/', 2);
        String res = afterExpression("2+3*6");
        expression(res);
    }

    /**
     * 计算结果
     *
     * @param expressionStr
     */
    public static void expression(String expressionStr) {
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < expressionStr.length(); i++) {
            list.add(expressionStr.charAt(i));
        }
        System.out.println(expression(list));
    }

    /**
     * 计算结果
     *
     * @param list
     * @return
     */
    public static int expression(LinkedList<Character> list) {
        Iterator<Character> it = list.iterator();
        Character i1 = null;
        Character i2 = null;
        Character character = null;
        while (it.hasNext()) {
            character = it.next();
            if (priority.containsKey(character)) {
                it.remove();
                break;
            }
            i2 = i1;
            i1 = character;
        }
        list.remove(i1);
        list.remove(i2);
        int s = expression(i1 - 48, i2 - 48, character);
        list.addFirst((char) (s + 48));
        if (list.size() == 1) {
            return list.get(0) - 48;
        }
        return expression(list);
    }

    /**
     * 计算结果
     *
     * @param i1
     * @param i2
     * @param character
     * @return
     */
    public static int expression(int i1, int i2, Character character) {
        int sum = 0;
        switch (character) {
            case '+':
                return i1 + i2;
            case '-':
                return i1 - i2;
            case '*':
                return i1 * i2;
            case '/':
                return i1 / i2;
        }
        return sum;
    }

    /**
     * 构建后表达式
     *
     * @param str
     * @return
     */
    public static String afterExpression(String str) {
        StringBuffer buffer = new StringBuffer(str);
        LinkedList<Character> list = new LinkedList<>();
        LinkedList<Character> symbol = new LinkedList<>();
        for (int i = 0; i < buffer.length(); i++) {
            list.add(buffer.charAt(i));
        }
        buffer = new StringBuffer();
        for (Character character : list) {
            if (character == ' ') continue;
            buildBufferAndsymbol(symbol, buffer, character);
        }
        for (Character character : symbol) {
            buffer.append(character);
        }
        return buffer.toString();
    }

    /**
     * 构建后表达式字符串和符号链表
     *
     * @param symbol
     * @param buffer
     * @param character
     */
    public static void buildBufferAndsymbol(LinkedList<Character> symbol, StringBuffer buffer, Character character) {
        if (priority.containsKey(character)) {
            Character c1 = getFirst(symbol);
            if (c1 != null) {
                //如果上一个是(说明这个符号比上一个符号优先级高 因为他在(里面
                if (c1 == '(') {
                    ;
                } else if (priority(c1, character)) {
                    buffer.append(c1);
                    removeFirst(symbol);
                }
                symbol.addFirst(character);

            } else {
                symbol.addFirst(character);
            }
        } else if (character == '(') {
            symbol.addFirst(character);
        } else if (character == ')') {
            buildLastLeftKhAndFirstFh(symbol, buffer);
        } else {
            buffer.append(character);
        }
    }

    /**
     * 判断优先级
     *
     * @param c1
     * @param c2
     * @return
     */
    public static boolean priority(Character c1, Character c2) {
        return priority.get(c1) >= priority.get(c2);
    }

    public static Character getFirst(LinkedList<Character> symbol) {
        try {
            return symbol.getFirst();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public static Character removeFirst(LinkedList<Character> symbol) {
        Character c = null;
        Iterator<Character> it = symbol.iterator();
        while (it.hasNext()) {
            Character character1 = it.next();
            if (priority.containsKey(character1)) {
                it.remove();
                return character1;
            }

        }
        return c;
    }

    /**
     * 添加最后个(和第一个符号 buffer 并删除这个符号和(
     */
    public static void buildLastLeftKhAndFirstFh(LinkedList<Character> symbol, StringBuffer buffer) {
        ListIterator<Character> it = symbol.listIterator();
        while (it.hasNext()) {
            Character character1 = it.next();
            if (character1 == '(') {
                it.remove();
                buffer.append(symbol.getFirst());
                break;
            }
        }
        symbol.removeFirst();
    }


}

















