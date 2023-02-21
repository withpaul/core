package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

class LifeCycleBeanTest {

    @Test
    void lifeCycleBeanTest() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LifeCycleConfiguration.class);
        context.getBean(LifeCycleBean.class);
        context.close();
    }

    @Configuration
    static class LifeCycleConfiguration {
        @Bean
        LifeCycleBean lifeCycleBean() {
            LifeCycleBean lifeCycleBean = new LifeCycleBean();
            lifeCycleBean.setUrl("afreecatv.com");
            return lifeCycleBean;
        }
    }
}