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
    .ticket-box {
      display: inline-block;
      padding: 10px 18px;
      border-radius: 8px;
      border: 1px solid #ddd;
      margin: 6px;
      font-size: 18px;
      background: #ffffff;
    }
    .ticket-number {
      display:inline-block;
      background:#f1f1f1;
      padding:5px 10px;
      border-radius:6px;
      margin:2px;
      font-weight:bold;
    }
  </style>
</head>

<body class="container text-center py-5">

<h2 class="mb-4">🎉 <%= name %> 님, 로또를 <%= issuedLottos.size() %>장 구매하셨습니다!</h2>
<hr>

<%
  int index = 1;
  for (IssuedLotto issuedLotto : issuedLottos) {
    List<Integer> numbers = issuedLotto.getIssuedNumbers();
%>
<div class="ticket-box">
  <strong><%= index++ %>번 티켓</strong><br>
  <% for (Integer num : numbers) { %>
  <span class="ticket-number"><%= num %></span>
  <% } %>
</div><br>
<%
  }
%>

<hr class="my-4">
<a class="btn btn-success btn-lg" href="/servlet/jsp/winning/v2">🎯 당첨 번호 생성하기</a>

<div class="mt-4">
  <a class="btn btn-outline-secondary" href="/servlet/jsp/v2">메인으로 돌아가기</a>
</div>

</body>
</html>
