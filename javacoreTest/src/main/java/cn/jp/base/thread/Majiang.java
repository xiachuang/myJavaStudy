package cn.jp.base.thread;

import java.util.HashMap;
import java.util.Map;

public class Majiang {

    private static Map weights = new HashMap();
    static {
        weights.put("筒",10);
        weights.put("条",20);
        weights.put("万",30);
        weights.put(1,1);
        weights.put(2,2);
        weights.put(3,3);
        weights.put(4,4);
        weights.put(5,5);
        weights.put(6,6);
        weights.put(7,7);
        weights.put(8,8);
        weights.put(9,9);
        weights.put("北",40);
        weights.put("南",50);
        weights.put("西",60);
        weights.put("东",70);
        weights.put("白板",150);
        weights.put("红中",200);
        weights.put("发财",300);
    }
    /**
     * 	 筒子，条子，万子
     */
    private String color;
    /**
     * 	牌面数字
     */
    private int number;

    // 顺序1 - 4
    private int order ;
    /**
     * 	权重
     */
    private int weight;

    public Majiang(String color, int order) {
        this.color = color;
        this.order = order;
    }

    public Majiang(String color, int number, int order) {

        this.color = color;
        this.number = number;
        this.order = order;
        this.weight = (int) weights.getOrDefault(color,0) + (int) weights.getOrDefault(number,0);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        if (number==0){
            return this.color;
        }
        return this.number + this.color ;
    }
}
