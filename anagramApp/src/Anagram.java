import java.util.Arrays;

/**
 * Created by dell_2 on 2016/8/4.
 */
public class Anagram {

    public static int count ;
    public static int size;
    public static char[] arr;

    public static void main(String[] args) {
        arr = new char[]{'a','b','c','1','2','3','4','5','6'};
        size = arr.length;
        doAnagram(size);
    }


    public static  void doAnagram(int newSize){
        if(newSize==1){
           displayWord();
            return;
        }
        for (int i = 0; i <newSize; i++) {
            doAnagram(newSize-1);
            rotate(newSize);

        }
    }

    public static void rotate(int newsize){
        int j;
        int position = size - newsize;
        char temp = arr[position];
        for (j = position + 1; j <size; j++) {
            arr[j -1] = arr[j];
        }
        arr[j-1] = temp;
    }

    public static void displayWord(){
            System.out.println(++count+"\t"+Arrays.toString(arr));

    }
}
