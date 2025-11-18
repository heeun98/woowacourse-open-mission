package com.woowacourse.open_mission.servletJspSession;
import com.woowacourse.open_mission.domain.MemberResult;
import com.woowacourse.open_mission.domain.MemberResultRepository;
import com.woowacourse.open_mission.servletJspSession.servlet.LottoController;
import com.woowacourse.open_mission.servletJspSession.servlet.Session;

import java.util.Map;


public class LottoResultServletJspSession implements LottoController {

    MemberResultRepository memberResultRepository = MemberResultRepository.getInstance();

    @Override
    public String process(Map<String, String> param, Map<String, Object> model, Session session) {
        Long resultId = Long.valueOf(param.get("resultId"));
        MemberResult memberResult = memberResultRepository.getMemberResultById(resultId);
        model.put("memberResult", memberResult);
        return "lotto-result";
    }
}
