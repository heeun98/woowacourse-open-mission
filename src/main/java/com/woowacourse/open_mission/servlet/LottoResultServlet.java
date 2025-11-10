package com.woowacourse.open_mission.servlet;

import com.woowacourse.open_mission.LottoResult;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(name = "LottoResultServlet", urlPatterns = "/servlet/lotto/result")
public class LottoResultServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        if (name == null || name.isEmpty()) {
            out.write("<h3>❌ 사용자 이름이 제공되지 않았습니다.</h3>");
            return;
        }

        // 메시지 → 개수 Map
        Map<String, Integer> resultData = LottoResult.getResult(name);
        LottoResult.printResultData(name);

        out.write("""
                <!DOCTYPE html>
                <html lang="ko">
                <head>
                    <meta charset="UTF-8">
                    <title>로또 결과</title>
                    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
                </head>
                <body class="bg-light d-flex flex-column justify-content-center align-items-center" style="height: 100vh;">
                    <div class="bg-white p-5 rounded shadow" style="width: 400px;">
                        <h2 class="text-center mb-4">🎉 로또 결과 - %s</h2>
                        <table class="table table-bordered text-center">
                            <thead class="table-light">
                                <tr>
                                    <th>결과</th>
                                    <th>개수</th>
                                </tr>
                            </thead>
                            <tbody>
                """.formatted(name));

        // 결과 데이터 렌더링
        for (Map.Entry<String, Integer> entry : resultData.entrySet()) {
            String message = entry.getKey();
            int count = entry.getValue();
            out.write("""
                    <tr>
                        <td>%s</td>
                        <td>%d개</td>
                    </tr>
                    """.formatted(message, count));
        }

        out.write("""
                            </tbody>
                        </table>
                        <div class="text-center mt-3">
                            <a href="/servlet/history" class="btn btn-secondary w-100">뒤로가기</a>
                        </div>
                    </div>
                </body>
                </html>
                """);
    }
}
