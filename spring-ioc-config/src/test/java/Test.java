import com.squ.config.javaconfig;
import com.squ.entity.Cat;
import com.squ.entity.Person;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    Logger logger=Logger.getLogger(Test.class);

    @org.junit.jupiter.api.Test
    public void test1(){
        //获取spring容器对象 AnnotationConfigApplicationContext参数,可变长数组
        ApplicationContext atx=new AnnotationConfigApplicationContext(javaconfig.class);
        //2.
        String[] names=atx.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        Cat cat1=atx.getBean("cat", Cat.class);
        Cat cat2=atx.getBean("cat2", Cat.class);
        Cat cat3=atx.getBean("cat2", Cat.class);
        System.out.println(cat1==cat2);
        System.out.println(cat3==cat2);
        Person person = atx.getBean("person", Person.class);
        logger.debug("打印实例对象内容---------");
        logger.debug(cat1.toString());
        logger.debug(person.toString());
    }


}
