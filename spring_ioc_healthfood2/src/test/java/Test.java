import com.squ.controller.FoodController;
import com.squ.entity.Food;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        ApplicationContext atx=new ClassPathXmlApplicationContext("springconfig.xml");
        String[] beanDefinitionNames = atx.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }
}
