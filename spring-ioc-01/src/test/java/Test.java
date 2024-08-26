import com.squ.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    @org.junit.jupiter.api.Test
    public void test1(){
        // 创建学生对象并打印信息
        Student s1 = new Student("S1001", "jqr", 21, "男");
        System.out.println(s1.toString());

        Student s2 = new Student("S1002", "ljj", 22, "男");
        System.out.println(s2.toString());
        //总结:手工创建  主控权在我自己
        //而通过sprin方式控制权转给spring容器对象 这里称为IOC
        //spring容器怎么知道你需要做什么 xml配置文件  定义好的注释
        //1.在项目中引入spring依赖后,
    }

    @org.junit.jupiter.api.Test
    public void test2(){
        //如何获取到spring大容器中的对象 ClassPathXml
        //获取spring容器对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springconfig01.xml");
        //根据bean的id获取spring大容器中创建的对象
        Student datouwawa = (Student) applicationContext.getBean("datouwawa");
        datouwawa.study();
    }
}
