package com.woowacourse.open_mission.servletJsp.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MemberResultRepository {

    private static final MemberResultRepository memberResultRepository = new MemberResultRepository();
    private static Long resultId = 1L;

    Map<Long, MemberResult> memberResultMap= new HashMap<>();

    public static MemberResultRepository getInstance() {
        return memberResultRepository;
    }


    public void addMemberResult(MemberResult memberResult) {
        memberResultMap.put(resultId, memberResult);
        resultId++;
    }

    public Map<Long, MemberResult> getMemberResultList() {
        return memberResultMap;
    }

    public MemberResult getMemberResultById(Long resultId) {
        return memberResultMap.get(resultId);
    }
}
