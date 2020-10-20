package DailyCode.GenericParadigm;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/*
这是编译器看到的代码：
public class Pair<T> {
    private T first;
    private T last;
    public Pair(T first, T last) {
        this.first = first;
        this.last = last;
    }
    public T getFirst() {
        return first;
    }
    public T getLast() {
        return last;
    }
}

虚拟机执行的代码：
public class Pair {
    private Object first;
    private Object last;
    public Pair(Object first, Object last) {
        this.first = first;
        this.last = last;
    }
    public Object getFirst() {
        return first;
    }
    public Object getLast() {
        return last;
    }
}

局限一:<T> 不能是基本类型，列如int，因为实际类型是Object
局限二:无法取得带泛型的class
        Pair<String> p1 = new Paor<>("hello","word");
        Pair<String> p2= new Paor<>(123,456);
        Class c1 = p1.getClass();
        Class c2 = p2.getClass();
        System.our.println("c1 == c2");//true
        System.our.println("c1 == pair,class");//true
局限三:无法判断泛型的类型
        Pair<String> p1 = new Paor<>("hello","word");
        //Compile error
        if(p1 instanceof Pair<String>){
        }
局限四:
        不能实例化T类型
        public class Pair<T>{
            private T first;
            private T last;
            public Pair() {
                //Compile error
                first = new T();//first = new Object();
                last = new T();//last = new Object();
            }

            //通过反射来获得实例
            public Pair(Class<T> c){
                first = c.newInstance();
                last = c.newInstance();
            }
        }

*/
public class Rubbing {
    public static void main(String[] args) {
        Class<IntPair> c = IntPair.class;
        Type t = c.getGenericSuperclass();
        if(t instanceof ParameterizedType){
            ParameterizedType pt = (ParameterizedType) t;
            Type[] types = pt.getActualTypeArguments();//可能有多个参数类型
            Type firstType = types[0];
            Class<?> typeClass = (Class<?>) firstType;
            System.out.println(typeClass);//class java.lang.Integer

        }

    }
}

class Pair<T>{
    private T first;
    private T last;

    public Pair(T first, T last) {
        this.first = first;
        this.last = last;
    }

    public T getFirst() {
        return first;
    }

    public T getLast() {
        return last;
    }
}
class IntPair extends Pair<Integer>{

    public IntPair(Integer first, Integer last) {
        super(first, last);
    }
}