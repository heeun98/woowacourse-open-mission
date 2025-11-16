<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="com.woowacourse.open_mission.servletJsp.domain.MemberResult" %>
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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light d-flex flex-column justify-content-center align-items-center" style="min-height: 100vh;">

<div class="bg-white p-5 rounded shadow" style="max-width: 600px; width: 100%;">
    <h2 class="text-center mb-3">🎉 로또 당첨 결과</h2>

    <p class="text-center text-muted mb-4">
        <strong><%= name %></strong> 님의 결과입니다.<br>
        <small>조회 일시: <%= createdAt %></small>
    </p>

    <table class="table table-bordered text-center">
        <thead class="table-light">
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
                String message = entry.getKey();
                Integer count = entry.getValue();
        %>
        <tr>
            <td><%= message %></td>
            <td><%= count %>개</td>
        </tr>
        <%
                }
            }
        %>
        </tbody>
    </table>

    <div class="text-center mt-4">
        <a href="/v3/servlet/jsp" class="btn btn-secondary w-100">메인으로 돌아가기</a>
    </div>
</div>

</body>
</html>
