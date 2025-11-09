package com.woowacourse.open_mission;

import java.util.List;
import java.util.stream.Stream;

public enum Rank {

    THREE_MATCH(3,false, "3개 일치 (5,000원)"),
    FOUR_MATCH(4, false, "4개 일치 (50,000원)"),
    FIVE_MATCH(5, false, "5개 일치 (1,500,000원)"),
    FIVE_BONUS_MATCH(5, true, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    SIX_MATCH(6,false, "6개 일치 (2,000,000,000원)");


    Rank(int matchCount, boolean haveBonus, String message) {
        this.matchCount = matchCount;
        this.haveBonus = haveBonus;
        this.message = message;
    }

    private int matchCount;
    private boolean haveBonus;
    private String message;

    public static String getMatchMessage(int matchCount, boolean haveBonus) {
        for (Rank value : values()) {
            if (value.matchCount == matchCount && value.haveBonus == haveBonus) {
                return value.message;
            }
        }
        return null;
    }

    public static List<String> getAllMessage() {

        return Stream.of(values())
                .map(i -> i.message)
                .toList();

    }


    public String getMessage() {
        return message;
    }
}
