package com.woowacourse.open_mission.servletJspSession.domain;

import camp.nextstep.edu.missionutils.Randoms;
import com.woowacourse.open_mission.servletJspSession.domain.Generator;
import com.woowacourse.open_mission.servletJspSession.domain.LottoConstant;

import java.util.List;

public class NumberGenerator implements Generator {

    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(
                com.woowacourse.open_mission.servletJsp.domain.LottoConstant.START_NUMBER, com.woowacourse.open_mission.servletJsp.domain.LottoConstant.END_NUMBER, LottoConstant.SIZE
        );
    }
}
