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
            background-color: #fdeef4; /* 부드러운 파스텔 핑크 */
            height: 100vh;
            font-family: 'Noto Sans KR', sans-serif;
        }

        .login-box {
            width: 360px;
            background: #ffffff;
            border-radius: 14px;
            padding: 2.4rem;
            box-shadow: 0 2px 12px rgba(0,0,0,0.1);
        }

        /* 메인 버튼: 파스텔 로즈핑크 */
        .btn-main {
            background-color: #f5a9c5;
            border: none;
            color: white;
            font-weight: 600;
        }
        .btn-main:hover {
            background-color: #f08fb5;
            color: white;
        }

        /* 회원가입 버튼: 핑크 라인 + 연핑 */
        .btn-join {
            border: 2px solid #f5a9c5;
            color: #f5a9c5;
            font-weight: 600;
            background: white;
        }
        .btn-join:hover {
            background-color: #fde3ed;
            color: #f08fb5;
        }

        /* 메인으로 돌아가기 버튼: 그레이 중간톤 */
        .btn-back {
            border: 1px solid #d1cfd4;
            color: #7d7a80;
        }
        .btn-back:hover {
            background-color: #f4f4f4;
        }

        /* 인풋 박스 라이트 핑크 포커스 효과 */
        .form-control:focus {
            border-color: #f5a9c5;
            box-shadow: 0 0 4px rgba(245, 169, 197, 0.5);
        }
    </style>
</head>

<body class="d-flex justify-content-center align-items-center">

<div class="login-box text-center">

    <h2 class="mb-4" style="font-weight:600; color:#f08fb5;">
        💗 로그인
    </h2>

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
