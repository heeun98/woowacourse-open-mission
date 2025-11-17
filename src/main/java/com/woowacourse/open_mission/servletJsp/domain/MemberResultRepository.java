package com.woowacourse.open_mission.servletJsp.domain;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;


public class MemberResultRepository {

    private static final MemberResultRepository memberResultRepository = new MemberResultRepository();
    private static AtomicLong resultId = new AtomicLong(1L);

    Map<Long, MemberResult> memberResultMap= new ConcurrentHashMap<>();

    public static MemberResultRepository getInstance() {
        return memberResultRepository;
    }


    public void addMemberResult(MemberResult memberResult) {
        memberResultMap.put(resultId.get(), memberResult);
        resultId.incrementAndGet();
    }

    public Map<Long, MemberResult> getMemberResultList() {
        return memberResultMap;
    }

    public MemberResult getMemberResultById(Long resultId) {
        return memberResultMap.get(resultId);
    }
}
