package IOC.pojo;

/**该实体类目的是为了测试spring的对象管理
 * 所有交给spring托管的实体类都需要在bean.xml文件中注册
 * @author 王琪
 * @date 2020/10/1 10:33
 */

public class TestDemo {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**可以通过在无参构造中打印字符，或者定义一个有参构造覆盖无参构造的方式来测试输出结果*/
    public TestDemo() {
        System.out.println("无参构造函数！");
    }

    /**ICO创建对象的方式实质上也是调用了user的构造方法
     * 故而，实体类的无参构造函数必须存在！如果要定义其他的构造函数，必须同时定义无参构造函数*/
    public TestDemo(String name) {
        this.name = name;
    }

    /**如果不写无参构造，该如何解决？
     * 现将无参构造覆盖掉，再通过如下的三种方式：
     * 通过下标注入、通过类型注入、通过参数名注入
     * 注意具体内容见bean.xml文件*/


    @Override
    public String toString() {
        return "TestDemo{" +
                "name='" + name + '\'' +
                '}';
    }
}
