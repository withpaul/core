package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName() {
        MemberService memberservice = annotationConfigApplicationContext.getBean("memberService", MemberService.class);
        Assertions.assertThat(memberservice).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 타입으로 조회")
    void findBeanByType() {
        MemberService memberservice = annotationConfigApplicationContext.getBean(MemberService.class);
        Assertions.assertThat(memberservice).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByImplType() {
        // 구체에 의존하게 하는건 안좋음...역할(인터페이스)와 구현(구현체)을 구분해야한다. 역할에 의존하는게 다형성에좋아
        MemberService memberservice = annotationConfigApplicationContext.getBean("memberService", MemberServiceImpl.class);
        Assertions.assertThat(memberservice).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회X")
    void findBeanByNameX() {
        assertThrows(
            NoSuchBeanDefinitionException.class,
            () ->  annotationConfigApplicationContext.getBean("memberService22", MemberService.class)
        );
    }

}
