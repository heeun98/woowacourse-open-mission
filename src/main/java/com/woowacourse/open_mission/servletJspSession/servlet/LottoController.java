package com.woowacourse.open_mission.servletJspSession.servlet;


import java.util.Map;

public interface LottoController {

    String process(Map<String, String> param, Map<String, Object> model, Session session);

}
