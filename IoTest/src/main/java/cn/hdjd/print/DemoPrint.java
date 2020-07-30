package cn.hdjd.print;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class DemoPrint {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream ps=new PrintStream("src/file/print.txt");
        ps.write(97);
        ps.println(22);
        ps.println("消化");
        ps.println(97+"下雨");
        ps.close();
    }
}
