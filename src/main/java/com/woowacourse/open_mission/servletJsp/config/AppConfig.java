package com.woowacourse.open_mission.servletJsp.config;

import com.woowacourse.open_mission.servletJsp.domain.LottoTickets;

public final class AppConfig {

    private static final LottoTickets lottoTickets = new LottoTickets();


    public static LottoTickets getLottoTickets() {
        return lottoTickets;
    }

    private AppConfig() {
    }
}
