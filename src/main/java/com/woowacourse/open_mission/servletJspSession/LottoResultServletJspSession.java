package com.woowacourse.open_mission.servletJspSession;


import com.woowacourse.open_mission.domain.MemberResult;
import com.woowacourse.open_mission.domain.MemberResultRepository;
import com.woowacourse.open_mission.servletJspSession.frontController.LottoController;
import com.woowacourse.open_mission.servletJspSession.frontController.Session;

import java.util.Map;

//@WebServlet(name = "LottoResultServletJspSession", value = "/v3/servlet/jsp/result")
public class LottoResultServletJspSession implements LottoController {

    MemberResultRepository memberResultRepository = MemberResultRepository.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model, Session session) {
        Long resultId = Long.valueOf(paramMap.get("resultId"));
        MemberResult memberResult = memberResultRepository.getMemberResultById(resultId);
        model.put("memberResult", memberResult);
        return "lotto-result";
    }

//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Long resultId = Long.valueOf(request.getParameter("resultId"));
//        MemberResult memberResult = memberResultRepository.getMemberResultById(resultId);
//        request.setAttribute("memberResult", memberResult);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/viewsV2/lotto-result.jsp");
//        dispatcher.forward(request, response);
//    }
}
