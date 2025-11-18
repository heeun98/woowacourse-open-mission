package com.woowacourse.open_mission.servletJspSession.servlet;

import com.woowacourse.open_mission.servletJspSession.*;
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
        controllerMap.put("/v3/servlet/jsp/current-result", new LottoCurrentResultServletSession());
        controllerMap.put("/v3/servlet/jsp/history", new LottoHistoryServletJspSession());
        controllerMap.put("/v3/servlet/jsp/join-form", new LottoJoinFormServlet());
        controllerMap.put("/v3/servlet/jsp/login-form", new LottoLoginFormServletSession());
        controllerMap.put("/v3/servlet/jsp/login", new LottoLoginServletSession());
        controllerMap.put("/v3/servlet/jsp", new LottoMainServletJspSession());
        controllerMap.put("/v3/servlet/jsp/register", new LottoRegisterServletSession());
        controllerMap.put("/v3/servlet/jsp/result", new LottoResultServletJspSession());
        controllerMap.put("/v3/servlet/jsp/lotto", new LottoStartServletJspSession());
        controllerMap.put("/v3/servlet/jsp/winning", new LottoWinningServletJspSession());
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
