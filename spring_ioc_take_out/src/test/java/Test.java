import com.squ.config.JavaConfig;
import com.squ.controller.TakeController;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.UUID;

public class Test {
    Logger logger=Logger.getLogger(Test.class);

    @org.junit.jupiter.api.Test
    public void test01(){
        ApplicationContext atx=new AnnotationConfigApplicationContext(JavaConfig.class);
        TakeController controller = atx.getBean("controller", TakeController.class);
        controller.queryAll();
    }

    @org.junit.jupiter.api.Test
    public void test02(){
        ApplicationContext atx=new AnnotationConfigApplicationContext(JavaConfig.class);
        TakeController controller = atx.getBean("controller", TakeController.class);
        controller.addOne();


    }
}
