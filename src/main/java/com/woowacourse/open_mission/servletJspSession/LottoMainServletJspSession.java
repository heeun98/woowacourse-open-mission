package com.woowacourse.open_mission.servletJspSession;

import com.woowacourse.open_mission.domain.Member;
import com.woowacourse.open_mission.domain.MemberRepository;
import com.woowacourse.open_mission.servletJspSession.frontController.LottoController;
import com.woowacourse.open_mission.servletJspSession.frontController.Session;
import lombok.extern.slf4j.Slf4j;
import java.util.Map;


@Slf4j
//@WebServlet(name = "LottoMainServletJspSession", urlPatterns = "/v3/servlet/jsp")
public class LottoMainServletJspSession implements LottoController {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model, Session session) {

        Long id = (Long) session.getAttribute("id");
        Member member = memberRepository.findById(id);

        model.put("member", member);

        return "lotto-main";
    }

//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        log.info("LottoMainServletJsp호출");
//        HttpSession session = request.getSession();
//        Long id = (Long) session.getAttribute("id");
//        Member member = memberRepository.findById(id);
//        request.setAttribute("member", member);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/viewsV2/lotto-main.jsp");
//
//
//        dispatcher.forward(request, response);
//    }
}
