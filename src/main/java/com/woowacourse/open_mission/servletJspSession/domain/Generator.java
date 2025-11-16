package com.woowacourse.open_mission.servletJspSession.domain;

import java.util.List;

public interface Generator<T> {

    List<T> generate();
}
