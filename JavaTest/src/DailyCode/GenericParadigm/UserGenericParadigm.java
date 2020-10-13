package DailyCode.GenericParadigm;

import DailyCode.Annotation.Person;

import java.util.Arrays;
/*
泛型就是编写模板代码来适应任意类型；
泛型的好处是使用时不必对类型进行强制转换，它通过编译器对类型进行检查；
注意泛型的继承关系：可以把ArrayList<Integer>向上转型为List<Integer>（T不能变！），
但不能把ArrayList<Integer>向上转型为ArrayList<Number>（T不能变成父类）。
*/

public class UserGenericParadigm {
    public static void main(String[] args) {
        Animal[] an = new Animal[]{
              new Animal("Tiger",66),
              new Animal("elephant",74),
              new Animal("penguin",90)
        };
        Arrays.sort(an);
        for(Animal temp : an){
            System.out.println(temp.toString());
        }
    }
}

class Animal implements Comparable<Animal>{
    String name;
    int score;

    public Animal(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Animal o) {
        return this.score - o.score;
    }

    public String toString(){
        return this.name + "," + this.score;
    }
}
