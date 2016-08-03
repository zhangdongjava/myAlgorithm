import java.util.Arrays;

/**
 * Created by dell_2 on 2016/7/21.
 */
public class LowArray {

    private  long a[];

    private int size;
    public LowArray(int size){
        a = new long[size];
        this.size = size;
    }

    public void setElem(int index, long elem){
        a[index] = elem;
    }
    public long getElem(int index){
        return a[index];
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            long l = a[i];
            if(i!=0)
            builder.append(", ");
            builder.append(l);
        }
        builder.append("]");
        return builder.toString();
    }

    public int size(){
        return size;
    }

    public void sizeLow(){
        size --;
    }

    public static void main(String[] args) {
        LowArray la = new LowArray(10);
        for (int i = 0; i < 10; i++) {
            la.setElem(i,i*3);
        }
        System.out.println(la);
        //delete value is 21
        int delIndex = -1;
        for (int i = 0; i < la.size(); i++) {
            long val = la.getElem(i);
            if(val==21){
                delIndex = i;
                break;
            }
        }
        if(delIndex!=-1){
            for (int i = delIndex; i < la.size()-1; i++) {
                la.setElem(i,la.getElem(i+1));
            }
            la.sizeLow();
        }
        System.out.println(la);
    }
}
