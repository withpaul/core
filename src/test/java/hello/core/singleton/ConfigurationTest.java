package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class ConfigurationTest {

    @DisplayName("configuartion은 싱글톤을 보장할까")
    @Test
    void singletonTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberServiceImpl memberService = ac.getBean(MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean(OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean(MemberRepository.class);
        System.out.println("memberService memberRepository= " + memberService.getMemberRepository());
        System.out.println("orderService memberRepository= " + orderService.getMemberRepository());
        System.out.println("memberRepository= " + memberRepository);

        assertThat(memberRepository).isSameAs(memberService.getMemberRepository());
        assertThat(memberRepository).isSameAs(orderService.getMemberRepository());
    }
}
