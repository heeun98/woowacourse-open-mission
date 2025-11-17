package com.woowacourse.open_mission.servletJspSession.frontController;


import jakarta.servlet.http.HttpSession;

public class LottoSession implements Session {

    private final HttpSession httpSession;


    public LottoSession(HttpSession httpSession) {
        this.httpSession = httpSession;
    }

    @Override
    public Object getAttribute(String name) {
        return null;
    }

    @Override
    public void setAttribute(String name, Object value) {

    }
}
