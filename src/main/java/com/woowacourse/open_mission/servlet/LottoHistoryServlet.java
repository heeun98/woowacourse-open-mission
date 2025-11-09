package com.woowacourse.open_mission.servlet;

import com.woowacourse.open_mission.LottoService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@WebServlet(name = "LottoHistoryListServlet", urlPatterns = "/history")
public class LottoHistoryServlet extends HttpServlet {

    private final LottoService lottoService = LottoService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        Map<String, List<List<Integer>>> all = lottoService.getRandomNumber();

        out.println("""
            <!DOCTYPE html>
            <html lang="ko">
            <head>
                <meta charset="UTF-8">
                <title>로또 구매자 목록</title>
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
            </head>
            <body class="container py-5">
                <h2 class="mb-4">🎟️ 로또 구매자 목록</h2>
                <table class="table table-bordered text-center">
                    <thead class="table-light">
                        <tr>
                            <th>이름</th>
                            <th>구매 티켓 수</th>
                            <th>결과 보기</th>
                        </tr>
                    </thead>
                    <tbody>
        """);

        for (Map.Entry<String, List<List<Integer>>> entry : all.entrySet()) {
            String name = entry.getKey();
            int count = entry.getValue().size();
            out.printf("""
                <tr>
                    <td>%s</td>
                    <td>%d</td>
                    <td><a href="/lotto/result?name=%s" class="btn btn-primary btn-sm">결과 보기</a></td>
                </tr>
            """, name, count, name);
        }

        out.println("""
                    </tbody>
                </table>
                <a href="/" class="btn btn-outline-secondary">메인으로</a>
            </body>
            </html>
        """);
    }
}
