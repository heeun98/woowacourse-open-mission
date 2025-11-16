package com.woowacourse.open_mission.servletJspSession.domain;

import com.woowacourse.open_mission.servletJsp.domain.MemberResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;


public class MemberResultRepository {

    private static final MemberResultRepository memberResultRepository = new MemberResultRepository();
    private static AtomicLong resultId = new AtomicLong(1L);

    Map<Long, com.woowacourse.open_mission.servletJsp.domain.MemberResult> memberResultMap= new ConcurrentHashMap<>();

    public static MemberResultRepository getInstance() {
        return memberResultRepository;
    }


    public void addMemberResult(com.woowacourse.open_mission.servletJsp.domain.MemberResult memberResult) {
        memberResultMap.put(resultId.get(), memberResult);
        resultId.incrementAndGet();
    }

    public Map<Long, com.woowacourse.open_mission.servletJsp.domain.MemberResult> getMemberResultList() {
        return memberResultMap;
    }

    public MemberResult getMemberResultById(Long resultId) {
        return memberResultMap.get(resultId);
    }
}
