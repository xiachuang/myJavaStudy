package cn.hdj.test11;

import cn.hdj.day11.A;
import cn.hdj.day11.Animal;
import cn.hdj.day11.Brid;

public class Test {
    public static void main(String[] args) {
        Animal brid=new Brid();
        brid.eat();
        A brid1=(A)brid;
        brid1.fly();
    }
}
