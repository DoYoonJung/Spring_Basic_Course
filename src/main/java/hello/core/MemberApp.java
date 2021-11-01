package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
        // AppConfig appConfig = new AppConfig();
       // MemberService memberService = appConfig.memberService();

       //ApplicationContext를 쓰는 것이 spring의 시작이라는 뜻이다. bean으로 체크했던 객체들을 모두 관리함

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);


        Member member = new Member(1L, "memberA", Grade.VIP);
        //new Member(1L, "memberA", Grade.VIP); 상태에서 ctrl+alt+v를 누르면 자동완성 앞 부분이

        memberService.join(member);

        Member findMember = memberService.findMember(1L);

        System.out.println("new member = "+member.getName());
        System.out.println("find Member = "+findMember.getName());
    }
}
