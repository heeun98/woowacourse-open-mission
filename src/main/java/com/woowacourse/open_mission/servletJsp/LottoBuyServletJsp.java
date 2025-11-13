package com.woowacourse.open_mission.servletJsp;

import com.woowacourse.open_mission.servletJsp.domain.IssuedLotto;
import com.woowacourse.open_mission.servletJsp.domain.LottoTickets;
import com.woowacourse.open_mission.servletJsp.domain.MemberRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.lang.reflect.Member;
import java.util.List;

@Slf4j
@WebServlet(name = "LottoBuyServletJsp", value = "/servlet/lotto/buy")
public class LottoBuyServletJsp extends HttpServlet {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = extractParam(request,"name");
        int amount = Integer.parseInt(extractParam(request, "amount"));

        LottoTickets lottoTickets = new LottoTickets(amount);
        List<IssuedLotto> issuedLottos = lottoTickets.buyTickets();

        memberRepository.save(name, lottoTickets);
    }

    private String extractParam(HttpServletRequest request, String param) {
        return request.getParameter("name");
    }
}
