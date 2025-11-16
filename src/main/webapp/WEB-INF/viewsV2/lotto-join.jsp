<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>회원가입</title>

  <!-- Bootstrap -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

  <style>
    body {
      background-color: #f8f9fa;
      height: 100vh;
    }
    .register-box {
      width: 380px;
      background: #ffffff;
      border-radius: 10px;
      box-shadow: 0 4px 12px rgba(0,0,0,0.1);
      padding: 2rem;
    }
  </style>
</head>

<body class="d-flex justify-content-center align-items-center">

<div class="register-box">
  <h2 class="text-center mb-4 fw-bold">📝 회원가입</h2>

  <form action="/servlet/jsp/register" method="post">
    <div class="mb-3">
      <label class="form-label">이름</label>
      <input type="text" name="name" class="form-control" placeholder="홍길동" required>
    </div>

    <div class="mb-3">
      <label class="form-label">아이디</label>
      <input type="text" name="username" class="form-control" placeholder="아이디를 입력하세요" required>
    </div>

    <div class="mb-3">
      <label class="form-label">비밀번호</label>
      <input type="password" name="password" class="form-control" placeholder="비밀번호 입력" required>
    </div>

    <div class="mb-3">
      <label class="form-label">비밀번호 확인</label>
      <input type="password" name="passwordCheck" class="form-control" placeholder="비밀번호 재입력" required>
    </div>

    <button type="submit" class="btn btn-primary w-100 mt-3">회원가입</button>
  </form>

  <div class="text-center mt-3">
    <a href="/v3/servlet/jsp/login" class="text-decoration-none">이미 계정이 있으신가요? 로그인</a>
  </div>
</div>

</body>
</html>
