<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>로그인</title>
    <script type="text/javascript" defer="defer">
        function signIn() {
            document.detailForm.action = "<c:url value="/user/signIn.do" />";
            document.detailForm.submit();
        }
    </script>
</head>
<body>
<form:form modelAttribute="userVO" id="detailForm" name="detailForm">
    <div>
        <h2>로그인</h2>
    </div>
    <table>
        <tr>
            <td><label for="email">이메일</label></td>
            <td><form:input path="email" cssClass="txt" /></td>
        </tr>
        <tr>
            <td><label for="password">비밀번호</label></td>
            <td><form:password path="password" /></td>
        </tr>
    </table>
    <div>
        <a href="javascript:signIn();">로그인</a>
    </div>
</form:form>
</body>
</html>
