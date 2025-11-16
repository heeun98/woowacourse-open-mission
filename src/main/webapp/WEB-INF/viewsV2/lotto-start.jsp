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
    }

    /* 카드 스타일 */
    .card-custom {
      width: 400px;
      border-radius: 12px;
      padding: 2.5rem 2rem;
      box-shadow: 0 4px 12px rgba(0,0,0,0.1);
    }

    /* 통계 박스 */
    .stats-box {
      background: #e8f4ee;
      border-radius: 8px;
      padding: 10px 12px;
      font-size: 14px;
      color: #495057;
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

<body class="d-flex justify-content-center align-items-center" style="min-height: 100vh;">

<div class="card card-custom text-center">
  <h1 class="fw-bold mb-3">🎰 로또 구매하기</h1>

  <!-- 누적 판매량 표시 -->
  <div class="stats-box mb-4">
    지금까지 판매된 로또 수: <strong><%= totalBuyCount %></strong> 장
  </div>

  <!-- 구매 폼 -->
  <form action="/v3/servlet/jsp/buy" method="post" class="d-grid gap-3">
    <input class="form-control" type="text" name="name" placeholder="이름을 입력하세요" required>
    <input class="form-control" type="number" name="amount" placeholder="구매 금액 (예: 5000)" required>
    <button class="btn btn-main">구매하기</button>
  </form>

  <!-- 메인으로 돌아가기 -->
  <div class="d-grid gap-2 mt-4">
    <a href="/v3/servlet/jsp" class="btn btn-outline-main">
      ⬅ 메인으로 돌아가기
    </a>
  </div>
</div>

</body>
</html>
