package com.woowacourse.open_mission.servletJspSession.handler;

import com.woowacourse.open_mission.domain.Member;
import com.woowacourse.open_mission.domain.MemberRepository;
import com.woowacourse.open_mission.servletJspSession.servlet.LottoController;
import com.woowacourse.open_mission.servletJspSession.servlet.Session;
import lombok.extern.slf4j.Slf4j;
import java.util.Map;


@Slf4j

public class LottoMainController implements LottoController {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, String> param, Map<String, Object> model, Session session) {
        Long id = (Long) session.getAttribute("id");
        log.info("로그인 후 :" + id);
        Member member = memberRepository.findById(id);
        model.put("member", member);

        return "lotto-main";
    }
}
