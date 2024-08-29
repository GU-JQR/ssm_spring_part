import com.squ.entity.Cat;
import com.squ.entity.Person;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    Logger logger=Logger.getLogger(Test.class);

    //单元测试:注解扫描能否获取到bean实例
    @org.junit.jupiter.api.Test
    public void test01(){
        //获取spring类里的对象
        ApplicationContext atx=new ClassPathXmlApplicationContext("springAnnotationConfig.xml");
        //获取容器中全部bean组件的名称
        String[] beanDefinitionNames = atx.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        //获取猫的实例
        Cat cat1 = atx.getBean("cat1", Cat.class);
        System.out.println(cat1.toString());
        Person person = atx.getBean("person", Person.class);
        System.out.println(person.toString());
    }
}
