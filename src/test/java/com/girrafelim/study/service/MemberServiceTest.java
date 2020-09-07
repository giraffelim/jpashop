package com.girrafelim.study.service;

import com.girrafelim.study.domain.Member;
import com.girrafelim.study.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional // 테스트 케이스에 있는 경우 기본적으로 rollback 처리
public class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    EntityManager em;

    @Test
    public void 회원가입() throws Exception{

        //given
        Member member = new Member();
        member.setName("kim");

        //when
        Long saveId = memberService.join(member);

        //then
//        em.flush(); // 영속성 컨텍스트의 내용을 데이터 베이스에 반영
        assertEquals(member, memberRepository.findOne(saveId));

    }

    // expected = 예외 클래스를 적어주면 된다.
    @Test(expected = IllegalStateException.class)
    public void 중복_회원_예외() throws Exception{

        //given
        Member member1 = new Member();
        member1.setName("kim");

        Member member2 = new Member();
        member2.setName("kim");

        //when
        memberService.join(member1);
        memberService.join(member2);
//        try{
//            memberService.join(member2);
//        }catch(IllegalStateException e){
//            return;
//        }

        //then
        fail("예외가 발생해야 한다.");
    }

}