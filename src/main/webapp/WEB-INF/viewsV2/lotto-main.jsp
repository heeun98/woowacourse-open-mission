<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="com.woowacourse.open_mission.domain.Member" %>

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
            background-color: #fff7fb; /* 훨씬 더 연한 파스텔 핑크 */
            font-family: 'Noto Sans KR', sans-serif;
        }

        /* 카드 스타일 */
        .card-custom {
            width: 420px;
            border-radius: 16px;
            padding: 3rem 2rem;
            background: #ffffff;
            box-shadow: 0 4px 14px rgba(255, 182, 219, 0.18); /* 연핑크 그림자 */
        }

        /* 메인 버튼 (연핑크 톤) */
        .btn-main {
            background-color: #ffc7e1;   /* 기존보다 훨씬 부드러운 색 */
            border: none;
            color: #ffffff;
            font-weight: 600;
        }
        .btn-main:hover {
            background-color: #ffb3d6;
            color: white;
        }

        /* 보조 버튼 (밝은 테두리) */
        .btn-outline-main {
            background-color: #ffffff;
            color: #ffb3d6;
            border: 2px solid #ffb3d6;
            font-weight: 600;
        }
        .btn-outline-main:hover {
            background-color: #ffb3d6;
            color: white;
            border-color: #ffb3d6;
        }

        /* 환영 메시지 */
        .welcome-message {
            font-size: 1.5rem;
            font-weight: 700;
            color: #ffb3d6;   /* 훨씬 더 연한 핑크 텍스트 */
            margin-bottom: 1.5rem;
        }

        .title {
            color: #ffb3d6;
        }
    </style>
</head>

<body class="d-flex justify-content-center align-items-center" style="min-height: 100vh;">

<div class="card card-custom text-center">

    <!-- 환영 메시지 -->
    <div class="welcome-message">
        <%= member != null ? member.getUsername() + "님 환영합니다! 🌸" : "방문자님 환영합니다! 🌸" %>
    </div>

    <h1 class="fw-bold mb-4 title">🎰 로또 서비스</h1>

    <div class="d-grid gap-3">
        <a class="btn btn-main btn-lg" href="/v3/servlet/jsp/lotto">
            🎯 로또 시작하기
        </a>

        <a class="btn btn-outline-main btn-lg" href="/v3/servlet/jsp/history">
            📜 구매 이력 조회하기
        </a>
    </div>
</div>

</body>
</html>
