package com.woowacourse.open_mission.servletJspSession;

import com.woowacourse.open_mission.servletJspSession.servlet.LottoController;
import com.woowacourse.open_mission.servletJspSession.servlet.Session;
import java.util.Map;

public class LottoJoinFormServlet implements LottoController {

    @Override
    public String process(Map<String, String> param, Map<String, Object> model, Session session) {
        return "lotto-join";
    }
}
