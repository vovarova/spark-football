package countWords;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * Created by Evegeny on 11/06/2016.
 */
@Component
public class AutowireBroadcastAnnotationBeanPostProcessor implements BeanPostProcessor{
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String s) throws BeansException {
        return bean;
    }
}
