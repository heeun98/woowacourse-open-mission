package com.woowacourse.open_mission.servlet;

import camp.nextstep.edu.missionutils.Randoms;
import com.woowacourse.open_mission.LottoService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.regex.Pattern;


@Slf4j
@WebServlet(name = "LottoBuyServlet", urlPatterns = "/lotto/buy")
public class LottoBuyServlet extends HttpServlet {

    private static final String AMOUNT_PATTERN = "^\\d+$";
    private static final int UNIT_PRICE = 1000;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int COUNT = 6;
    private final LottoService lottoService = LottoService.getInstance();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String name = request.getParameter("name");
        int amount = Integer.parseInt(request.getParameter("amount"));


        if (!Pattern.matches(AMOUNT_PATTERN, String.valueOf(amount))) {
            throw new IllegalArgumentException("금액은 숫자만 입력 가능합니다.");
        }
        if (amount % UNIT_PRICE != 0) {
            throw new IllegalArgumentException("1000원 단위만 입력 가능합니다.");
        }

        int ticketSize = amount / UNIT_PRICE;

        lottoService.initTickets(name);
        for (int i = 0; i < ticketSize; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, COUNT);
            lottoService.saveTicket(name, numbers);
        }

        lottoService.printCurrentStatus();
        List<List<Integer>> tickets = lottoService.getTickets(name);


        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("""
                <!DOCTYPE html>
                <html lang="ko">
                <head>
                    <meta charset="UTF-8">
                    <title>로또 구매 완료</title>
                    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
                    <style>
                        .ticket-box {
                            display: inline-block;
                            padding: 10px 18px;
                            border-radius: 8px;
                            border: 1px solid #ddd;
                            margin: 6px;
                            font-size: 18px;
                            background: #ffffff;
                        }
                        .ticket-number {
                            display:inline-block;
                            background:#f1f1f1;
                            padding:5px 10px;
                            border-radius:6px;
                            margin:2px;
                            font-weight:bold;
                        }
                    </style>
                </head>
                
                <body class="container text-center py-5">
                
                <h2 class="mb-4">🎉 %d개의 로또를 구매하였습니다.</h2>
                <hr>
                """.formatted(ticketSize));

        int index = 1;
        for (List<Integer> ticket : tickets) {
            ticket.sort(Integer::compareTo); // 번호 정렬

            out.println("<div class='ticket-box'>");
            out.println("<strong>" + (index++) + "번 티켓</strong><br>");

            for (Integer num : ticket) {
                out.println("<span class='ticket-number'>" + num + "</span>");
            }
            out.println("</div><br>");
        }

        out.println("""
                <hr class="my-4">
                <a class="btn btn-success btn-lg" href="/lotto/winning?name=%s">🎯 당첨 번호 생성하기</a>
                
                <div class="mt-4">
                    <a class="btn btn-outline-secondary" href="/">메인으로 돌아가기</a>
                </div>
                
                </body>
                </html>
                """.formatted(name));


    }


}
