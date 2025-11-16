package com.woowacourse.open_mission.servletJspSession;

import com.woowacourse.open_mission.servletJspSession.domain.Member;
import com.woowacourse.open_mission.servletJspSession.domain.MemberRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "LottoLoginServletSession", value = "/v3/servlet/jsp/login")
@Slf4j
public class LottoLoginServletSession extends HttpServlet {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String loginId = request.getParameter("loginId");
        String password = request.getParameter("password");

        Optional<Member> member1 = memberRepository.findByLoginId("gywls5184");
        log.info(member1.toString());

        Optional<Member> optionalMember = memberRepository.findByLoginId(loginId);

        if (optionalMember.isEmpty()) {
            response.sendRedirect("/v3/servlet/jsp/login-form");
            return;
        }

        Member member = optionalMember.get();
        if (!member.getPassword().equals(password)) {
            response.sendRedirect("/v3/servlet/jsp/login-form");
            return;
        }

        response.sendRedirect("/v3/servlet/jsp");
    }
}
