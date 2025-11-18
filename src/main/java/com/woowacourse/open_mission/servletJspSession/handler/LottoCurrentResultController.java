package com.woowacourse.open_mission.servletJspSession.handler;

import com.woowacourse.open_mission.domain.MemberResult;
import com.woowacourse.open_mission.servletJspSession.servlet.LottoController;
import com.woowacourse.open_mission.servletJspSession.servlet.Session;
import lombok.extern.slf4j.Slf4j;
import java.util.Map;

@Slf4j
public class LottoCurrentResultController implements LottoController {

    @Override
    public String process(Map<String, String> param, Map<String, Object> model, Session session) {
        MemberResult memberResult = (MemberResult) session.getAttribute("memberResult");
        model.put("memberResult", memberResult);
        return "lotto-current-result";
    }
}
