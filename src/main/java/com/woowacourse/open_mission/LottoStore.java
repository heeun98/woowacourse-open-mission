package com.woowacourse.open_mission;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class LottoStore {


    // key: 이름 , value : 티켓들 (여러장)
    private static Map<String, List<List<Integer>>> randomNumber = new HashMap<>();
    private static LottoStore lottoStore = new LottoStore();


    public Map<String, List<List<Integer>>>  getRandomNumber() {
        return Map.copyOf(randomNumber);
    }

    public void initTickets(String name) {
        randomNumber.putIfAbsent(name, new ArrayList<>());
    }

    public void saveTicket(String name, List<Integer> ticket) {

        List<List<Integer>> lists = randomNumber.get(name);
        lists.add(ticket);
    }


    public List<List<Integer>> getTickets(String name) {
        return randomNumber.get(name);
    }

    private LottoStore() {

    };

    public static LottoStore getInstance() {
        return lottoStore;
    }

    public void printCurrentStatus() {
        log.info("발행된 숫자들");
        log.info(randomNumber.toString());
    }


}
