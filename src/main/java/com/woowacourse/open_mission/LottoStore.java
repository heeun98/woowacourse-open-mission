package com.woowacourse.open_mission;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoStore {


    // key: 이름 , value : 티켓들 (여러장)
    private static Map<String, List<List<Integer>>> randomNumber = new HashMap<>();


    public void initTickets(String name, int ticketSize) {

        List<List<Integer>> lists = randomNumber.get(name);

        for (int i = 0; i < ticketSize; i++) {
            lists.add(new ArrayList<>());
        }

    }

    public void saveTicket(String name, List<Integer> ticket) {

        List<List<Integer>> lists = randomNumber.get(name);
        lists.add(ticket);
    }


    public List<List<Integer>> getTickets(String name) {
        return randomNumber.get(name);
    }


}
