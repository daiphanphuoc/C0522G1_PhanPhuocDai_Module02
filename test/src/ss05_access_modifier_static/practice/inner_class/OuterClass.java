package ss05_access_modifier_static.practice.inner_class;

import org.jetbrains.annotations.NotNull;

public class OuterClass {
    private int out = 0;
    static int in = 0;

    public void method() {
        class Scope {
            void m() {
                in = 8;
                out = 7;
            }
        }
    }

    public class InnerClass {
        int inn;
        public void demo() {
            out = 8;
            in = 9;
            this.inn=8;
        }
    }

    public static class NestedClass {
        OuterClass outerClass = new OuterClass();


        public void setOuterClass(@NotNull OuterClass outerClass) {
            this.outerClass = outerClass;
            outerClass.out = 0;
            OuterClass.in = 0;
        }
    }

    public static void main(String[] args) {
        OuterClass.InnerClass inner = new OuterClass().new InnerClass();
        OuterClass.NestedClass nested =new OuterClass.NestedClass();
        inner.demo();
        System.out.println(in);
        nested.outerClass.out=7;
        nested.setOuterClass(new OuterClass());
        System.out.println(in);

    }

}
