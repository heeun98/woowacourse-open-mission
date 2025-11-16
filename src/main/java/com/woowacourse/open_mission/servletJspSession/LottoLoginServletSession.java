package com.woowacourse.open_mission.servletJspSession;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "LottoLoginServletSession", value = "/v3/servlet/jsp/login")
public class LottoLoginServletSession extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setAttribute();

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/viewsV2/lotto-login.jsp");
        dispatcher.forward(request, response);
    }
}
