<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="com.woowacourse.open_mission.domain.MemberResult" %>
<%@ page import="java.util.Map" %>

<%
    MemberResult memberResult = (MemberResult) request.getAttribute("memberResult");
    if (memberResult == null) {
%>
<h3>❌ 결과 데이터가 없습니다.</h3>
<%
        return;
    }

    String name = memberResult.getName();
    java.time.LocalDate createdAt = memberResult.getCreatedAt();
    Map<String, Integer> resultMap = memberResult.getResult();
%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>로또 당첨 결과</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background-color: #ffeff7; /* 파스텔 핑크 배경 */
            font-family: 'Noto Sans KR', sans-serif;
            min-height: 100vh;
        }

        .result-box {
            background: #ffffff;
            padding: 2.4rem;
            border-radius: 16px;
            box-shadow: 0 4px 14px rgba(0,0,0,0.08);
            width: 100%;
            max-width: 650px;
        }

        h2 {
            color: #d77fa1; /* 메인 포인트 핑크 */
        }

        .text-muted small {
            color: #b67386 !important;
        }

        /* 메인 버튼 */
        .btn-main {
            background-color: #f4a7c1; /* 파스텔 로즈 */
            border: none;
            color: white;
            font-weight: 600;
        }
        .btn-main:hover {
            background-color: #e08dac; /* 더 진한 로즈 */
            color: white;
        }

        /* 테이블 */
        .table thead {
            background-color: #ffe0eb; /* 부드러운 핑크 헤더 */
        }

        .table tbody tr td {
            vertical-align: middle;
        }

    </style>
</head>

<body class="d-flex justify-content-center align-items-center">

<div class="result-box">

    <h2 class="text-center mb-3 fw-semibold">🎀 로또 당첨 결과</h2>

    <p class="text-center text-muted mb-4">
        <strong><%= name %></strong> 님의 당첨 결과입니다.<br>
        <small>조회 일시: <%= createdAt %></small>
    </p>

    <table class="table table-bordered text-center mb-4">
        <thead>
        <tr>
            <th>결과</th>
            <th>개수</th>
        </tr>
        </thead>
        <tbody>
        <%
            if (resultMap == null || resultMap.isEmpty()) {
        %>
        <tr><td colspan="2">당첨 결과가 없습니다.</td></tr>
        <%
        } else {
            for (Map.Entry<String, Integer> entry : resultMap.entrySet()) {
        %>
        <tr>
            <td><%= entry.getKey() %></td>
            <td><%= entry.getValue() %>개</td>
        </tr>
        <%
                }
            }
        %>
        </tbody>
    </table>

    <a href="/v3/servlet/jsp" class="btn btn-main w-100">메인으로 돌아가기</a>

</div>

</body>
</html>
