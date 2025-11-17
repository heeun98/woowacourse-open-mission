package com.woowacourse.open_mission.domain;

import java.util.ArrayList;
import java.util.List;

import static com.woowacourse.open_mission.domain.LottoConstant.*;

public class LottoTickets {

    private List<IssuedLotto> issuedLottoList;
    private int amount;

    public LottoTickets(int amount) {
        this.issuedLottoList = new ArrayList<>();
        this.amount = amount;
    }

    public List<IssuedLotto> buyTickets() {
        if (amount % TICKET_PRICE != 0) {
            throw new IllegalArgumentException();
        }

        NumberGenerator numberGenerator = new NumberGenerator();
        for (int i = 0; i < getTicketSize(amount); i++) {
            IssuedLotto issuedLotto = new IssuedLotto(numberGenerator);
            issuedLottoList.add(issuedLotto);
        }

        return issuedLottoList;
    }

    private int getTicketSize(int amount) {
        return amount / TICKET_PRICE;
    }

}
