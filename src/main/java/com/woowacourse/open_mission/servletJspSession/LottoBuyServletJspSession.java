package com.woowacourse.open_mission.servletJspSession;


import com.woowacourse.open_mission.domain.*;
import com.woowacourse.open_mission.servletJspSession.frontController.LottoController;
import com.woowacourse.open_mission.servletJspSession.frontController.Session;
import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.Map;

@Slf4j
//@WebServlet(name = "LottoBuyServletJspSession", value = "/v3/servlet/jsp/buy")
public class LottoBuyServletJspSession implements LottoController {

    MemberRepository memberRepository = MemberRepository.getInstance();
    MemberTicketsRepository memberTicketsRepository = MemberTicketsRepository.getInstance();


    @Override
    public String process(Map<String, String> param, Map<String, Object> model, Session session) {


        Long id = (Long) session.getAttribute("id");
        int amount = Integer.parseInt(param.get("amount"));

        LottoTickets lottoTickets = new LottoTickets(amount);
        List<IssuedLotto> issuedLottos = lottoTickets.buyTickets();


        //IssuedLotto 티켓한장!!
        Member member = memberRepository.findById(id);
        memberTicketsRepository.save(member.getUsername(), lottoTickets);

        session.setAttribute("issuedLotto", issuedLottos);


        model.put("member", member);
        model.put("issuedLotto", issuedLottos);

        return "lotto-issued";

    }

}
