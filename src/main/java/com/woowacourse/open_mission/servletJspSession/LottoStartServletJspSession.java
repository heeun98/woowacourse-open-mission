package com.woowacourse.open_mission.servletJspSession;

import com.woowacourse.open_mission.domain.MemberTicketsRepository;
import com.woowacourse.open_mission.servletJspSession.frontController.LottoController;
import com.woowacourse.open_mission.servletJspSession.frontController.Session;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
//@WebServlet(name = "LottoStartServletJspSession", value = "/v3/servlet/jsp/lotto")
public class LottoStartServletJspSession implements LottoController {


    private final MemberTicketsRepository memberTicketsRepository = MemberTicketsRepository.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model, Session session) {
        int totalBuyCount = memberTicketsRepository.getTotalBuyCount();

        model.put("totalBuyCount", totalBuyCount);

        return "lotto-start";
    }

//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        log.info("LottoStartServletJsp 호출");
//
//
//        int totalBuyCount = memberTicketsRepository.getTotalBuyCount();
//        request.setAttribute("totalBuyCount", totalBuyCount);
//
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/viewsV2/lotto-start.jsp");
//
//        dispatcher.forward(request, response);
//
//    }
}
