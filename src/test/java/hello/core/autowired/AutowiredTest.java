package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @org.junit.jupiter.api.Test
    @DisplayName("autowired는 required default가 true이기 떄문에 없는 빈 호출하면 예외발생한다")
    void requiredDefaultTrue() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Test.class);
        ac.getBean(Test.class);
    }

    static class Test {

        @Autowired
        public void autowiredRequiredTrue (Member member) {
            System.out.println("Test.autowiredRequiredTrue");
        }

        @Autowired(required = false)
        public void autowiredRequiredFalse (Member member) {
            // 만약 false로 안되어있으면 member가 bean이 아니라서 예외가 터짐
            System.out.println("Test.autowiredRequiredFalse");
        }

        @Autowired
        public void autowiredNullable(@Nullable Member member) {
            System.out.println("Test.autowiredNullable:" + member);
        }

        @Autowired
        public void autowiredOptional(Optional<Member> member) {
            System.out.println("Test.autowiredOptional:" + member);
        }
    }
}