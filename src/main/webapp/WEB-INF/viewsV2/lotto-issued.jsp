<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.woowacourse.open_mission.servletJsp.domain.IssuedLotto" %>

<%
  String name = (String) request.getAttribute("name");
  List<IssuedLotto> issuedLottos = (List<IssuedLotto>) request.getAttribute("issuedLottos");
%>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>로또 구매 결과</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

  <style>
    body {
      background-color: #f8f9fa;
    }

    /* 카드 스타일 */
    .card-custom {
      width: 520px;
      border-radius: 12px;
      padding: 2rem;
      box-shadow: 0 4px 12px rgba(0,0,0,0.08);
    }

    /* 티켓 박스 */
    .ticket-box {
      display: inline-block;
      padding: 12px 20px;
      border-radius: 10px;
      border: 1px solid #ddd;
      margin: 6px;
      font-size: 18px;
      background: #ffffff;
      box-shadow: 0 2px 6px rgba(0,0,0,0.05);
    }

    .ticket-number {
      display:inline-block;
      background:#e8f4ee;
      padding:6px 12px;
      border-radius:50%;
      margin:3px;
      font-weight:bold;
    }

    /* 메인 버튼 */
    .btn-main {
      background-color: #74c69d;
      border: none;
      color: white;
      font-weight: 500;
    }
    .btn-main:hover {
      background-color: #5cb78c;
      color: white;
    }

    /* 보조 버튼 */
    .btn-outline-main {
      background-color: #ffffff;
      color: #74c69d;
      border: 2px solid #74c69d;
      font-weight: 500;
    }
    .btn-outline-main:hover {
      background-color: #5cb78c;
      color: white;
      border-color: #5cb78c;
    }
  </style>
</head>

<body class="d-flex flex-column align-items-center py-5">

<div class="card card-custom text-center">
  <h2 class="fw-bold mb-4">🎉 <%= name %> 님, 로또를 <%= issuedLottos.size() %>장 구매하셨습니다!</h2>
  <hr>

  <div class="mb-4">
    <%
      int index = 1;
      for (IssuedLotto issuedLotto : issuedLottos) {
        List<Integer> numbers = issuedLotto.getIssuedNumbers();
    %>
    <div class="ticket-box mb-2">
      <strong><%= index++ %>번 티켓</strong><br>
      <% for (Integer num : numbers) { %>
      <span class="ticket-number"><%= num %></span>
      <% } %>
    </div>
    <% } %>
  </div>

  <hr class="my-4">

  <div class="d-grid gap-3">
    <a class="btn btn-main" href="/v3/servlet/jsp/winning">🎯 당첨 번호 생성하기</a>
    <a class="btn btn-outline-main" href="/v3/servlet/jsp">⬅ 메인으로 돌아가기</a>
  </div>
</div>

</body>
</html>
