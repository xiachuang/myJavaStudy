package cn.hdjd.print;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class DemoPrint02 {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("--------");
        PrintStream ps=new PrintStream("src/file/print.txt");
        System.setOut(ps);//改变  打印流的 打印目的地
        System.out.println("你好");
        ps.close();
    }
}
