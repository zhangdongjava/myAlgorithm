import java.util.Comparator;

/**
 * Created by dell_2 on 2016/7/22.
 */
public class Person implements Comparable{

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public Person(int age){
        this.age = age;
    }



    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                '}';
    }


    @Override
    public int compareTo(Object o) {
        Person p =(Person)o;
        return this.getAge()-p.getAge();
    }
}
