package com.woowacourse.open_mission.servletJsp;

import com.woowacourse.open_mission.servletJsp.domain.Lotto;
import com.woowacourse.open_mission.servletJsp.domain.LottoConstant;
import com.woowacourse.open_mission.servletJsp.domain.NumberGenerator;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;
import java.util.Random;

@Slf4j
@WebServlet(name = "LottoWinningServletJsp", value = "/servlet/jsp/winning")
public class LottoWinningServletJsp extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        log.info("LottoWinningServletJsp 호출됨");

        //당첨 번호 생성
        NumberGenerator numberGenerator = new NumberGenerator();
        List<Integer> numbers = numberGenerator.generate();
        numbers.sort(Integer::compareTo);

        //보너스 번호 생성
        Random random = new Random();
        int bonusNumber;
        while (true) {
            bonusNumber = random.nextInt(LottoConstant.END_NUMBER) + LottoConstant.START_NUMBER;
            if (!numbers.contains(bonusNumber)) break;
        }

        //Lotto 객체 생성
        Lotto lotto = new Lotto(numbers, bonusNumber);

        //JSP로 전달할 데이터 설정
        request.setAttribute("lotto", lotto);

        //사용자 이름 세션에서 가져오기
        String name = (String) request.getSession().getAttribute("name");
        request.setAttribute("name", name);

        //SP 뷰로 forward
        request.getRequestDispatcher("/WEB-INF/views/lotto-winning.jsp")
                .forward(request, response);
    }
}
