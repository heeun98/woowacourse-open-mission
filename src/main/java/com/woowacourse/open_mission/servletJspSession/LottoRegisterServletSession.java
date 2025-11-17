package com.woowacourse.open_mission.servletJspSession;

import com.woowacourse.open_mission.domain.Member;
import com.woowacourse.open_mission.domain.MemberRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@WebServlet(name = "LottoRegisterServletSession", value = "/v3/servlet/jsp/register")
@Slf4j
public class LottoRegisterServletSession extends HttpServlet {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("LottoRegisterServletSession 호출");

        String username = request.getParameter("username");
        String loginId = request.getParameter("loginId");
        String password = request.getParameter("password");

        Member member = new Member(loginId, username, password);
        memberRepository.save(member);

        response.sendRedirect("/v3/servlet/jsp/login-form");
    }
}
