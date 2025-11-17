package com.woowacourse.open_mission.servletJspSession;

import com.woowacourse.open_mission.Rank;
import com.woowacourse.open_mission.domain.*;
import com.woowacourse.open_mission.servletJspSession.frontController.LottoController;
import com.woowacourse.open_mission.servletJspSession.frontController.Session;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.Random;

@Slf4j
//@WebServlet(name = "LottoWinningServletJspSession", value = "/v3/servlet/jsp/winning")
public class LottoWinningServletJspSession implements LottoController {

    private final MemberResultRepository memberResultRepository = MemberResultRepository.getInstance();
    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model, Session session) {

        // 당첨 번호 생성
        NumberGenerator numberGenerator = new NumberGenerator();
        List<Integer> lottoNumbers = numberGenerator.generate();
        lottoNumbers.sort(Integer::compareTo);


        // 보너스 번호 생성
        Random random = new Random();
        int bonusNumber;
        while (true) {
            bonusNumber = random.nextInt(LottoConstant.END_NUMBER) + LottoConstant.START_NUMBER;
            if (!lottoNumbers.contains(bonusNumber)) break;
        }

        // Lotto 객체 생성
        Lotto lotto = new Lotto(lottoNumbers, bonusNumber);


        // member 세션에서 가져오기
        Long id = (Long) session.getAttribute("id");
        Member member = memberRepository.findById(id);

        List<IssuedLotto> issuedLottoList = (List<IssuedLotto>) session.getAttribute("issuedLotto");

        MemberResult memberResult = new MemberResult(member.getUsername());
        memberResult.initResult();


        issuedLottoList.stream()
                .map(issuedLotto -> issuedLotto.getIssuedNumbers())
                .forEach(numbers -> {
                    int count = lotto.matchCount(numbers);
                    boolean matchBonus = lotto.matchBonus(numbers);
                    String matchMessage = Rank.getMatchMessage(count, matchBonus);
                    if (matchMessage != null) {
                        memberResult.addResultCount(matchMessage);
                    }
                });
        memberResultRepository.addMemberResult(memberResult);


        session.setAttribute("memberResult", memberResult);


        model.put("lotto", lotto);
        model.put("member", member);


        return "lotto-winning";
    }

//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        Cookie[] cookies = request.getCookies();
//        if (cookies != null) {
//            for (Cookie cookie : cookies) {
//                log.info("cookie {} : {}", cookie.getName(), cookie.getValue());
//            }
//        } else {
//            log.info("쿠키 없음");
//        }
//
//        log.info("LottoWinningServletJsp 호출됨");
//
//        // 당첨 번호 생성
//        NumberGenerator numberGenerator = new NumberGenerator();
//        List<Integer> lottoNumbers = numberGenerator.generate();
//        lottoNumbers.sort(Integer::compareTo);
//
//        // 보너스 번호 생성
//        Random random = new Random();
//        int bonusNumber;
//        while (true) {
//            bonusNumber = random.nextInt(LottoConstant.END_NUMBER) + LottoConstant.START_NUMBER;
//            if (!lottoNumbers.contains(bonusNumber)) break;
//        }
//
//        // Lotto 객체 생성
//        Lotto lotto = new Lotto(lottoNumbers, bonusNumber);
//
//        // member 세션에서 가져오기
//        HttpSession session = request.getSession();
//        log.info(session.getId());
//        Long id = (Long) session.getAttribute("id");
//        Member member = memberRepository.findById(id);
//
//        List<IssuedLotto> issuedLottoList = (List<IssuedLotto>) session.getAttribute("issuedLotto");
//
//        MemberResult memberResult = new MemberResult(member.getUsername());
//        memberResult.initResult();
//
//        issuedLottoList.stream()
//                .map(issuedLotto -> issuedLotto.getIssuedNumbers())
//                .forEach(numbers -> {
//                    int count = lotto.matchCount(numbers);
//                    boolean matchBonus = lotto.matchBonus(numbers);
//                    String matchMessage = Rank.getMatchMessage(count, matchBonus);
//                    if (matchMessage != null) {
//                        memberResult.addResultCount(matchMessage);
//                    }
//                });
//        memberResultRepository.addMemberResult(memberResult);
//
//
//        session.setAttribute("memberResult", memberResult);
//
//
//        // JSP로 전달할 데이터 설정
//        request.setAttribute("lotto", lotto);
//
//        // 사용자 정보 넘기기
//        request.setAttribute("member", member);
//
//        // JSP 뷰로 forward
//        request.getRequestDispatcher("/WEB-INF/viewsV2/lotto-winning.jsp")
//                .forward(request, response);
//    }
}
