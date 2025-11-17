package com.woowacourse.open_mission.servletJspSession;

import com.woowacourse.open_mission.domain.MemberResult;
import com.woowacourse.open_mission.servletJspSession.frontController.LottoController;
import com.woowacourse.open_mission.servletJspSession.frontController.Session;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Map;

//@WebServlet(name = "LottoCurrentResultServletSession", value = "/v3/servlet/jsp/current-result")
@Slf4j
public class LottoCurrentResultServletSession implements LottoController {



    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model, Session session) {
        MemberResult memberResult = (MemberResult) session.getAttribute("memberResult");

        Map<String, Integer> result = memberResult.getResult();

        model.put("memberResult", memberResult);

        return "lotto-current";
    }

//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//
//        log.info("LottoCurrentResultServlet 호출");
//        HttpSession session = request.getSession();
//
//        MemberResult memberResult = (MemberResult) session.getAttribute("memberResult");
//
//        Map<String, Integer> result = memberResult.getResult();
//
//        for (String s : result.keySet()) {
//            log.info("{} : {}", s , result.get(s));
//        }
//
//        request.setAttribute("memberResult", memberResult);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/viewsV2/lotto-current-result.jsp");
//        dispatcher.forward(request, response);
//
//    }
}
