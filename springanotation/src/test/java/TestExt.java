import com.xjh.ext.ExtConfg;
import org.junit.Test;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @autor xujianhong
 * @date 2020/1/27 18:54
 */
public class TestExt {

    ConfigurableApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(ExtConfg.class);



    @Test
    public void test(){
        //发布事件
        //ConfigurableApplicationContext.publishEvent
        annotationConfigApplicationContext.publishEvent(new ApplicationEvent(new String("我自定义发布了一个事件")) {
            @Override
            public Object getSource() {
                return super.getSource();
            }
        });

        annotationConfigApplicationContext.close();
    }



}
