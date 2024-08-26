import com.squ.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 此处Test是作为单元测试的类,需要放在绿色的文件下
 * 单元测试:
 * 1.创建一个方法类似 public void test1()
 * 2.在方法上添加@Test注解
 * 3.在方法里面编写代码
 * 4.找到@test注解左边的绿色三角行  运行单元测试
 */
public class Test {
    @org.junit.jupiter.api.Test
    public void test1(){
        System.out.println("1111111111");
    }

    @org.junit.jupiter.api.Test
    public void test2(){
        //1.获取spring大容器对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springconfig.xml");
        //2.通过bean id获取容器中创建的对象
        Student guangzhi = (Student) applicationContext.getBean("guangzhi");
        //3.调用学生方法
        guangzhi.dowork();

        Student huangfeng = (Student) applicationContext.getBean("huangfeng");
        System.out.println(huangfeng.toString());
    }
}
