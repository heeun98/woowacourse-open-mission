package com.woowacourse.open_mission.servletJspSession;

import com.woowacourse.open_mission.domain.*;
import com.woowacourse.open_mission.servletJspSession.servlet.LottoController;
import com.woowacourse.open_mission.servletJspSession.servlet.Session;
import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.Map;

@Slf4j
public class LottoBuyController implements LottoController {

    MemberRepository memberRepository = MemberRepository.getInstance();
    MemberTicketsRepository memberTicketsRepository = MemberTicketsRepository.getInstance();

    @Override
    public String process(Map<String, String> param, Map<String, Object> model, Session session) {


        Long id = (Long) session.getAttribute("id");
        int amount = Integer.parseInt(param.get("amount"));

        LottoTickets lottoTickets = new LottoTickets(amount);
        List<IssuedLotto> issuedLottos = lottoTickets.buyTickets();
        log.info("issuedLottos : " + issuedLottos.toString());


        Member member = memberRepository.findById(id);
        memberTicketsRepository.save(member.getUsername(), lottoTickets);

        session.setAttribute("issuedLottos", issuedLottos);


        model.put("member", member);
        model.put("issuedLottos", issuedLottos);

        return "lotto-issued";
    }
}
