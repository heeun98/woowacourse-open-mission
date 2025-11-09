package com.woowacourse.open_mission;

import java.util.HashMap;
import java.util.Map;

public class LottoCount {

    private Map<String, Integer> count;

    public LottoCount() {
        count = new HashMap<>();
        initMap();
    }

    private void initMap() {
        for (String message : Rank.getAllMessage()) {
            count.put(message, 0);
        }
    }

    public void addCount(int matchingCount, boolean matchBonus) {

        String message = Rank.getMatchMessage(matchingCount, matchBonus);
        if (message != null) {
            count.put(message, count.get(message) + 1);
        }

    }

    public Map<String, Integer> getCount() {
        return count;
    }
}
