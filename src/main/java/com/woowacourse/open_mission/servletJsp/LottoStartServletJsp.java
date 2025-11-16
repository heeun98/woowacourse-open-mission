package com.woowacourse.open_mission.servletJsp;

import com.woowacourse.open_mission.servletJsp.domain.MemberRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
@WebServlet(name = "LottoFormServletJsp", value = "/servlet/jsp/lotto")
public class LottoStartServletJsp extends HttpServlet {


    private final MemberRepository memberRepository = MemberRepository.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("LottoStartServletJsp 호출");


        int totalBuyCount = memberRepository.getTotalBuyCount();
        request.setAttribute("totalBuyCount", totalBuyCount);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/lotto-start.jsp");

        dispatcher.forward(request, response);

    }
}
