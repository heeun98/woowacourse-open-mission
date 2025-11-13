package com.woowacourse.open_mission.servletJsp.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoTicketsTest {

    @Test
    @DisplayName("6000원을 입력 받으면 6장의 로또를 구매한다.")
    void 로또_구매하기() {
        // given
        int amount = 6000;
        LottoTickets lottoTickets = new LottoTickets(amount);

        // when
        List<IssuedLotto> issuedLottoList = lottoTickets.buyTickets();

        // then
        assertThat(issuedLottoList.size()).isEqualTo(6);
    }

}