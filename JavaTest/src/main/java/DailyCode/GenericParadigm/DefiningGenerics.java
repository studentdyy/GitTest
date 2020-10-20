package DailyCode.GenericParadigm;

public class DefiningGenerics<T,K> {
    /*
    E：元素（Element），多用于java集合框架
    K：关键字（Key）
    N：数字（Number）
    T：类型（Type）
    V：值（Value
    */
    private T Name;
    private K age;

    public DefiningGenerics(T name, K age) {
        Name = name;
        this.age = age;
    }

    public T getName() {
        return Name;
    }

    public void setName(T name) {
        Name = name;
    }

    public K getAge() {
        return age;
    }

    public void setAge(K age) {
        this.age = age;
    }

    //静态方法不能引用泛型类型<T>，必须定义其他类型（例如<K>）来实现静态泛型方法
    //这里的T和K 和Clss<T,K>是不一样的
    public static <T,K> DefiningGenerics<T,K> create(T name,K age){
        return new DefiningGenerics<T,K>(name,age);
    }

    public static void main(String[] args) {
        DefiningGenerics<String,Integer> D = new DefiningGenerics<>("happy",2);
        DefiningGenerics<Integer,String> De = DefiningGenerics.create(50,"SDJSAKDJGH");
        System.out.println(D.getName()+","+De.getName());
    }
}
