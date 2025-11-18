package com.woowacourse.open_mission.servletJspSession.handler;

import com.woowacourse.open_mission.domain.MemberTicketsRepository;
import com.woowacourse.open_mission.servletJspSession.servlet.LottoController;
import com.woowacourse.open_mission.servletJspSession.servlet.Session;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class LottoStartController implements LottoController {

    private final MemberTicketsRepository memberTicketsRepository = MemberTicketsRepository.getInstance();

    @Override
    public String process(Map<String, String> param, Map<String, Object> model, Session session) {
        int totalBuyCount = memberTicketsRepository.getTotalBuyCount();

        model.put("totalBuyCount", totalBuyCount);

        return "lotto-start";
    }
}
