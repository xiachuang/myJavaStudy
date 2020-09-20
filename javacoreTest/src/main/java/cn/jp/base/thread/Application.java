package cn.jp.base.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<String> colors = new ArrayList();
        List<Integer> numbers = new ArrayList();
        List<Integer> orders = new ArrayList();
        List<Majiang> Majiangs = new ArrayList();

        Collections.addAll(colors, "筒","条","万");
        Collections.addAll(numbers, 1,2,3,4,5,6,7,8,9);
        Collections.addAll(orders,1,2,3,4);


        for(int i = 0 ; i<colors.size() ;i++){
            for (int j = 0; j < numbers.size(); j++) {
                for (int m = 0; m < orders.size(); m++) {
                    Majiangs.add(new Majiang(colors.get(i),numbers.get(j),orders.get(m)));
                }
            }
        }
        for (int i = 0; i < orders.size(); i++) {
            Majiangs.add(new Majiang("红中",orders.get(i)));
        }
        for (int i = 0; i < orders.size(); i++) {
            Majiangs.add(new Majiang("发财",orders.get(i)));
        }
        for (int i = 0; i < orders.size(); i++) {
            Majiangs.add(new Majiang("白板",orders.get(i)));
        }
        for (int i = 0; i < orders.size(); i++) {
            Majiangs.add(new Majiang("东",orders.get(i)));
        }
        for (int i = 0; i < orders.size(); i++) {
            Majiangs.add(new Majiang("西",orders.get(i)));
        }
        for (int i = 0; i < orders.size(); i++) {
            Majiangs.add(new Majiang("南",orders.get(i)));
        }
        for (int i = 0; i < orders.size(); i++) {
            Majiangs.add(new Majiang("北",orders.get(i)));
        }
        //洗牌
        Collections.shuffle(Majiangs);//打乱list顺序
        // 三个玩家
        List<Majiang> play1 = new ArrayList();
        List<Majiang> play2 = new ArrayList();
        List<Majiang> play3 = new ArrayList();
        List<Majiang> host = new ArrayList();

        int j = 0;
        for(int i = 0 ; i <3 ;i++){
            //每一圈每个人拿牌
            host.add(Majiangs.get(j++));
            host.add(Majiangs.get(j++));
            host.add(Majiangs.get(j++));
            host.add(Majiangs.get(j++));

            play1.add(Majiangs.get(j++));
            play1.add(Majiangs.get(j++));
            play1.add(Majiangs.get(j++));
            play1.add(Majiangs.get(j++));

            play2.add(Majiangs.get(j++));
            play2.add(Majiangs.get(j++));
            play2.add(Majiangs.get(j++));
            play2.add(Majiangs.get(j++));

            play3.add(Majiangs.get(j++));
            play3.add(Majiangs.get(j++));
            play3.add(Majiangs.get(j++));
            play3.add(Majiangs.get(j++));
        }

        host.add(Majiangs.get(j++));
        host.add(Majiangs.get(j++));
        play1.add(Majiangs.get(j++));
        play2.add(Majiangs.get(j++));
        play3.add(Majiangs.get(j++));

        Comparator sort = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Majiang c1 = (Majiang) o1;
                Majiang c2 = (Majiang) o2;
                return c1.getWeight() < c2.getWeight() ? -1 : 1;
            }
        };

        Collections.sort(play1,sort);
        Collections.sort(play2,sort);
        Collections.sort(play3,sort);
        Collections.sort(host,sort);

        System.out.println("庄家: " + host);
        System.out.println("散家1：" + play1);
        System.out.println("散家2：" + play2);
        System.out.println("散家3：" + play3);


    }
}
