package com.woowacourse.open_mission.servletJspSession.domain;

import com.woowacourse.open_mission.servletJsp.domain.LottoTickets;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MemberTicketsRepository {

    // key: 이름, value: 구매한 로또들
    private Map<String, List<com.woowacourse.open_mission.servletJsp.domain.LottoTickets>> memberTickets;

    // 총 구매 횟수
    private AtomicInteger totalBuyCount = new AtomicInteger(0);

    private MemberTicketsRepository() {
        this.memberTickets = new ConcurrentHashMap<>();
    }

    private static final MemberTicketsRepository memberRepository = new MemberTicketsRepository();

    public void save(String name, com.woowacourse.open_mission.servletJsp.domain.LottoTickets lottoTickets) {
        if (memberTickets.containsKey(name)) {
            memberTickets.get(name).add(lottoTickets);
            return;
        }
        List<com.woowacourse.open_mission.servletJsp.domain.LottoTickets> lottoTicketsList = new ArrayList<>();
        lottoTicketsList.add(lottoTickets);
        memberTickets.put(name, lottoTicketsList);
        addTotalCount();

    }
    public void addTotalCount() {
        totalBuyCount.incrementAndGet();
    }



    public static MemberTicketsRepository getInstance() {
        return memberRepository;
    }

    public List<LottoTickets> getLottoTicketsByName(String name) {
        return List.copyOf(memberTickets.get(name));
    }

    public int getTotalBuyCount() {
        return totalBuyCount.get();
    }


}
