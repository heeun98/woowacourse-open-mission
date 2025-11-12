package com.woowacourse.open_mission.servletJsp.domain;

import java.util.List;

import static com.woowacourse.open_mission.servletJsp.domain.LottoConstant.*;

public class LottoTickets {


    private List<IssuedLotto> issuedLottoList;


    public List<IssuedLotto> buyTickets(int amount) {
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
