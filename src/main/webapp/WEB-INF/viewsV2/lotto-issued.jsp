<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.woowacourse.open_mission.domain.IssuedLotto" %>
<%@ page import="com.woowacourse.open_mission.domain.Member" %>

<%
  Member member = (Member) request.getAttribute("member");
  List<IssuedLotto> issuedLottos = (List<IssuedLotto>) request.getAttribute("issuedLottos");
%>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>로또 구매 결과</title>

  <!-- Bootstrap -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

  <style>
    body {
      background-color: #fdf1f5; /* 파스텔 핑크 배경 */
      font-family: 'Noto Sans KR', sans-serif;
    }

    /* 카드 */
    .card-custom {
      width: 520px;
      background: #ffffff;
      border-radius: 14px;
      padding: 2rem;
      box-shadow: 0 4px 14px rgba(0,0,0,0.08);
    }

    /* 티켓 박스 */
    .ticket-box {
      background: #fff1f6; /* 연핑크 */
      border: 1px solid #f8cfe0;
      padding: 14px 20px;
      border-radius: 12px;
      margin-bottom: 12px;
      box-shadow: 0 2px 8px rgba(0,0,0,0.05);
    }

    /* 숫자 칩 */
    .ticket-number {
      display: inline-block;
      background: #ffe5ee; /* 더 연한 파스텔 핑크 */
      padding: 8px 13px;
      margin: 4px;
      border-radius: 50%;
      font-weight: bold;
      color: #cc5c82;
      border: 1px solid #f3bfd3;
    }

    /* 메인 버튼 */
    .btn-main {
      background-color: #f08fb0; /* 파스텔 로즈핑크 */
      border: none;
      color: white;
      font-weight: 600;
    }
    .btn-main:hover {
      background-color: #e66c97;
      color: white;
    }

    /* 서브 버튼 */
    .btn-outline-main {
      background: white;
      border: 2px solid #f08fb0;
      color: #f08fb0;
      font-weight: 600;
    }
    .btn-outline-main:hover {
      background: #f8d2e0;
      color: #e66c97;
      border-color: #e66c97;
    }
  </style>
</head>

<body class="d-flex justify-content-center align-items-start py-5">

<div class="card card-custom text-center">
  <h2 class="fw-bold mb-4" style="color:#d45f8c;">
    🎉 <%= member.getUsername() %> 님, 로또 <%= issuedLottos.size() %>장을 구매하셨습니다!
  </h2>

  <div class="mb-4">
    <%
      int index = 1;
      for (IssuedLotto issuedLotto : issuedLottos) {
        List<Integer> numbers = issuedLotto.getIssuedNumbers();
    %>
    <div class="ticket-box">
      <strong style="color:#d45f8c;"><%= index++ %>번 티켓</strong><br>
      <% for (Integer num : numbers) { %>
      <span class="ticket-number"><%= num %></span>
      <% } %>
    </div>
    <% } %>
  </div>

  <div class="d-grid gap-3 mt-3">
    <a class="btn btn-main" href="/v3/servlet/jsp/winning">🎯 당첨 번호 생성하기</a>
    <a class="btn btn-outline-main" href="/v3/servlet/jsp">⬅ 메인으로 돌아가기</a>
  </div>
</div>

</body>
</html>
