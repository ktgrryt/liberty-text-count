<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title></title>
</head>
<body>
    <h1>文字数カウンタ</h1>
    
    <form action="count" method="post">
        <label for="message">メッセージを入力してください：</label><br>
        <textarea id="message" name="message" rows="10" cols="100"></textarea><br><br>
        <button type="submit">送信</button>
    </form>

    <hr>
    
    <!-- フォーム送信後、入力されたメッセージを表示 -->
    <%
        String submittedMessage = (String) request.getAttribute("submittedMessage");
        Integer charCount = (Integer) request.getAttribute("charCount");
        Integer pureCharCount = (Integer) request.getAttribute("pureCharCount");

        if (submittedMessage != null && charCount != null) {
    %>
        <h2>入力されたメッセージ:</h2>
        <p>
            <strong><%= submittedMessage %></strong>
        </p>
        <h2>文字数:</h2>
        <p>
            <strong><%= charCount %></strong>
        </p>
        <h2>空白や改行を除いた文字数:</h2>
        <p>
            <strong><%= pureCharCount %></strong>
        </p>
    <%
        } else {
    %>
        <p>まだメッセージが送信されていません。</p>
    <%
        }
    %>
</body>
</html>
