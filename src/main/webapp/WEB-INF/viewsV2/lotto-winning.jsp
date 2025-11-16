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
    body {
      background-color: #f8f9fa;
    }

    /* 카드 스타일 */
    .card-custom {
      width: 500px;
      border-radius: 12px;
      padding: 2rem;
      box-shadow: 0 4px 12px rgba(0,0,0,0.08);
    }

    /* 로또 번호 */
    .lotto-number {
      display: inline-block;
      background: #e8f4ee;
      padding: 12px 16px;
      border-radius: 50%;
      margin: 5px;
      font-weight: bold;
      font-size: 18px;
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

    .bonus-number {
      color: #74c69d;
      font-weight: bold;
    }
  </style>
</head>

<body class="d-flex justify-content-center align-items-center" style="min-height: 100vh;">

<div class="card card-custom text-center">
  <h3 class="fw-bold mb-3">🎯 이번 회차 당첨 번호</h3>

  <p class="text-muted mb-4">
    <%= name != null ? name : "사용자" %> 님을 위한 당첨 번호가 생성되었습니다.
  </p>

  <div class="mb-3">
    <% for (Integer num : numbers) { %>
    <span class="lotto-number"><%= num %></span>
    <% } %>
  </div>

  <h5 class="bonus-number mb-4">보너스 번호 🎁 <%= bonus %></h5>

  <div class="d-grid gap-3">
    <a class="btn btn-main" href="/v3/servlet/jsp/current-result?name=<%= name %>">
      당첨 결과 확인하기
    </a>
    <a class="btn btn-outline-main" href="/v3/servlet/jsp">
      ⬅ 메인으로 돌아가기
    </a>
  </div>
</div>

</body>
</html>
