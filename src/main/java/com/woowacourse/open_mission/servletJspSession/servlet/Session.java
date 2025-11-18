package com.woowacourse.open_mission.servletJspSession.servlet;

public interface Session {

    Object getAttribute(String name);
    void setAttribute(String name, Object value);
}
