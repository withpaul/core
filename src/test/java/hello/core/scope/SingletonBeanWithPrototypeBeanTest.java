package hello.core.scope;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonBeanWithPrototypeBeanTest {
    @Test
    void 싱글톤_안에_프로토타입_의존되어있는경우() {
        AnnotationConfigApplicationContext ac =
                new AnnotationConfigApplicationContext(Singleton.class, Prototype.class);

        Singleton singleton1 = ac.getBean(Singleton.class);
        Singleton singleton2 = ac.getBean(Singleton.class);

        assertThat(singleton1).isSameAs(singleton2);
        assertThat(singleton1.logic()).isSameAs(1);
        assertThat(singleton2.logic()).isSameAs(2);
        ac.close();
    }

    @Scope("singleton")
    @RequiredArgsConstructor
    static class Singleton {
        private final Prototype prototype;
        public Prototype getPrototype() {
            return prototype;
        }

        public int logic() {
            prototype.addCount();
            return prototype.getCount();
        }

        @PostConstruct
        void init() {
            System.out.println("Singleton.init");
        }

        @PreDestroy
        void destroy() {
            System.out.println("Singleton.destroy");
        }
    }

    @Scope("prototype")
    static class Prototype {
        private int count;


        void addCount() {
            count++;
        }

        int getCount() {
            return count;
        }

        @PostConstruct
        void init() {
            System.out.println("Prototype.init=" + this);
        }

        @PreDestroy
        void destroy() {
            System.out.println("Prototype.destroy");
        }
    }

}
