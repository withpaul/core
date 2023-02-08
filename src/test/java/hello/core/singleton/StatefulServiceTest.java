package hello.core.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

class StatefulServiceTest {

    @DisplayName("테스트")
    @Test
    void statefulServiceSingleton() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService service1 = applicationContext.getBean(StatefulService.class);
        StatefulService service2 = applicationContext.getBean(StatefulService.class);

        service1.order("kim", 100);
        service2.order("ahn", 200);

        System.out.println(service1.getPrice());
    }

    @DisplayName("configuration 어노테이션이 없으면 과연 같은게 나올까")
    @Test
    void statefulServiceSingleton2() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService service1 = applicationContext.getBean(StatefulService.class);
        StatefulRepositoryService service2 = applicationContext.getBean(StatefulRepositoryService.class);

        // TestConfig에 Configuration 어노테이션이 없으면 스프링 빈 자체는 등록시키지만
        // statefulRepositoryService() 내부에서 생성한 statusfulService()는 등록시키지 않는다.
        System.out.println("service1 = " + service1);
        System.out.println("service2 = " + service2.getStatefulService());
    }

    @Configuration
    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            System.out.println("한번");
            return new StatefulService();
        }

        @Bean
        public StatefulRepositoryService statefulRepositoryService() {
            return new StatefulRepositoryService(statefulService());
        }
    }
}