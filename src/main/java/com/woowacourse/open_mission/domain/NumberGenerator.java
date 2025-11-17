package com.woowacourse.open_mission.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class NumberGenerator implements Generator {

    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(
                com.woowacourse.open_mission.servletJsp.domain.LottoConstant.START_NUMBER, com.woowacourse.open_mission.servletJsp.domain.LottoConstant.END_NUMBER, LottoConstant.SIZE
        );
    }
}
