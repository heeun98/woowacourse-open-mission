<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<%
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
      background-color: #fce4ec; /* 파스텔 핑크 */
      font-family: 'Noto Sans KR', sans-serif;
    }

    .card-custom {
      width: 430px;
      border-radius: 14px;
      padding: 2.6rem 2.2rem;
      background: #ffffff;
      box-shadow: 0 4px 16px rgba(0,0,0,0.10);
      border: 3px solid #f8bbd0;
    }

    .stats-box {
      background: #f8bbd0;
      border-radius: 10px;
      padding: 12px 14px;
      font-size: 14px;
      color: #6b2f43;
      font-weight: 500;
    }

    .btn-main {
      background-color: #f48fb1;
      border: none;
      color: white;
      font-weight: 600;
    }
    .btn-main:hover {
      background-color: #ec7097;
      color: white;
    }

    .btn-outline-main {
      background-color: #ffffff;
      color: #f48fb1;
      border: 2px solid #f48fb1;
      font-weight: 600;
    }
    .btn-outline-main:hover {
      background-color: #f48fb1;
      color: white;
    }
  </style>
</head>

<body class="d-flex justify-content-center align-items-center" style="min-height: 100vh;">

<div class="card card-custom text-center">
  <h1 class="fw-bold mb-3" style="color:#f06292;">🎰 로또 구매하기</h1>

  <div class="stats-box mb-4">
    지금까지 판매된 로또 수: <strong><%= totalBuyCount %></strong> 장
  </div>

  <form action="/v3/servlet/jsp/buy" method="post" class="d-grid gap-3">
    <input class="form-control"
           style="border:2px solid #f8bbd0;"
           type="number"
           name="amount"
           placeholder="구매 금액 (예: 5000)"
           required>
    <button class="btn btn-main">구매하기</button>
  </form>

  <div class="d-grid gap-2 mt-4">
    <a href="/v3/servlet/jsp" class="btn btn-outline-main">
      ⬅ 메인으로 돌아가기
    </a>
  </div>
</div>

</body>
</html>
