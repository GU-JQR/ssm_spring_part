import com.squ.Student;
import com.squ.entity.Dog;
import com.squ.entity.MoonCake;
import com.squ.entity.Person;
import org.apache.log4j.Logger;
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
    //获取日志对象
    Logger logger=Logger.getLogger(Test.class);
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
//        System.out.println(huangfeng.toString());
        logger.error(huangfeng.toString()+"--------------->>>>>>>>>>>>>>>");
    }

    @org.junit.jupiter.api.Test
    public void test3(){
        //获取spring容器对象
        ApplicationContext atx=new ClassPathXmlApplicationContext("application02.xml");
        //通过bean id获取对象
        MoonCake mooncake1 = atx.getBean("moonCake1", MoonCake.class);
        //日志打印月饼信息
        logger.debug(mooncake1.toString());
    }

    @org.junit.jupiter.api.Test
    public void test4(){
        //获取spring容器对象
        ApplicationContext atx=new ClassPathXmlApplicationContext("application02.xml");
        Dog d1 = atx.getBean("d1", Dog.class);
        d1.dowork();
    }

    @org.junit.jupiter.api.Test
    public void test5(){
        //获取spring容器对象
        ClassPathXmlApplicationContext atx=new ClassPathXmlApplicationContext("application03.xml");
        Person person = atx.getBean("person", Person.class);
        logger.debug(person.toString());
        atx.close();
    }

    @org.junit.jupiter.api.Test
    public void test6(){
        //获取spring容器对象
        ClassPathXmlApplicationContext atx=new ClassPathXmlApplicationContext("application04.xml");
        Person zhangsanfeng = atx.getBean("zhangsanfeng", Person.class);
        System.out.println(zhangsanfeng.toString());
    }

    @org.junit.jupiter.api.Test
    public void test7(){
        //获取spring容器对象
        ClassPathXmlApplicationContext atx=new ClassPathXmlApplicationContext("application05.xml");
        Person person = atx.getBean("person", Person.class);
        System.out.println(person.toString());
    }
}
