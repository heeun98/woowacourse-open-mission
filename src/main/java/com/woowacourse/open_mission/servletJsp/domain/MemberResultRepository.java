package com.woowacourse.open_mission.servletJsp.domain;

import java.util.ArrayList;
import java.util.List;

public class MemberResultRepository {

    private static final MemberResultRepository memberResultRepository = new MemberResultRepository();

    List<MemberResult> memberResultList = new ArrayList<>();

    public static MemberResultRepository getInstance() {
        return memberResultRepository;
    }



    public void addMemberResult(MemberResult memberResult) {
        memberResultList.add(memberResult);
    }







}
