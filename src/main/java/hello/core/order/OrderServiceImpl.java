package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {
    private  MemberRepository memberRepository;
    private  DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        System.out.println("memberRepository = " + memberRepository);
        System.out.println("discountpolicy = " + discountPolicy);
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        // 유저 조회해서
        Member member = memberRepository.findById(1L);
        // 할인받아오고
        int discount = discountPolicy.discount(member, itemPrice);
        // 주문서 리턴하고
        return new Order(memberId, itemName, itemPrice, discount);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
