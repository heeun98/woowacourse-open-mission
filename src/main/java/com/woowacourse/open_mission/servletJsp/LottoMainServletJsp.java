package com.woowacourse.open_mission.servletJsp;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import java.io.IOException;


@Slf4j
@WebServlet(name = "LottoMainJspServlet", urlPatterns = "/servlet/jsp")
public class LottoMainServletJsp extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("LottoMainServletJsp호출");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/lotto-main.jsp");
                
        
        dispatcher.forward(request, response);
    }
}
