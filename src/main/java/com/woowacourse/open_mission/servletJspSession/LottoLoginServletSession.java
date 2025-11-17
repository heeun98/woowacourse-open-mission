package com.woowacourse.open_mission.servletJspSession;

import com.woowacourse.open_mission.domain.Member;
import com.woowacourse.open_mission.domain.MemberRepository;
import com.woowacourse.open_mission.servletJspSession.frontController.LottoController;
import com.woowacourse.open_mission.servletJspSession.frontController.Session;
import lombok.extern.slf4j.Slf4j;
import java.util.Map;
import java.util.Optional;

//@WebServlet(name = "LottoLoginServletSession", value = "/v3/servlet/jsp/login")
@Slf4j
public class LottoLoginServletSession implements LottoController {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model, Session session) {

        String loginId = paramMap.get("loginId");
        String password = paramMap.get("password");

        Optional<Member> optionalMember = memberRepository.findByLoginId(loginId);

        // 아이디 없음
        if (optionalMember.isEmpty()) {
            // 뷰 이름만 반환. (FrontController가 리다이렉트/포워드 처리)
            return "redirect:/v3/servlet/jsp/login-form";
        }

        Member member = optionalMember.get();

        // 비밀번호 불일치
        if (!member.getPassword().equals(password)) {
            return "redirect:/v3/servlet/jsp/login-form";
        }

        // 로그인 성공 → 세션에 값 저장 (네가 만든 Session 인터페이스 사용)
        session.setAttribute("id", member.getId());

        // 로그인 후 메인 페이지로 이동
        return "redirect:/v3/servlet/jsp";
    }

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String loginId = request.getParameter("loginId");
//        String password = request.getParameter("password");
//
//        Optional<Member> optionalMember = memberRepository.findByLoginId(loginId);
//
//        if (optionalMember.isEmpty()) {
//            response.sendRedirect("/v3/servlet/jsp/login-form");
//            return;
//        }
//
//        Member member = optionalMember.get();
//        if (!member.getPassword().equals(password)) {
//            response.sendRedirect("/v3/servlet/jsp/login-form");
//            return;
//        }
//
//        HttpSession session = request.getSession();
//        session.setAttribute("id", member.getId());
//
//        response.sendRedirect("/v3/servlet/jsp");
//    }
}
