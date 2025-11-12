package com.woowacourse.open_mission.servletJsp;

import com.woowacourse.open_mission.servletJsp.config.AppConfig;
import com.woowacourse.open_mission.servletJsp.domain.IssuedLotto;
import com.woowacourse.open_mission.servletJsp.domain.LottoTickets;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;

@Slf4j
@WebServlet(name = "LottoBuyServletJsp", value = "/servlet/lotto/buy")
public class LottoBuyServletJsp extends HttpServlet {

    private LottoTickets lottoTickets = AppConfig.getLottoTickets();


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = extractParam(request,"name");
        int amount = Integer.parseInt(extractParam(request, "amount"));


        List<IssuedLotto> issuedLottos = lottoTickets.buyTickets(amount);


    }

    private String extractParam(HttpServletRequest request, String param) {
        return request.getParameter("name");
    }
}
