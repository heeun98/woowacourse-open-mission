package com.woowacourse.open_mission.servletJsp.domain;

import java.util.List;

public interface Generator<T> {

    List<T> generate();
}
