<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>로그인</title>

    <!-- Bootstrap CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background-color: #f8f9fa;
            height: 100vh;
        }
        .login-box {
            width: 350px;
            background: #ffffff;
            border-radius: 10px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.1);
            padding: 2rem;
        }
    </style>
</head>

<body class="d-flex justify-content-center align-items-center">

<div class="login-box text-center">

    <h2 class="mb-4">🔐 로그인</h2>

    <!-- 오류 메시지 출력 -->
    <%
        String error = (String) request.getAttribute("loginError");
        if (error != null) {
    %>
    <div class="alert alert-danger"><%= error %></div>
    <%
        }
    %>

    <!-- 로그인 Form -->
    <form action="/servlet/jsp/v2" method="post">
        <input class="form-control mb-3"
               type="text"
               name="username"
               placeholder="아이디"
               required>

        <input class="form-control mb-3"
               type="password"
               name="password"
               placeholder="비밀번호"
               required>

        <button class="btn btn-primary w-100" type="submit">
            로그인 하기
        </button>
    </form>

    <div class="mt-4">
        <a href="/" class="btn btn-outline-secondary w-100">⬅ 메인으로 돌아가기</a>
    </div>

    <div class="mt-4">
        <a href="/v3/servlet/jsp/join" class="btn btn-outline-secondary w-100">회원가입하기</a>
    </div>
</div>

</body>
</html>
