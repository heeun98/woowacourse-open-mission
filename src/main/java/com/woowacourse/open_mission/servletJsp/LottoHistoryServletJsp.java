package com.woowacourse.open_mission.servletJsp;

import com.woowacourse.open_mission.servletJsp.domain.MemberResult;
import com.woowacourse.open_mission.servletJsp.domain.MemberResultRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Map;

@WebServlet(name = "LottoHistoryServletJsp", value = "/servlet/jsp/history")
@Slf4j
public class LottoHistoryServletJsp extends HttpServlet {

    MemberResultRepository memberResultRepository = MemberResultRepository.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("LottoHistoryServletJsp");
        Map<Long, MemberResult> memberResultMap = memberResultRepository.getMemberResultList();
        request.setAttribute("memberResultList", memberResultMap);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/lotto-history.jsp");
        dispatcher.forward(request, response);
    }
}
