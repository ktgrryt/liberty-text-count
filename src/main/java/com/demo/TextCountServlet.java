package com.demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/count")
public class TextCountServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // JSPにフォワード（GETリクエスト時にフォームを表示）
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // リクエストの文字エンコーディングを設定
        request.setCharacterEncoding("UTF-8");

        // フォームから送信された内容を取得
        String message = request.getParameter("message");
        int charCount = (message != null) ? message.length() : 0;
        int pureCharCount = (message != null) ? message.replaceAll("[\\s\u3000]+", "").length() : 0;

        // 文字数をリクエスト属性に設定
        request.setAttribute("submittedMessage", message);  // JSPに渡すデータ
        request.setAttribute("charCount", charCount);
        request.setAttribute("pureCharCount", pureCharCount);

        // レスポンスの文字エンコーディングを設定
        response.setCharacterEncoding("UTF-8");
        request.getRequestDispatcher("/index.jsp").forward(request, response);  // 同じJSPを再表示
    }
}