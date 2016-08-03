import com.sun.org.apache.bcel.internal.generic.SWAP;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by dell_2 on 2016/7/22.
 */
public class Sort {
    public static void main(String[] args) {
        Person arr[] = {
            new Person(1),
            new Person(4),
            new Person(5),
            new Person(2),
            new Person(9)
        };
        System.out.println("排序前:"+Arrays.toString(arr));
        insertion2(arr);
        System.out.println("排序后:"+Arrays.toString(arr));
    }

    /**
     * 冒泡
     * @param arr
     */
    public static void maopao(int arr[]){
        boolean inXh = false;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count++;
            for (int j = 0; j < arr.length-1-i; j++) {
                inXh = true;
                count++;
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
            if(inXh)--count;
        }
        System.out.println("循环次数:"+count);
    }

    /**
     * 选择
     * @param arr
     */
    public static void select(int arr[]){
        int min ;
        boolean inXh = false;
        int count = 0;
        for (int i = 0; i < arr.length-1; i++) {
            count++;
            min = i;
            for (int j = i+1; j < arr.length; j++) {
                inXh = true;
                count++;
                if(arr[min]>arr[j]){
                    min = j;
                }
            }
            swap(arr,i,min);
            if(inXh)--count;
        }
        System.out.println("循环次数:"+count);
    }
    /**
     * 插入 先固左边第一个为有序的排列 然后从第二个开始 到左边有序集合找到自己的位置
     * @param arr
     */
    public static void insertion(int arr[]){
        int in ;
        int count = 0;
        boolean inXh = false;
        for (int i = 1; i < arr.length; i++) {
            count++;
            int temp = arr[i];
            in = i;
            while(in>0 && arr[in-1]>=temp){
                inXh = true;
                count++;
                arr[in] = arr[in-1];
                --in;
            }
            arr[in] = temp;
            if(inXh)--count;

        }
        System.out.println("循环次数:"+count);
    }

    /**
     * 插入
     * @param arr
     */
    public static void insertion2(Person arr[]){
        int in ;
        int count = 0;
        boolean inXh = false;
        for (int i = 1; i < arr.length; i++) {
            count++;
            Person temp = arr[i];
            in = i;
            while(in>0 && (arr[in-1].compareTo(temp)>0)){
                inXh = true;
                count++;
                arr[in] = arr[in-1];
                --in;
            }
            arr[in] = temp;
            if(inXh)--count;

        }
        System.out.println("循环次数:"+count);
    }







    public static void swap(int[] arr,int i,int j){
        if(i==j){
            return;
        }
        arr[j] = arr[j] ^ arr[i];
        arr[i] = arr[j] ^ arr[i];
        arr[j] = arr[j] ^ arr[i];
    }
}
