package IOC.pojo;

/**该类用于测试在Spring中的对象都会被创建，不管是否使用
 * @author 王琪
 * @date 2020/10/1 15:09
 */
public class TestDemoT {
    private String name;

    public TestDemoT() {
        System.out.println("TestDemoT被创建了");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void show(){
        System.out.println("name"+name);
    }

}
