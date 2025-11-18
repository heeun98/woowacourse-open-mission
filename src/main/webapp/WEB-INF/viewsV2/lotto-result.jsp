<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="com.woowacourse.open_mission.domain.MemberResult" %>
<%@ page import="java.util.Map" %>

<%
    MemberResult memberResult = (MemberResult) request.getAttribute("memberResult");

    if (memberResult == null) {
%>
<h3 class="text-center mt-5">❌ 결과 데이터가 없습니다.</h3>
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
    <title>로또 결과</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background-color: #fff5f8; /* 파스텔 핑크 */
            font-family: 'Noto Sans KR', sans-serif;
        }

        .card-custom {
            width: 500px;
            border-radius: 14px;
            padding: 2rem;
            background: #ffffff;
            box-shadow: 0 4px 14px rgba(0,0,0,0.08);
        }

        /* 테이블 헤더 */
        .table thead {
            background-color: #fde2ea;
        }

        /* 메인 버튼 */
        .btn-main {
            background-color: #f7a8c4;
            border: none;
            color: white;
            font-weight: 600;
        }
        .btn-main:hover {
            background-color: #f291b4;
            color: white;
        }
    </style>
</head>

<body class="d-flex justify-content-center align-items-center" style="min-height: 100vh;">

<div class="card-custom text-center">
    <h2 class="fw-bold mb-3" style="color:#f291b4;">🎀 <%= name %>님의 로또 결과</h2>

    <p class="text-muted mb-4">
        조회 일시: <strong><%= createdAt %></strong>
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
        <tr>
            <td colspan="2" class="py-3">당첨 결과가 없습니다.</td>
        </tr>
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

    <div class="d-grid gap-2">
        <a href="/v3/servlet/jsp/history" class="btn btn-main fw-bold">⬅ 뒤로가기</a>
    </div>
</div>

</body>
</html>
