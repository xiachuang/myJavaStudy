package cn.hdj.day11;

public class Brid extends Animal implements A {

    @Override
    public void fly() {
        System.out.println("鸟儿再飞翔");
    }

    @Override
    public void eat() {
        System.out.println("鸟儿吃虫");
    }
}
