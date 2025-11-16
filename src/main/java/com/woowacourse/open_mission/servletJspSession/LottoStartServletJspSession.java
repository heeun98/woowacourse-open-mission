package com.woowacourse.open_mission.servletJspSession;

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
@WebServlet(name = "LottoStartServletJspSession", value = "/v3/servlet/jsp/lotto")
public class LottoStartServletJspSession extends HttpServlet {


    private final MemberRepository memberRepository = MemberRepository.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("LottoStartServletJsp 호출");


        int totalBuyCount = memberRepository.getTotalBuyCount();
        request.setAttribute("totalBuyCount", totalBuyCount);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/viewsV2/lotto-start.jsp");

        dispatcher.forward(request, response);

    }
}
