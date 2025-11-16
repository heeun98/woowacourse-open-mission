<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.woowacourse.open_mission.servletJsp.domain.MemberResult" %>

<%
    Map<Long, MemberResult> memberResultMap =
            (Map<Long, MemberResult>) request.getAttribute("memberResultList");
%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>로또 구매 이력</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="container py-5">

<h2 class="mb-4">📜 로또 구매 이력</h2>

<table class="table table-bordered text-center">
    <thead class="table-light">
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
        <td colspan="4">아직 저장된 구매 기록이 없습니다.</td>
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
        <td><%= index++ %></td>
        <td><%= name %></td>
        <td><%= date %></td>
        <td>
            <a href="/servlet/jsp/result?resultId=<%= index - 1 %>"
               class="btn btn-primary btn-sm">결과 보기</a>
        </td>
    </tr>
    <%
            }
        }
    %>

    </tbody>
</table>

<div class="mt-3">
    <a href="/v3/servlet/jsp" class="btn btn-outline-secondary">메인으로 돌아가기</a>
</div>

</body>
</html>
