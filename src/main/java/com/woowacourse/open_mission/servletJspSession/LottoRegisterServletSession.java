package com.woowacourse.open_mission.servletJspSession;

import com.woowacourse.open_mission.domain.Member;
import com.woowacourse.open_mission.domain.MemberRepository;
import com.woowacourse.open_mission.servletJspSession.servlet.LottoController;
import com.woowacourse.open_mission.servletJspSession.servlet.Session;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;


@Slf4j
public class LottoRegisterServletSession implements LottoController {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, String> param, Map<String, Object> model, Session session) {

        String username = param.get("username");
        String loginId = param.get("loginId");
        String password = param.get("password");

        Member member = new Member(loginId, username, password);
        log.info("member = " + member.toString());
        memberRepository.save(member);
        return "redirect:/v3/servlet/jsp/login-form";
    }

}
