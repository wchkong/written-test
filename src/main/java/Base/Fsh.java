package Base;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * java反射demo
 */
public class Fsh {

    public static void main(String[] args) {

        try {
            Class<?> test = Class.forName("Base.Test");
            Class<?> test1 = ClassLoader.getSystemClassLoader().loadClass("Base.Test");

            System.out.println(test.equals(test1));

            Test o = (Test)test1.newInstance();
            o.def = "a1";
            o.pub = "a2";
            o.pro = "a3";

            Field[] fields = test.getDeclaredFields();
            Method[] declaredMethods = test.getDeclaredMethods();
            Test test2 = new Test();
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                field.setAccessible(true);
                System.out.println(field.getName());
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}


class Test {

    private String pri;
    String def;
    protected String pro;
    public String pub;

    public Test(String pri, String def, String pro, String pub) {
        this.pri = pri;
        this.def = def;
        this.pro = pro;
        this.pub = pub;
    }

    public Test() {
    }
}
