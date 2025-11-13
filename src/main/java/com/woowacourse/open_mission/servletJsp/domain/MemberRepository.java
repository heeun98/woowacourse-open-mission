package com.woowacourse.open_mission.servletJsp.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {

    // key: 이름, value: 구매한 로또들
    private Map<String, List<LottoTickets>> memberTickets;

    private MemberRepository() {
        this.memberTickets = new HashMap<>();
    }

    private static final MemberRepository memberRepository = new MemberRepository();

    public void save(String name, LottoTickets lottoTickets) {
        if (memberTickets.containsKey(name)) {
            memberTickets.get(name).add(lottoTickets);
            return;
        }
        List<LottoTickets> lottoTicketsList = new ArrayList<>();
        lottoTicketsList.add(lottoTickets);
        memberTickets.put(name, lottoTicketsList);
    }

    public static MemberRepository getInstance() {
        return memberRepository;
    }
}
