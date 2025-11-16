<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<%
  // 서블릿에서 전달된 누적 판매 개수 읽기
  Integer totalBuyCount = (Integer) request.getAttribute("totalBuyCount");
  if (totalBuyCount == null) totalBuyCount = 0;
%>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>로또 구매</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

  <style>
    body {
      background-color: #f8f9fa;
      height: 100vh;
    }
    .lotto-form {
      width: 350px;
      background: #ffffff;
      border-radius: 10px;
      box-shadow: 0 4px 12px rgba(0,0,0,0.1);
      padding: 2rem;
    }
    .stats-box {
      background: #f1f3f5;
      border-radius: 8px;
      padding: 10px;
      font-size: 14px;
      color: #495057;
    }
  </style>
</head>

<body class="d-flex justify-content-center align-items-center">

<div class="lotto-form text-center">
  <h1 class="mb-3">🎰 로또 구매하기</h1>

  <!-- 누적 판매량 표시 -->
  <div class="stats-box mb-3">
     지금까지 판매된 로또 수: <strong><%= totalBuyCount %></strong> 장
  </div>

  <form action="/servlet/jsp/buy" method="post">
    <input class="form-control mb-3" type="text" name="name" placeholder="이름을 입력하세요" required>
    <input class="form-control mb-3" type="number" name="amount" placeholder="구매 금액 (예: 5000)" required>
    <button class="btn btn-primary w-100" type="submit">구매하기</button>
  </form>

  <div class="mt-4">
    <a href="/servlet/jsp" class="btn btn-outline-secondary w-100">⬅ 메인으로 돌아가기</a>
  </div>
</div>

</body>
</html>
