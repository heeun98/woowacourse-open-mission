package com.woowacourse.open_mission;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class LottoService {


    // key: 이름 , value : 티켓들 (여러장)
    private static Map<String, List<List<Integer>>> randomNumber = new HashMap<>();
    private static LottoService lottoService = new LottoService();



    //싱글톤
    private LottoService() {
    };


    /**
     * @param name : 사용자 이름
     * @param numbers : 당첨번호
     */
    public void countMatchCount(String name, List<Integer> numbers, int bonus) {

        List<List<Integer>> lists = randomNumber.get(name);
        LottoResult lottoResult = new LottoResult(name);

        for (List<Integer> list : lists) {
            int count = matchCount(list, numbers);
            boolean matchBonus = matchBonus(list, bonus);
            lottoResult.addResult(name, count, matchBonus);
        }
    }

    private boolean matchBonus(List<Integer> list, int bonus) {
        return list.contains(bonus);
    }

    private int matchCount(List<Integer> list, List<Integer> numbers) {

        return (int) list.stream()
                .filter(i -> numbers.contains(i))
                .count();
    }


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
        return List.copyOf(randomNumber.get(name));
    }


    public static LottoService getInstance() {
        return lottoService;
    }

    public void deleteAllTickets(String name) {
        randomNumber.remove(name);
    }

    public void printTickets(String name) {
        log.info("발행된 숫자들");
        log.info("-------");
        randomNumber.get(name).stream()
                .forEach(list -> log.info(list.toString()));
        log.info("-------");
    }

}
