package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class OrderServiceImpl implements OrderService {
    private final MemberService memberService = new MemberServiceImpl();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        // 유저 조회해서
        Member member = memberService.findMember(1L);
        // 할인받아오고
        int discount = discountPolicy.discount(member, itemPrice);
        // 주문서 리턴하고
        return new Order(memberId, itemName, itemPrice, discount);
    }
}
