import com.squ.config.JavaConfig;
import com.squ.entity.Cat;
import com.squ.entity.Person;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
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
    @org.junit.jupiter.api.Test
    public void test02(){
        ApplicationContext atx=new AnnotationConfigApplicationContext(JavaConfig.class);
        String[] beanDefinitionNames = atx.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        Cat cat1 = atx.getBean("cat1", Cat.class);
        System.out.println(cat1.toString());
        Person person = atx.getBean("person", Person.class);
        System.out.println(person.toString());
    }

    /**
     * @scope 配置作用域范围 单例SCOPE_SINGlETON 或者
     * @param cat
     * @return
     */
    @Bean
    @Scope
    public Person createPerson(Cat cat){
        Person person=new Person();
        person.setName("lzg");
        person.setAge(35);
//        person.setCat();
        return person;
    }
}
