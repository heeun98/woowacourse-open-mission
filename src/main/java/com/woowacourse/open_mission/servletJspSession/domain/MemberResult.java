package com.woowacourse.open_mission.servletJspSession.domain;

import com.woowacourse.open_mission.Rank;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberResult {


    private final String name;
    private final LocalDate createdAt;
    private Map<String, Integer> result;// key: 6개 일치 (2,000,000,000원) value : 개수

    public MemberResult(String name) {
        this.name = name;
        this.createdAt = LocalDate.now();
        result = new HashMap<>();
    }

    public void initResult() {
        Rank.getAllMessages().stream()
                .forEach(s -> result.put(s, 0));
    }

    public void addResultCount(String message) {
        result.put(message, result.get(message) + 1);
    }


    public String getName() {
        return name;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public Map<String, Integer> getResult() {
        return result;
    }

}
