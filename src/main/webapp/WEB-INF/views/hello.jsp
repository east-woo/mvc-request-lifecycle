<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Spring MVC Example</title>
    <!-- Thymeleaf 템플릿 엔진 사용을 위한 설정 -->
    <th:block th:replace="fragments/header :: head"></th:block>
</head>
<body>
<h1 th:text="${message}">Hello, Spring MVC!</h1> <!-- message 속성 값 출력 -->
<p>Welcome to the Spring MVC application!</p>
</body>
</html>