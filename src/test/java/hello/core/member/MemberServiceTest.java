package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    AppConfig appConfig = new AppConfig();
    MemberService memberService = appConfig.memberService();

    @Test
    void join(){
        //give
        Member member = new Member(1L, "memberA", Grade.VIP);


        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then
        //Assertions는 검증을 위한 것이다.
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
