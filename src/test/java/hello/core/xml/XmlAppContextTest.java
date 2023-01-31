package hello.core.xml;

import hello.core.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class XmlAppContextTest {
    ApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");
    @Test
    @DisplayName("xml config로 빈을 조회해보자")
    void xmlAppContext() {
        assertThat(ac.getBean("memberService", MemberService.class)).isInstanceOf(MemberService.class);
    }
}
