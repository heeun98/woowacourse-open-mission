package com.woowacourse.open_mission.servletJspSession;


import com.woowacourse.open_mission.servletJspSession.domain.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;

@Slf4j
@WebServlet(name = "LottoBuyServletJspSession", value = "/v3/servlet/jsp/buy")
public class LottoBuyServletJspSession extends HttpServlet {

    MemberRepository memberRepository = MemberRepository.getInstance();
    MemberTicketsRepository memberTicketsRepository = MemberTicketsRepository.getInstance();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log.info("LottoBuyServletJsp 호출");
//        String name = extractParam(request,"name");
        HttpSession session = request.getSession();

        Long id = (Long) session.getAttribute("id");
        int amount = Integer.parseInt(extractParam(request, "amount"));

        LottoTickets lottoTickets = new LottoTickets(amount);
        List<IssuedLotto> issuedLottos = lottoTickets.buyTickets();

        //IssuedLotto 티켓한장!!
        Member member = memberRepository.findById(id);
        memberTicketsRepository.save(member.getUsername(), lottoTickets);

        //세션에 로또티켓들과 이름 넣기
        session.setAttribute("issuedLotto", issuedLottos);

        request.setAttribute("member", member);
        request.setAttribute("issuedLottos", issuedLottos);
        request.getRequestDispatcher("/WEB-INF/viewsV2/lotto-issued.jsp").forward(request, response);

    }

    private String extractParam(HttpServletRequest request, String param) {
        return request.getParameter(param);
    }
}
