package com.woowacourse.open_mission.servlet;

import camp.nextstep.edu.missionutils.Randoms;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;



@Slf4j
public class LottoBuyServlet extends HttpServlet {

    private static final String AMOUNT_PATTERN = "^\\d+$";
    private static final int UNIT_PRICE = 1000;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int COUNT = 6;


    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {


        String name = request.getParameter("name");
        int amount = Integer.parseInt(request.getParameter("amount"));


        if (Pattern.matches(AMOUNT_PATTERN, String.valueOf(amount))) {
            throw new IllegalArgumentException("금액은 숫자만 입력 가능합니다.");
        }
        if (amount % UNIT_PRICE != 0) {
            throw new IllegalArgumentException("1000원 단위만 입력 가능합니다.");
        }

        int ticketSize = amount / UNIT_PRICE;
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, COUNT);


    }


}
