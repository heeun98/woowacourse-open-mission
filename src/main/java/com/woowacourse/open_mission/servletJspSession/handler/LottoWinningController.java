package com.woowacourse.open_mission.servletJspSession.handler;

import com.woowacourse.open_mission.Rank;
import com.woowacourse.open_mission.domain.*;
import com.woowacourse.open_mission.servletJspSession.servlet.LottoController;
import com.woowacourse.open_mission.servletJspSession.servlet.Session;
import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Slf4j
public class LottoWinningController implements LottoController {

    private final MemberResultRepository memberResultRepository = MemberResultRepository.getInstance();
    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, String> param, Map<String, Object> model, Session session) {

        NumberGenerator numberGenerator = new NumberGenerator();
        List<Integer> lottoNumbers = numberGenerator.generate();
        lottoNumbers.sort(Integer::compareTo);


        Random random = new Random();
        int bonusNumber;
        while (true) {
            bonusNumber = random.nextInt(LottoConstant.END_NUMBER) + LottoConstant.START_NUMBER;
            if (!lottoNumbers.contains(bonusNumber)) break;
        }

        Lotto lotto = new Lotto(lottoNumbers, bonusNumber);

        Long id = (Long) session.getAttribute("id");
        Member member = memberRepository.findById(id);

        List<IssuedLotto> issuedLottoList = (List<IssuedLotto>) session.getAttribute("issuedLottos");

        MemberResult memberResult = new MemberResult(member.getUsername());
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
        session.setAttribute("memberResult", memberResult);


        model.put("lotto", lotto);
        model.put("member", member);

        return "lotto-winning";
    }

}
