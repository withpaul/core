package hello.core.autowired;

import hello.core.AutoAppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

public class AllBeanTest {
    @DisplayName("조회한 빈이 모두 필요할때가 있다. 예를 들어 실무에서 유저가 선택한 코드값에 따라 할인 정책이 변경될때")
    @Test
    void getAllBean() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
            AutoAppConfig.class,
            DiscountService.class
        );
        DiscountService discountService = context.getBean(DiscountService.class);

        Member member = new Member(1L, "member", Grade.VIP);
        // Map에서 하나 뽑아서 결과 물 얻기
        int fixDiscount = discountService.discount(member, 20000, "fixDiscountPolicy");
        Assertions.assertThat(1000).isEqualTo(fixDiscount);
        int rateDiscount = discountService.discount(member, 20000, "rateDiscountPolicy");
        Assertions.assertThat(2000).isEqualTo(rateDiscount);
    }


    @RequiredArgsConstructor
    static class DiscountService {
        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> policyList;

        public int discount(Member member, int price, String discountPolicyType) {
            DiscountPolicy discountPolicy = policyMap.get(discountPolicyType);
            return discountPolicy.discount(member, price);
        }
    }
}
