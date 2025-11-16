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
            background-color: #f2f7f3; /* 우테코 분위기의 은은한 그린톤 */
            height: 100vh;
            font-family: 'Noto Sans KR', sans-serif;
        }
        .login-box {
            width: 360px;
            background: #ffffff;
            border-radius: 12px;
            padding: 2.2rem;
            box-shadow: 0 2px 10px rgba(0,0,0,0.08);
        }

        /* 메인 버튼: 톤 다운 초록 */
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

        /* 회원가입 버튼: 깔끔한 outline + 연그린 */
        .btn-join {
            border: 2px solid #74c69d;
            color: #74c69d;
            font-weight: 500;
            background: white;
        }
        .btn-join:hover {
            background-color: #e8f4ee;
            color: #5cb78c;
        }

        /* 메인으로 돌아가기 버튼 */
        .btn-back {
            border: 1px solid #ced4da;
            color: #6c757d;
        }
        .btn-back:hover {
            background-color: #f1f3f5;
        }
    </style>
</head>

<body class="d-flex justify-content-center align-items-center">

<div class="login-box text-center">

    <h2 class="mb-4" style="font-weight:600;">🔐 로그인</h2>

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
    <form action="/v3/servlet/jsp/login" method="post">
        <input class="form-control mb-3"
               type="text"
               name="loginId"
               placeholder="아이디"
               required>

        <input class="form-control mb-3"
               type="password"
               name="password"
               placeholder="비밀번호"
               required>

        <button class="btn btn-main w-100" type="submit">
            로그인 하기
        </button>
    </form>

    <div class="mt-4">
        <a href="/v3/servlet/jsp/join-form" class="btn btn-join w-100">회원가입하기</a>
    </div>

    <div class="mt-4">
        <a href="/" class="btn btn-back w-100">⬅ 메인으로 돌아가기</a>
    </div>
</div>

</body>
</html>
