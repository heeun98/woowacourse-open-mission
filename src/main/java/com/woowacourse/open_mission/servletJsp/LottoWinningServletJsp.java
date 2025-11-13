package com.woowacourse.open_mission.servletJsp;

import com.woowacourse.open_mission.Rank;
import com.woowacourse.open_mission.servlet.domain.LottoResult;
import com.woowacourse.open_mission.servletJsp.domain.*;
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


    private final MemberResultRepository memberResultRepository = MemberResultRepository.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        log.info("LottoWinningServletJsp 호출됨");

        //당첨 번호 생성
        NumberGenerator numberGenerator = new NumberGenerator();
        List<Integer> lottoNumbers = numberGenerator.generate();
        lottoNumbers.sort(Integer::compareTo);

        //보너스 번호 생성
        Random random = new Random();
        int bonusNumber;
        while (true) {
            bonusNumber = random.nextInt(LottoConstant.END_NUMBER) + LottoConstant.START_NUMBER;
            if (!lottoNumbers.contains(bonusNumber)) break;
        }

        //Lotto 객체 생성
        Lotto lotto = new Lotto(lottoNumbers, bonusNumber);


        String name = (String) request.getSession().getAttribute("name");
        List<IssuedLotto> issuedLottoList = (List<IssuedLotto>) request.getSession().getAttribute("issuedLotto");

        MemberResult memberResult = new MemberResult(name);
        memberResult.initResult();

        issuedLottoList.stream()
                .map(issuedLotto -> issuedLotto.getIssuedNumbers())
                .forEach(numbers -> {
                    int count = lotto.matchCount(numbers);
                    boolean matchBonus = lotto.matchBonus(numbers);
                    String matchMessage = Rank.getMatchMessage(count, matchBonus);
                    if (matchMessage != null) {
                        memberResult.addResultCount(matchMessage);
                    }
                });

        memberResultRepository.addMemberResult(memberResult);

        request.getSession().setAttribute("memberResult", memberResult);

        //JSP로 전달할 데이터 설정
        request.setAttribute("lotto", lotto);

        //사용자 이름 세션에서 가져오기
        request.setAttribute("name", name);

        //SP 뷰로 forward
        request.getRequestDispatcher("/WEB-INF/views/lotto-winning.jsp")
                .forward(request, response);
    }
}
