package com.woowacourse.open_mission.servlet;

import camp.nextstep.edu.missionutils.Randoms;
import com.woowacourse.open_mission.LottoTicket;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;

@WebServlet(name = "LottoGenerateServlet", urlPatterns = "/servlet/lotto/winning")
public class LottoGenerateServlet extends HttpServlet {

    private final LottoTicket lottoService = LottoTicket.getInstance();
    private final static String NAME = "name";
    private final static int END_NUM = 45;
    private final static int START_NUM = 1;
    private final static int COUNT = 6;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter(NAME); // 사용자 이름

        // 당첨 번호 생성
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_NUM, END_NUM, COUNT);
        numbers.sort(Integer::compareTo);

        //보너스 번호 생성
        Random random = new Random();
        int bonusNumber;
        while (true) {
            bonusNumber = random.nextInt(END_NUM) + START_NUM;
            if (!numbers.contains(bonusNumber)) break;
        }

        // 당첨 결과 계산 저장
        lottoService.calculateMatchNumberCount(name, numbers, bonusNumber);

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("""
                <!DOCTYPE html>
                <html lang="ko">
                <head>
                  <meta charset="UTF-8">
                  <title>로또 당첨 번호 생성</title>
                  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
                </head>
                <body class="bg-light">
                  <div class="container py-5">
                    <div class="row justify-content-center">
                      <div class="col-lg-8">
                        <div class="card shadow-sm">
                          <div class="card-body text-center">
                            <h3 class="card-title mb-3">🎯 당첨 번호 생성 완료</h3>
                            <p class="text-muted mb-4">
                              사용자 <strong>%s</strong>의 당첨 번호가 생성되었습니다.
                            </p>
                            <h5 class="mb-3">이번 회차</h5>
                            <div class="d-flex justify-content-center gap-2 flex-wrap mb-4">
                              <span class="badge text-bg-primary">당첨 번호: %s</span>
                              <span class="badge text-bg-success">보너스: %d</span>
                            </div>
                            <div class="d-flex justify-content-center gap-3 mt-4">
                              <a class="btn btn-success btn-lg" href="/servlet/lotto/result?name=%s">당첨 결과 확인하기</a>
                              <a class="btn btn-outline-secondary btn-lg" href="/servlet">메인으로</a>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </body>
                </html>
                """.formatted(name == null ? "-" : name, numbers, bonusNumber, name == null ? "" : name));
    }
}
