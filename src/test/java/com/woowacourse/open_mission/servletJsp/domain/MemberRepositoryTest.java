package com.woowacourse.open_mission.servletJsp.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Test
    @DisplayName("buyTotalCount에서 동시성 문제가 발생해야 한다.")
    void buyTotalCountConcurrencyIssue() throws InterruptedException {


        int threadCount = 1000;
        ExecutorService executor = Executors.newCachedThreadPool();
        CountDownLatch latch = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; i++) {
            executor.submit(() -> {
                try {
                    memberRepository.addTotalCount();
                } finally {
                    latch.countDown();
                }
            });
        }
        latch.await();
        executor.shutdown();

        int result = memberRepository.getTotalBuyCount();
        System.out.println("최종 buyTotalCount = " + result);

        assertNotEquals(1000, result);
    }

}