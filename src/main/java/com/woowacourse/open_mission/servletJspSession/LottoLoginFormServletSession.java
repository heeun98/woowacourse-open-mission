package com.woowacourse.open_mission.servletJspSession;

import com.woowacourse.open_mission.servletJspSession.frontController.LottoController;
import com.woowacourse.open_mission.servletJspSession.frontController.Session;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

//@WebServlet(name = "LottoLoginFormServletSession", value = "/v3/servlet/jsp/login-form")
public class LottoLoginFormServletSession implements LottoController {

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model, Session session) {
        return "lotto-login";
    }

//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/viewsV2/lotto-login.jsp");
//        dispatcher.forward(request, response);
//    }
}
