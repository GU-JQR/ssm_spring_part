import com.squ.config.JavaConfig;
import com.squ.controller.FoodController;
import com.squ.entity.Food;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class Test {
    //日志对象
    Logger logger=Logger.getLogger(Test.class);

    //单元测试
    @org.junit.jupiter.api.Test
    public void test01(){
        //1.获取spring容器对象
        ApplicationContext atx=new  ClassPathXmlApplicationContext("springconfig.xml");
        //2.获取容器中controller对象
        FoodController controller = atx.getBean("controller", FoodController.class);
        //3.
        controller.queryAllTest();
    }

    @org.junit.jupiter.api.Test
    public  void test02(){
        ApplicationContext atx=new ClassPathXmlApplicationContext("springconfig.xml");
        FoodController controller = atx.getBean("controller", FoodController.class);
        controller.addOne();
    }

    @org.junit.jupiter.api.Test
    public void test03(){
        ApplicationContext atx=new ClassPathXmlApplicationContext("springconfig.xml");
        FoodController controller=atx.getBean("controller",FoodController.class);
        controller.queryOne();
    }

    @org.junit.jupiter.api.Test
    public void test04(){
        ApplicationContext atx=new AnnotationConfigApplicationContext(JavaConfig.class);
        FoodController controller=atx.getBean("controller",FoodController.class);
        controller.queryOne();
    }

    //单元类 配置类创建jdbc
    @org.junit.jupiter.api.Test
    public void test05(){
        ApplicationContext atx=new AnnotationConfigApplicationContext(JavaConfig.class);
        String[] beanDefinitionNames = atx.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        JdbcTemplate jdbcTemplate = atx.getBean("jdbcTemplate", JdbcTemplate.class);
        System.out.println(jdbcTemplate);

        //测试查询全部
        FoodController controller = atx.getBean("controller", FoodController.class);
        controller.queryAllTest();
    }
}
