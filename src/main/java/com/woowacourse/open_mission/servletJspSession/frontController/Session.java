package com.woowacourse.open_mission.servletJspSession.frontController;

public interface Session {

    Object getAttribute(String name);
    void setAttribute(String name, Object value);
}
