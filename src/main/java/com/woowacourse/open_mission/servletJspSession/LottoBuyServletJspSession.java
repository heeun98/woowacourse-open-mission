package com.woowacourse.open_mission.servletJspSession;


import com.woowacourse.open_mission.domain.*;
import com.woowacourse.open_mission.servletJspSession.frontController.LottoController;
import com.woowacourse.open_mission.servletJspSession.frontController.View;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.server.Session;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Slf4j
@WebServlet(name = "LottoBuyServletJspSession", value = "/v3/servlet/jsp/buy")
public class LottoBuyServletJspSession implements LottoController {

    MemberRepository memberRepository = MemberRepository.getInstance();
    MemberTicketsRepository memberTicketsRepository = MemberTicketsRepository.getInstance();


    @Override
    public String process(Map<String, String> param, Map<String, Object> model, Session session) {





        return null;
    }
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {

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
        "/WEB-INF/viewsV2/lotto-issued.jsp";

        new View()

    }

    private String extractParam(HttpServletRequest request, String param) {
        return request.getParameter(param);
    }
}
