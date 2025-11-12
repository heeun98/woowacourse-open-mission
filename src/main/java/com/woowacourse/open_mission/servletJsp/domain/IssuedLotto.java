package com.woowacourse.open_mission.servletJsp.domain;

import java.util.List;

public class IssuedLotto {


    private List<Integer> issuedNumbers;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;

    public IssuedLotto(List<Integer> issuedNumbers) {
        validate(issuedNumbers);
        this.issuedNumbers = issuedNumbers;
    }

    private void validate(List<Integer> issuedNumbers) {

        issuedNumbers.stream()
                .forEach(number -> {
                    if (number < START_NUMBER || number > END_NUMBER) {
                        throw new IllegalArgumentException();
                    }
                });
    }


}
