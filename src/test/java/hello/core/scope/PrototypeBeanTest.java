package hello.core.scope;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.assertThat;

public class PrototypeBeanTest {
    @Test
    void prototypeBeanScopeTest () {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        System.out.println("시작");
        PrototypeBean bean1 = ac.getBean(PrototypeBean.class);
        PrototypeBean bean2 = ac.getBean(PrototypeBean.class);
        assertThat(bean1).isNotSameAs(bean2);
        System.out.println("종료");
        ac.close();
        bean1.destroy();
        bean2.destroy();
    }

    @Scope("prototype")
    static class PrototypeBean {
        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean.init");
        }

        @PreDestroy
        public void destroy() {
            // 프로토타입은 컨테이너가 관리하지않아 클라이언트가 destroy 각각  처리해야함
            System.out.println("PrototypeBean.destroy");
        }
    }
}
