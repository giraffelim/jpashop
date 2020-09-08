package com.girrafelim.study;

import com.girrafelim.study.domain.Member;
import com.girrafelim.study.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

//    @Autowired
//    MemberRepository memberRepository;
//
//    @Test
//    @Transactional // Test에 Transactional이 존재하면 데이터를 다 rollback 처리한다.
//    @Rollback(false) // 롤백을 하지 않는다.
//    public void testMember() throws Exception{
//        // given
//        Member member = new Member();
//        member.setUsername("memberA");
//
//        // when
//        Long saveId = memberRepository.save(member);
//        Member findMember = memberRepository.find(saveId);
//
//        // then
//        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
//        Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
//        // 같은 트랜잭션안에서 저장을 하고 조회를한다면 영속성 컨텍스트가 똑같게 된다. 같은 영속성 컨텍스트에서 아이디가 같으면 같은 엔티티로 식별
//        Assertions.assertThat(findMember).isEqualTo(member);
//        System.out.println("findMember == member: " + (findMember == member));
//    }

}