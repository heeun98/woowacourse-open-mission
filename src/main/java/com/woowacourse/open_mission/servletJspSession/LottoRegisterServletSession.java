package com.woowacourse.open_mission.servletJspSession;

import com.woowacourse.open_mission.domain.Member;
import com.woowacourse.open_mission.domain.MemberRepository;
import com.woowacourse.open_mission.servletJspSession.frontController.LottoController;
import com.woowacourse.open_mission.servletJspSession.frontController.Session;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

//@WebServlet(name = "LottoRegisterServletSession", value = "/v3/servlet/jsp/register")
@Slf4j
public class LottoRegisterServletSession implements LottoController {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model, Session session) {

        String username = paramMap.get("username");
        String loginId = paramMap.get("loginId");
        String password = paramMap.get("password");

        Member member = new Member(loginId, username, password);
        memberRepository.save(member);
        return "login-form";
    }

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        log.info("LottoRegisterServletSession 호출");
//
//        String username = request.getParameter("username");
//        String loginId = request.getParameter("loginId");
//        String password = request.getParameter("password");
//
//        Member member = new Member(loginId, username, password);
//        memberRepository.save(member);
//
//        response.sendRedirect("/v3/servlet/jsp/login-form");
//    }
}
