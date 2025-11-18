<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.woowacourse.open_mission.domain.MemberResult" %>

<%
    Map<Long, MemberResult> memberResultMap =
            (Map<Long, MemberResult>) request.getAttribute("memberResultList");
%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>로또 구매 이력</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background-color: #fdeef1; /* 파스텔 핑크 배경 */
            font-family: 'Noto Sans KR', sans-serif;
        }

        .history-box {
            background-color: #ffffff;
            padding: 2rem;
            margin: auto;
            margin-top: 40px;
            max-width: 820px;
            border-radius: 14px;
            box-shadow: 0 3px 12px rgba(0,0,0,0.08);
        }

        .btn-main {
            background-color: #f8a5b5; /* 포인트 핑크 */
            border: none;
            color: #fff;
            font-weight: 500;
        }
        .btn-main:hover {
            background-color: #f58fa4;
            color: #fff;
        }

        thead {
            background-color: #fde2e4; /* 파스텔 핑크 헤더 */
        }

        .btn-back {
            border: 1px solid #d3cfd4;
            color: #6b6b6b;
        }
        .btn-back:hover {
            background-color: #f6f6f6;
        }

    </style>
</head>

<body>

<div class="history-box">
    <h2 class="mb-4 fw-semibold text-center">📜 로또 구매 이력</h2>

    <table class="table table-bordered text-center">
        <thead>
        <tr>
            <th>#</th>
            <th>이름</th>
            <th>구매 날짜</th>
            <th>결과 보기</th>
        </tr>
        </thead>
        <tbody>

        <%
            if (memberResultMap == null || memberResultMap.isEmpty()) {
        %>
        <tr>
            <td colspan="4" class="py-4">아직 저장된 구매 기록이 없습니다.</td>
        </tr>
        <%
        } else {
            int index = 1;
            for (Map.Entry<Long, MemberResult> entry : memberResultMap.entrySet()) {
                MemberResult mr = entry.getValue();
                String name = mr.getName();
                java.time.LocalDate date = mr.getCreatedAt();
        %>
        <tr>
            <td><%= index %></td>
            <td><%= name %></td>
            <td><%= date %></td>
            <td>
                <a href="/v3/servlet/jsp/result?resultId=<%= index %>"
                   class="btn btn-main btn-sm">보기</a>
            </td>
        </tr>
        <%
                    index++;
                }
            }
        %>

        </tbody>
    </table>

    <div class="text-center mt-4">
        <a href="/v3/servlet/jsp" class="btn btn-back px-4">⬅ 메인으로 돌아가기</a>
    </div>
</div>

</body>
</html>
