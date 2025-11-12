<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>로또 구매</title>
  <!-- Bootstrap CDN -->
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
  </style>
</head>

<body class="d-flex justify-content-center align-items-center">

<div class="lotto-form text-center">
  <h1 class="mb-4">🎰 로또 구매하기</h1>

  <form action="/servlet/lotto/buy" method="post">
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
