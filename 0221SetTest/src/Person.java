public class Person implements Comparable<Person> {

    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Person o) {
        //重写 compareTo 方法，自定义排序算法
        return this.age-o.age;
    }

    @Override
    public String toString() {
        return name+":"+age;
    }
}
