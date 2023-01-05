package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    final MemberService memberService = new MemberServiceImpl();

    @Test
    void join() {
        // given
        Member member = new Member(1L, "kim", Grade.VIP);
        // when
        memberService.join(member);
        Member member2 = memberService.findMember(1L);
        // then
        Assertions.assertThat(member).isEqualTo(member2);

    }

    @Test
    void findMember() {
    }
}