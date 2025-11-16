<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="com.woowacourse.open_mission.servletJspSession.domain.Member" %>

<%
    Member member = (Member) request.getAttribute("member");
%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>로또 서비스</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background-color: #f8f9fa;
        }

        /* 카드 스타일 */
        .card-custom {
            width: 420px;
            border-radius: 12px;
            padding: 3rem 2rem;
            box-shadow: 0 4px 12px rgba(0,0,0,0.1);
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

        /* 환영 메시지 */
        .welcome-message {
            font-size: 1.5rem;
            font-weight: 700;
            color: #74c69d;
            margin-bottom: 1.5rem;
        }
    </style>
</head>

<body class="d-flex justify-content-center align-items-center" style="min-height: 100vh;">

<div class="card card-custom text-center">

    <!-- 환영 메시지 -->
    <div class="welcome-message">
        <%= member != null ? member.getUsername() + "님 환영합니다!" : "게스트님 환영합니다!" %>
    </div>

    <h1 class="fw-bold mb-4">🎰 로또 서비스</h1>

    <div class="d-grid gap-3">
        <a class="btn btn-main btn-lg" href="/v3/servlet/jsp/lotto">
            🎯 로또 시작하기
        </a>

        <a class="btn btn-outline-main btn-lg" href="/v3/servlet/jsp/history">
            📜 조회하기
        </a>
    </div>
</div>

</body>
</html>
