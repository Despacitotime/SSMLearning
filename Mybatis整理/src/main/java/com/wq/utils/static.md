static{}静态代码块与{}普通代码块之间的区别：
````//class A
package com.my.test;
class A {
    static {
        System.out.println("A1:父类静态代码区域");
    }
    {
        System.out.println("A2：父类非静态代码区域");
    }
    public A() {
        System.out.println("A3：父类构造器");
    }
}

//class B
package com.my.test;
public class B extends A {
    static {
        System.out.println("B1:子类静态代码区域");
    }
    {
        System.out.println("B2：子类非静态代码区域");
    }
    public B() {
        System.out.println("B3：子类构造器");
    }
}

// 测试类
package com.my.test;
public class Test {
    public static void main(String[] args) {
        B b1 = new B();
        System.out.println("====");
        B b2 = new B();
    }
}
````
输出：
````
A1:父类静态代码区域
B1:子类静态代码区域
A2：父类非静态代码区域
A3：父类构造器
B2：子类非静态代码区域
B3：子类构造器
====
A2：父类非静态代码区域
A3：父类构造器
B2：子类非静态代码区域
B3：子类构造器
````

总结：
````
1.静态代码块先执行，先执行父类的，再执行子类的，
多次创建对象，静态代码块只执行一次。
2.父类的非静态代码区域和构造器先执行，再执行子类的，
非静态代码区域先于构造器。