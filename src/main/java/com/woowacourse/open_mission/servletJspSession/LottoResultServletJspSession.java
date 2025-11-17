package com.woowacourse.open_mission.servletJspSession;


import com.woowacourse.open_mission.domain.MemberResult;
import com.woowacourse.open_mission.domain.MemberResultRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "LottoResultServletJspSession", value = "/v3/servlet/jsp/result")
public class LottoResultServletJspSession extends HttpServlet {

    MemberResultRepository memberResultRepository = MemberResultRepository.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long resultId = Long.valueOf(request.getParameter("resultId"));
        MemberResult memberResult = memberResultRepository.getMemberResultById(resultId);
        request.setAttribute("memberResult", memberResult);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/viewsV2/lotto-result.jsp");
        dispatcher.forward(request, response);
    }

}
