package com.woowacourse.open_mission;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    private static Map<String, LottoCount> result;


    public LottoResult(String name) {
        result = new HashMap<>();
        result.put(name, new LottoCount());
    }

    public void addResult(String name, int matchingCount, boolean matchBonus) {
        result.get(name).addCount(matchingCount, matchBonus);
    }


    public LottoCount getResult(String name) {
        return result.get(name);
    }
}
