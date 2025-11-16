package com.woowacourse.open_mission.servletJspSession.domain;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
public class MemberRepository {

    private static Map<Long, Member> store = new ConcurrentHashMap<Long, Member>();
    private static AtomicLong sequence = new AtomicLong(0);

    private static final MemberRepository memberRepository = new MemberRepository();

    public static MemberRepository getInstance() {
        return memberRepository;
    }

    public Member save(Member member) {
        member.setId(sequence.incrementAndGet());
        log.info("save: member={}", member);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public Optional<Member> findByLoginId(String loginId) {
        return findAll().stream()
                .filter(m -> m.getLoginId().equals(loginId))
                .findFirst();
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
