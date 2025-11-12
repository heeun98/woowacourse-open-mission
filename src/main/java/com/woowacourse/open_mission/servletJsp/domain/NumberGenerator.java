package com.woowacourse.open_mission.servletJsp.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class NumberGenerator implements Generator{

    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(
                LottoConstant.START_NUMBER, LottoConstant.END_NUMBER, LottoConstant.SIZE
        );
    }
}
