import sun.misc.Queue;

public class Test {
    public static void main(String[] args) {

        Integer i=new Integer(10);
        String str="hhhh";
        System.out.println(str);
        change(str);
        System.out.println(str);
        System.out.println(i);
        add(i);
        System.out.println(i);
    }
    public static void add(Integer i){
        i=i+10;
    }
    public static void change(String t){
        t="ggggg";
    }
}
