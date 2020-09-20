package cn.hdj.thread;

public class BTest {
    static int x=10;
            static { x+=5;}
    public static void main(String[] args) {

        System.out.println( x);
    }
    static { x/=3;}
//        Collection<String> collection=new ArrayList<>();
//        collection.add("110");
//        collection.add("111");
//        collection.add("112");
//        collection.add("113");
//        Iterator<String> iterator =collection.iterator();
//        while (iterator.hasNext()){
//            // 迭代是反复内容,使用循环实现,循环的终止条件：集合中没元素, hasNext()返回了false
//            String s=iterator.next();
//            System.out.println(s);
//        }
//      Object[] strings=  collection.toArray();
//        System.out.println(strings[1]);
//    }
}
