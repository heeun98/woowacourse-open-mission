<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="com.woowacourse.open_mission.domain.Lotto" %>
<%@ page import="java.util.List" %>
<%@ page import="com.woowacourse.open_mission.domain.Member" %>

<%
  Member member = (Member) request.getAttribute("member");
  String name = member.getUsername();
  Lotto lotto = (Lotto) request.getAttribute("lotto");
  List<Integer> numbers = lotto.getNumbers();
  int bonus = lotto.getBonusNumber();
%>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>로또 당첨 번호 생성</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

  <style>
    body {
      background-color: #fff5f7; /* 은은한 핑크 파스텔 */
      font-family: 'Noto Sans KR', sans-serif;
    }

    /* 카드 스타일 */
    .card-custom {
      width: 500px;
      border-radius: 16px;
      padding: 2.3rem;
      background: #ffffff;
      box-shadow: 0 4px 14px rgba(0,0,0,0.08);
      border: 2px solid #ffe3ec; /* 핑크 테두리 */
    }

    /* 로또 번호 */
    .lotto-number {
      display: inline-block;
      background: #ffe3ec; /* 파스텔 핑크 */
      color: #d63384; /* 진한 포인트 핑크 */
      padding: 12px 17px;
      border-radius: 50%;
      margin: 5px;
      font-weight: bold;
      font-size: 18px;
      box-shadow: 0 2px 6px rgba(0,0,0,0.05);
    }

    /* 보너스 번호 */
    .bonus-number {
      color: #d63384;
      font-weight: 700;
      background: #ffe8f0;
      padding: 10px 14px;
      border-radius: 8px;
      display: inline-block;
    }

    /* 메인 버튼 */
    .btn-main {
      background-color: #ff8fa3;
      border: none;
      color: white;
      font-weight: 600;
    }
    .btn-main:hover {
      background-color: #ff6b89;
      color: white;
    }

    /* 보조 버튼 */
    .btn-outline-main {
      background-color: #ffffff;
      color: #ff8fa3;
      border: 2px solid #ff8fa3;
      font-weight: 600;
    }
    .btn-outline-main:hover {
      background-color: #ff8fa3;
      color: white;
      border-color: #ff8fa3;
    }
  </style>
</head>

<body class="d-flex justify-content-center align-items-center" style="min-height: 100vh;">

<div class="card card-custom text-center">
  <h3 class="fw-bold mb-3" style="color:#d63384;">🎀 이번 회차 당첨 번호</h3>

  <p class="text-muted mb-4">
    <%= name != null ? name : "사용자" %> 님을 위한 당첨 번호입니다.
  </p>

  <!-- 번호들 -->
  <div class="mb-3">
    <% for (Integer num : numbers) { %>
    <span class="lotto-number"><%= num %></span>
    <% } %>
  </div>

  <!-- 보너스 -->
  <h5 class="bonus-number mb-4">
    🎁 보너스 번호 <%= bonus %>
  </h5>

  <!-- 버튼 -->
  <div class="d-grid gap-3">
    <a class="btn btn-main" href="/v3/servlet/jsp/current-result">
      당첨 결과 확인하기
    </a>
    <a class="btn btn-outline-main" href="/v3/servlet/jsp">
      ⬅ 메인으로 돌아가기
    </a>
  </div>
</div>

</body>
</html>
