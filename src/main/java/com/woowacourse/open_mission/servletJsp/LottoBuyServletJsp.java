package com.woowacourse.open_mission.servletJsp;

import com.woowacourse.open_mission.servletJsp.domain.IssuedLotto;
import com.woowacourse.open_mission.servletJsp.domain.LottoTickets;
import com.woowacourse.open_mission.servletJsp.domain.MemberRepository;
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
@WebServlet(name = "LottoBuyServletJsp", value = "/servlet/jsp/buy")
public class LottoBuyServletJsp extends HttpServlet {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log.info("LottoBuyServletJsp 호출");
        String name = extractParam(request,"name");
        int amount = Integer.parseInt(extractParam(request, "amount"));

        LottoTickets lottoTickets = new LottoTickets(amount);
        List<IssuedLotto> issuedLottos = lottoTickets.buyTickets();

        //IssuedLotto 티켓한장!!

        memberRepository.   save(name, lottoTickets);

        //세션에 로또티켓들과 이름 넣기
        HttpSession session = request.getSession();
        session.setAttribute("issuedLotto", issuedLottos);
        session.setAttribute("name", name);


        request.setAttribute("name", name);
        request.setAttribute("issuedLottos", issuedLottos);
        request.getRequestDispatcher("/WEB-INF/views/lotto-issued.jsp").forward(request, response);

    }

    private String extractParam(HttpServletRequest request, String param) {
        return request.getParameter(param);
    }
}
