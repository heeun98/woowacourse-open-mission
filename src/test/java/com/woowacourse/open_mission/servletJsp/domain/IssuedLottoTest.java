package com.woowacourse.open_mission.servletJsp.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class IssuedLottoTest {

    @Test
    @DisplayName("로또 한 장이 발행이 되면 1~45 사이의 숫자 6개가 발행된다.")
    void 로또_한_장_발행() {
        // given, when
        NumberGenerator numberGenerator = new NumberGenerator();
        IssuedLotto issuedLotto = new IssuedLotto(numberGenerator);

        // then
        assertThat(issuedLotto.getIssuedNumbers().size()).isEqualTo(6);
    }

}