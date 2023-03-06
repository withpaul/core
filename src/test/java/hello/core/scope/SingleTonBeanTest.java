package hello.core.scope;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.assertThat;

public class SingleTonBeanTest {

    @Test
    void singletonBeanScopeTest () {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingleTonBean.class);
        System.out.println("시작");
        SingleTonBean bean1 = ac.getBean(SingleTonBean.class);
        SingleTonBean bean2 = ac.getBean(SingleTonBean.class);
        assertThat(bean1).isSameAs(bean2);
        System.out.println("종료");
        ac.close();
    }

    @Scope("singleton")
    static class SingleTonBean {
        @PostConstruct
        public void init() {
            System.out.println("SingleTonBean.init");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("SingleTonBean.destroy");
        }
    }
}
