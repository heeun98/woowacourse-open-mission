package com.woowacourse.open_mission.servletJspSession.frontController;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.web.servlet.server.Session;

import java.io.IOException;
import java.util.Map;

public interface LottoController {

    String process(Map<String, String> paramMap, Map<String, Object> model, Session session);

}
