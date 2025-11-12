package com.woowacourse.open_mission.servlet.domain;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class LottoResult {

    private static Map<String, LottoCount> result = new HashMap<>();


    public LottoResult(String name) {
        result.put(name, new LottoCount());
    }

    public void addResult(String name, int matchingCount, boolean matchBonus) {
        result.get(name).addCount(matchingCount, matchBonus);
    }


    public static Map<String, Integer> getResult(String name) {

        LottoCount lottoCount = result.get(name);
        Map<String, Integer> count = lottoCount.getCount();
        return count;
    }

    public static void printResultData(String name) {
        getResult(name).entrySet().stream()
                .forEach(entry -> {
                            String key = entry.getKey();
                            Integer value = entry.getValue();
                            log.info("{}- {}", key, value);
                        }
                );
    }
}