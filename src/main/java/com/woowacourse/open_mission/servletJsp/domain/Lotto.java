package com.woowacourse.open_mission.servletJsp.domain;

import java.util.List;

import static com.woowacourse.open_mission.servletJsp.domain.LottoConstant.*;

public class Lotto {

    private List<Integer> numbers; // 당첨 번호
    private int bonusNumber;

    public Lotto(List<Integer> numbers, int bonusNumber) {
        validateNumbers(numbers);
        validateBonusNumber(bonusNumber);
        validateDuplicate(numbers, bonusNumber);
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }


    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validateDuplicate(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateBonusNumber(int bonusNumber) {

        if (bonusNumber < START_NUMBER || bonusNumber > END_NUMBER) {
            throw new IllegalArgumentException();
        }
    }


    private void validateNumbers(List<Integer> numbers) {

        numbers.stream()
                .forEach(number -> {
                    if (number < START_NUMBER || number > END_NUMBER) {
                        throw new IllegalArgumentException();
                    }
                });
    }

    public int matchCount(List<Integer> lottoNumbers) {
       return (int) numbers.stream()
               .filter(number -> lottoNumbers.contains(number))
               .count();
    }




}
