package com.woowacourse.open_mission.servletJsp;

import com.woowacourse.open_mission.servletJsp.domain.MemberResult;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Map;

@WebServlet(name = "LottoCurrentResultServlet", value = "/servlet/jsp/result")
@Slf4j
public class LottoCurrentResultServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        log.info("LottoCurrentResultServlet 호출");
        String name = request.getParameter("name");
        log.info("이름 : {}" , name);
        MemberResult memberResult = (MemberResult) request.getSession().getAttribute("memberResult");

        Map<String, Integer> result = memberResult.getResult();

        for (String s : result.keySet()) {
            log.info("{} : {}", s , result.get(s));
        }

        request.setAttribute("memberResult", memberResult);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/lotto-current-result.jsp");
        dispatcher.forward(request, response);

    }
}
