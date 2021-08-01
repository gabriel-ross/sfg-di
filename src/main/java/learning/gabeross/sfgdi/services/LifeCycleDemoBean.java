package learning.gabeross.sfgdi.services;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class LifeCycleDemoBean implements InitializingBean, DisposableBean, BeanNameAware, BeanFactoryAware, ApplicationContextAware {

    public LifeCycleDemoBean() {
        System.out.println("Calling the lifecycle constructor.");
    }


    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("Setting bean factory");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("My name is "+s);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Lifecycle terminated");

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Properties have been set");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Application context set");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Post constructor called");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("Pre-destroy method called");
    }

    public void beforeInit() {
        System.out.println("Before init called by bean post-processor");
    }

    public void afterInit() {
        System.out.println("After init called by bean post-processor");
    }
}
