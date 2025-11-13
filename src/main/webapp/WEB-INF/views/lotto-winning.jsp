<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="com.woowacourse.open_mission.servletJsp.domain.Lotto" %>
<%@ page import="java.util.List" %>

<%
  String name = (String) request.getAttribute("name");
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
    .lotto-number {
      display:inline-block;
      background:#f1f1f1;
      padding:8px 12px;
      border-radius:50%;
      margin:5px;
      font-weight:bold;
      font-size:18px;
    }
  </style>
</head>
<body class="bg-light">

<div class="container text-center py-5">
  <div class="card shadow-sm mx-auto" style="max-width:600px;">
    <div class="card-body">
      <h3 class="mb-3">🎯 이번 회차 당첨 번호</h3>
      <p class="text-muted">
        <%= name != null ? name : "사용자" %> 님을 위한 당첨 번호가 생성되었습니다.
      </p>

      <div class="mt-4 mb-4">
        <% for (Integer num : numbers) { %>
        <span class="lotto-number"><%= num %></span>
        <% } %>
      </div>

      <h5 class="text-success">보너스 번호 🎁 <%= bonus %></h5>

      <div class="mt-4">
        <a class="btn btn-success btn-lg" href="/servlet/jsp/current-result?name=<%= name %>">당첨 결과 확인하기</a>
        <a class="btn btn-outline-secondary btn-lg" href="/servlet/jsp">메인으로</a>
      </div>
    </div>
  </div>
</div>

</body>
</html>
