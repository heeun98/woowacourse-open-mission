package com.woowacourse.open_mission.servletJspSession;

import com.woowacourse.open_mission.domain.MemberResult;
import com.woowacourse.open_mission.domain.MemberResultRepository;
import com.woowacourse.open_mission.servletJspSession.frontController.LottoController;
import com.woowacourse.open_mission.servletJspSession.frontController.Session;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Map;

//@WebServlet(name = "LottoHistoryServletJspSession", value = "/v3/servlet/jsp/history")
@Slf4j
public class LottoHistoryServletJspSession implements LottoController {

    MemberResultRepository memberResultRepository = MemberResultRepository.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model, Session session) {

        Map<Long, MemberResult> memberResultList = memberResultRepository.getMemberResultList();

        model.put("memberResultList", memberResultList);

        return "lotto-history";
    }

//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        log.info("LottoHistoryServletJsp");
//        Map<Long, MemberResult> memberResultMap = memberResultRepository.getMemberResultList();
//        request.setAttribute("memberResultList", memberResultMap);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/viewsV2/lotto-history.jsp");
//        dispatcher.forward(request, response);
//    }
}
