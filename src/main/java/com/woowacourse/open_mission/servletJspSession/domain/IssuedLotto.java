package com.woowacourse.open_mission.servletJspSession.domain;

import com.woowacourse.open_mission.servletJspSession.domain.Generator;

import java.util.List;

public class IssuedLotto {

    // 로또 티켓 한장
    private List<Integer> issuedNumbers;

    public IssuedLotto(Generator<Integer> generator) {
        List<Integer> generate = generator.generate();
        generate.sort(((o1, o2) -> o1 - o2));
        this.issuedNumbers = generate;
    }

    public List<Integer> getIssuedNumbers() {
        return List.copyOf(issuedNumbers);
    }
}
