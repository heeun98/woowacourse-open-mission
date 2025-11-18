package com.woowacourse.open_mission.servletJspSession.servlet;

import jakarta.servlet.http.HttpSession;

public class LottoSession implements Session {

    private final HttpSession httpSession;


    public LottoSession(HttpSession httpSession) {
        this.httpSession = httpSession;
    }

    @Override
    public Object getAttribute(String name) {
        return httpSession.getAttribute(name);
    }

    @Override
    public void setAttribute(String name, Object value) {
        httpSession.setAttribute(name, value);
    }
}
