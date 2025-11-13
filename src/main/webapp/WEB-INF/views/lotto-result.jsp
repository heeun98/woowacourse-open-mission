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
    <title>로또 결과</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light d-flex flex-column justify-content-center align-items-center"
      style="min-height: 100vh;">

<div class="bg-white p-5 rounded shadow" style="width: 450px;">
    <h2 class="text-center mb-4">🎉 로또 결과 - <%= name %></h2>

    <p class="text-center text-muted mb-3">
        조회 일시: <strong><%= createdAt %></strong>
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
            for (Map.Entry<String, Integer> entry : resultMap.entrySet()) {
        %>
        <tr>
            <td><%= entry.getKey() %></td>
            <td><%= entry.getValue() %>개</td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>

    <div class="text-center mt-4">
        <a href="/servlet/jsp/history" class="btn btn-secondary w-100">뒤로가기</a>
    </div>
</div>

</body>
</html>
