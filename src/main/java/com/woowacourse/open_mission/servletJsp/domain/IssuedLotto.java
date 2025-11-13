package com.woowacourse.open_mission.servletJsp.domain;

import java.util.List;

public class IssuedLotto {

    // 로또 티켓 한장
    private List<Integer> issuedNumbers;

    public IssuedLotto(Generator<Integer> generator) {
        this.issuedNumbers = generator.generate();
    }

    public List<Integer> getIssuedNumbers() {
        return List.copyOf(issuedNumbers);
    }
}
