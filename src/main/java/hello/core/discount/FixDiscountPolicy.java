package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.stereotype.Component;

@Component
public class FixDiscountPolicy implements DiscountPolicy {
    @Override
    public int discount(Member member, int price) {
        return Grade.VIP == member.getGrade() ? 1000 : 0;
    }
}
