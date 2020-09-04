package com.girrafelim.study.service;

import com.girrafelim.study.domain.Member;
import com.girrafelim.study.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
// JPA의 데이터 변경이나 로직들은 트랜잭션안에서 수행되어야 한다.
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {


    private final MemberRepository memberRepository;

    /**
     * 회원 가입
     */
    @Transactional
    public Long join(Member member){
        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member); // 영속성 컨텍스트에 엔티티를 올릴 때 키 : 밸류 값으로 들어가게 되는데 키는 => PK의 VALUE
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName()); // multi thread 환경에서는 member name 같은 값은 unique로 잡아주는게 좋다. [ 동시에 통과해 save 될 수 있음 ]
        if(!findMembers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    // 회원 전체 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Member findOne(Long memberId){
        return memberRepository.findOne(memberId);
    }

}
