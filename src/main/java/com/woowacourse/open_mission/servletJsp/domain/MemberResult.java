package com.woowacourse.open_mission.servletJsp.domain;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class MemberResult {

    private final String name;
    private final LocalDate createdAt;
    private Map<String, Integer> result;
    private MemberRepository memberRepository;


    public MemberResult(String name, LocalDate createdAt) {
        this.name = name;
        this.createdAt = createdAt;
        memberRepository = MemberRepository.getInstance();
    }


    public void generateCount(String name) {

        List<LottoTickets> lottoTickets = memberRepository.getLottoTicketsByName(name);


        lottoTickets.stream()
                .forEach(lottoTicket -> {

                });

    }

}
