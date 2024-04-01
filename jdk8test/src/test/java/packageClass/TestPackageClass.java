package packageClass;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TestPackageClass {

    @Test
    public void testInteger() {
        Integer m = 123;
        Integer n = 123;

        Integer x = new Integer(123);
        Integer y = new Integer(123);

        Integer m1 = 323;
        Integer n1 = 323;

        // 缓存池内比较
        System.out.println(m == n); // true
        // 缓存池内外比较
        System.out.println(m == x); // false
        // 缓存池外比较
        System.out.println(x == y); // false
        // 缓存池外比较
        System.out.println(m1 == n1); // false
    }

    @Test
    public void testString() {
        String m = "123";
        String n = "123";

        String s1 = new String("aaa");
        String s2 = new String("aaa");

        String s3 = s1.intern();

        // 常量池内比较
        System.out.println(m == n); // true
        // 常量池内比较
        System.out.println(s1.intern() == s3); // true
        // 常量池内外比较
        System.out.println(s1 == s3); // false
        // 常量池外比较
        System.out.println(s1 == s2); // false
    }


}
