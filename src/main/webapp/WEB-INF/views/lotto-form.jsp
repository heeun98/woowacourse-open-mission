<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>로또 구매</title>
    <!-- Bootstrap CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light d-flex justify-content-center align-items-center" style="height: 100vh;">

<div class="text-center">
    <h1 class="mb-4">🎰 로또 구매하기</h1>

    <form action="/servlet/lotto/buy" method="post" class="p-4 bg-white rounded shadow" style="width: 350px;">
        <input class="form-control mb-3" type="text" name="name" placeholder="이름을 입력하세요" required>
        <input class="form-control mb-3" type="number" name="amount" placeholder="구매 금액 (예: 5000)" required>
        <button class="btn btn-primary w-100" type="submit">구매하기</button>
    </form>
</div>

</body>
</html>
