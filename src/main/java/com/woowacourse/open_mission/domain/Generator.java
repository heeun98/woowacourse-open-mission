package com.woowacourse.open_mission.domain;

import java.util.List;

public interface Generator<T> {

    List<T> generate();
}
