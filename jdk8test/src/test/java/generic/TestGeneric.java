package generic;

import org.hzr.modules.generic.entity.User;
import org.junit.jupiter.api.Test;

public class TestGeneric {

    /**
     * 泛型代码复用
     */
    @Test
    public <T extends Number> double add(T a, T b) {

        System.out.println(a + "+" + b + "=" + (a.doubleValue() + b.doubleValue()));
        return a.doubleValue() + b.doubleValue();
    }

    /**
     * 单元泛型
     */
    @Test
    public void GenericsTest1(){
        class Point<T>{         // 此处可以随便写标识符号，T是type的简称
            private T var ;     // var的类型由T指定，即：由外部指定
            public T getVar(){  // 返回值的类型由外部决定
                return var ;
            }
            public void setVar(T var){  // 设置的类型也由外部决定
                this.var = var ;
            }
        }


        Point<String> p = new Point<String>();     // 里面的var类型为String类型
        p.setVar("it") ;                            // 设置字符串
        System.out.println(p.getVar().length()) ;   // 取得字符串的长度
    }

    /**
     * 多元泛型
     */
    @Test
    public void GenericsTest2(){
        class Notepad<K,V>{       // 此处指定了两个泛型类型
            private K key ;     // 此变量的类型由外部决定
            private V value ;   // 此变量的类型由外部决定
            public K getKey(){
                return this.key ;
            }
            public V getValue(){
                return this.value ;
            }
            public void setKey(K key){
                this.key = key ;
            }
            public void setValue(V value){
                this.value = value ;
            }
        }

        Notepad<String,Integer> t = null ;        // 定义两个泛型类型的对象
        t = new Notepad<>() ;       // 里面的key为String，value为Integer
        t.setKey("汤姆") ;        // 设置第一个内容
        t.setValue(20) ;            // 设置第二个内容
        System.out.print("姓名；" + t.getKey()) ;      // 取得信息
        System.out.print("，年龄；" + t.getValue()) ;       // 取得信息
    }

    interface Info<T>{        // 在接口上定义泛型
        public T getVar() ; // 定义抽象方法，抽象方法的返回值就是泛型类型
    }

    /**
     * 泛型接口
     */
    @Test
    public void GenericsTest3(){
        class InfoImpl<T> implements Info<T>{   // 定义泛型接口的子类
            private T var ;             // 定义属性
            public InfoImpl(T var){     // 通过构造方法设置属性内容
                this.setVar(var) ;
            }
            public void setVar(T var){
                this.var = var ;
            }
            public T getVar(){
                return this.var ;
            }
        }

        Info<String> i = new InfoImpl<>("汤姆");        // 声明接口对象
        System.out.println("内容：" + i.getVar()) ;
    }

    public <T> T getObject(Class<T> c) throws InstantiationException, IllegalAccessException {
        return c.newInstance();
    }

    /**
     * 调用泛型方法
     */
    @Test
    public void GenericsTest4() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        User user = (User) getObject(Class.forName("org.hzr.modules.generic.entity.User"));
        user.setName("test");
        System.out.println("user：" + user.toString());;
    }

    /**
     * 上限
     */
    class Info1<T extends Number>{    // 此处泛型只能是数字类型
        private T var ;        // 定义泛型变量
        public void setVar(T var){
            this.var = var ;
        }
        public T getVar(){
            return this.var ;
        }
        public String toString(){    // 直接打印
            return this.var.toString() ;
        }
    }

    /**
     * 下限
     */
    class Info2<T>{
        private T var ;        // 定义泛型变量
        public void setVar(T var){
            this.var = var ;
        }
        public T getVar(){
            return this.var ;
        }
        public String toString(){    // 直接打印
            return this.var.toString() ;
        }
    }
    public void fun(Info2<? super String> temp){    // 只能接收String或Object类型的泛型，String类的父类只有Object类
        System.out.print(temp + ", ") ;
    }

    /**
     * 泛型上下限
     */
    @Test
    public void GenericsTest5() {

        Info1<Integer> i1 = new Info1<>();
        i1.setVar(1);
        System.out.println(i1);

        Info2<String> i2 = new Info2<>();        // 声明String的泛型对象
        Info2<Object> i3 = new Info2<>();        // 声明Object的泛型对象
        i2.setVar("hello");
        i3.setVar(new Object());
        fun(i2);
        fun(i3);

    }
}
