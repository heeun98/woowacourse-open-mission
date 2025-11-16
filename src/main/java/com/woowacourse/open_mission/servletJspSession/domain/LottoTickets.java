package com.woowacourse.open_mission.servletJspSession.domain;

import com.woowacourse.open_mission.servletJsp.domain.IssuedLotto;
import com.woowacourse.open_mission.servletJsp.domain.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

import static com.woowacourse.open_mission.servletJsp.domain.LottoConstant.*;

public class LottoTickets {

    private List<com.woowacourse.open_mission.servletJsp.domain.IssuedLotto> issuedLottoList;
    private int amount;

    public LottoTickets(int amount) {
        this.issuedLottoList = new ArrayList<>();
        this.amount = amount;
    }

    public List<com.woowacourse.open_mission.servletJsp.domain.IssuedLotto> buyTickets() {
        if (amount % TICKET_PRICE != 0) {
            throw new IllegalArgumentException();
        }

        NumberGenerator numberGenerator = new NumberGenerator();
        for (int i = 0; i < getTicketSize(amount); i++) {
            com.woowacourse.open_mission.servletJsp.domain.IssuedLotto issuedLotto = new IssuedLotto(numberGenerator);
            issuedLottoList.add(issuedLotto);
        }

        return issuedLottoList;
    }

    private int getTicketSize(int amount) {
        return amount / TICKET_PRICE;
    }

}
