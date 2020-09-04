package com.girrafelim.study;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository {

    // Entity Manager: 엔티티를 저장, 수정, 삭제, 조회등 엔티티와 관련된 작업을 수행
    // 엔티티 매니저를 통한 데이터 변경은 모두 트랜잭션 안에서 이루어져야 한다.
    @PersistenceContext
    private EntityManager em;

    public Long save(Member member){
        em.persist(member); // 엔티티를 저장
        return member.getId();
    }

    public Member find(Long id){
        return em.find(Member.class, id);
    }


}
