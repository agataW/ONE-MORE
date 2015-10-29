package pl.wujko.one_more.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Agata on 2015-10-25.
 */
public class BeanHelper
{
    private static ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

    public static Object getBean(String bean)
    {
        return context.getBean(bean);
    }
}
