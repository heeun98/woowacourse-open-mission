package com.woowacourse.open_mission.servletJspSession.handler;
import com.woowacourse.open_mission.domain.Member;
import com.woowacourse.open_mission.domain.MemberRepository;
import com.woowacourse.open_mission.servletJspSession.servlet.LottoController;
import com.woowacourse.open_mission.servletJspSession.servlet.Session;
import lombok.extern.slf4j.Slf4j;
import java.util.Map;
import java.util.Optional;


@Slf4j
public class LottoLoginController implements LottoController {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, String> param, Map<String, Object> model, Session session) {

        String loginId = param.get("loginId");
        String password = param.get("password");

        Optional<Member> optionalMember = memberRepository.findByLoginId(loginId);

        if (optionalMember.isEmpty()) {
            return "redirect:/v3/servlet/jsp/login-form";
        }
        Member member = optionalMember.get();

        if (!member.getPassword().equals(password)) {
            return "redirect:/v3/servlet/jsp/login-form";
        }
        session.setAttribute("id", member.getId());
        return "redirect:/v3/servlet/jsp";
    }

}
