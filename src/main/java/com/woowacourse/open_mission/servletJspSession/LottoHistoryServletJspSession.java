package com.woowacourse.open_mission.servletJspSession;

import com.woowacourse.open_mission.domain.MemberResult;
import com.woowacourse.open_mission.domain.MemberResultRepository;
import com.woowacourse.open_mission.servletJspSession.servlet.LottoController;
import com.woowacourse.open_mission.servletJspSession.servlet.Session;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;


@Slf4j
public class LottoHistoryServletJspSession implements LottoController {

    MemberResultRepository memberResultRepository = MemberResultRepository.getInstance();

    @Override
    public String process(Map<String, String> param, Map<String, Object> model, Session session) {
        Map<Long, MemberResult> memberResultList = memberResultRepository.getMemberResultList();
        model.put("memberResultList", memberResultList);
        return "lotto-history";
    }
}
