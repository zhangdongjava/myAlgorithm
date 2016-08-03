import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by dell_2 on 2016/7/22.
 */
public class StackDemo {


    public static void main(String[] args) {
        Stack<String> s = new Stack<>();
        Map<String,String> map = new HashMap<>();
        map.put("}","{");
        map.put("]","[");
        map.put(")","(");
        String str = "([()})";
        for (int i = 0; i < str.length(); i++) {
            String s1 = String.valueOf(str.charAt(i));
            switch (s1){
                case "{":
                case "[":
                case "(":
                    s.push(s1);
                    break;
                case "}":

                case "]":

                case ")":
                   String s2 = s.pop();
                    if(!s2.equals(map.get(s1))){
                        System.out.println("error "+s1 +" at " +i);
                    }


            }
        }
    }
}
