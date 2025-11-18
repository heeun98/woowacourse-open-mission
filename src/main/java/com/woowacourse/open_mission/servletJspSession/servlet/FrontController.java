package com.woowacourse.open_mission.servletJspSession.servlet;

import com.woowacourse.open_mission.servletJspSession.handler.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@WebServlet(name = "FrontController", value = "/v3/servlet/jsp/*")
public class FrontController extends HttpServlet {

    private Map<String, LottoController> controllerMap = new HashMap<>();

    public FrontController() {
        controllerMap.put("/v3/servlet/jsp/buy", new LottoBuyController());
        controllerMap.put("/v3/servlet/jsp/current-result", new LottoCurrentResultController());
        controllerMap.put("/v3/servlet/jsp/history", new LottoHistoryController());
        controllerMap.put("/v3/servlet/jsp/join-form", new LottoJoinFormController());
        controllerMap.put("/v3/servlet/jsp/login-form", new LottoLoginFormController());
        controllerMap.put("/v3/servlet/jsp/login", new LottoLoginController());
        controllerMap.put("/v3/servlet/jsp", new LottoMainController());
        controllerMap.put("/v3/servlet/jsp/register", new LottoRegisterController());
        controllerMap.put("/v3/servlet/jsp/result", new LottoResultController());
        controllerMap.put("/v3/servlet/jsp/lotto", new LottoStartController());
        controllerMap.put("/v3/servlet/jsp/winning", new LottoWinningController());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String uri = request.getRequestURI();

        LottoController controller = controllerMap.get(uri);

        Map<String, String> paramMap = createParamMap(request);
        Map<String, Object> model = new HashMap<>();
        LottoSession session = new LottoSession(request.getSession());

        log.info("호출 : " + request.getRequestURI());
        String viewName = controller.process(paramMap, model, session);

        if (viewName.startsWith("redirect:")) {
            String redirectPath = viewName.substring("redirect:".length());
            response.sendRedirect(redirectPath);
            return;
        }

        View view = viewResolver(viewName);
        view.render(model, request, response);
    }

    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(param -> paramMap.put(param, request.getParameter(param)));

        return paramMap;
    }

    private View viewResolver(String viewName) {
        return new View("/WEB-INF/viewsV2/" + viewName + ".jsp");
    }



}
