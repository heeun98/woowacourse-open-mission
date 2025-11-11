package com.woowacourse.open_mission.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LottoMainServlet", urlPatterns = "/servlet")

public class LottoMainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.write("""
                <!DOCTYPE html>
                       <html lang="ko">
                       <head>
                           <meta charset="UTF-8">
                           <title>로또 서비스</title>
                           <!-- Bootstrap Full CSS -->
                           <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
                       </head>
                       <body class="d-flex flex-column justify-content-center align-items-center text-center" style="height:100vh;">
                       <h1 class="mb-4">🎰 로또 서비스</h1>
                       <div class="d-flex gap-3">
                           <a class="btn btn-primary btn-lg" href="/servlet/lotto">로또 시작하기</a>
                           <a class="btn btn-secondary btn-lg" href="/servlet/history">조회하기</a>
                       </div>
                       </body>
                       </html>
                """);
    }
}
