package com.ll.exam;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

@WebServlet("/gugudan")
public class GugudanServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        Rq rq = new Rq(req, resp);

        int dan = rq.getIntParam("dan", 0);
        int limit = rq.getIntParam("limit", 0);

        rq.appendBody("<h1>%d단</h1>\n".formatted(dan));

        for (int i = 1; i <= limit; i++) {
            rq.appendBody("<div>%d * %d = %d\n".formatted(dan, i, dan * i));
        }
    }
}

class Rq{
    HttpServletRequest req;
    HttpServletResponse resp;

    public Rq(HttpServletRequest req, HttpServletResponse resp) {


        this.req = req;
        this.resp = resp;

        try {
            req.setCharacterEncoding("UTF-8");
            resp.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html; charset=utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public int getIntParam(String parm, int value){
        return Integer.parseInt(req.getParameter(parm));
    }


    public void appendBody(String formatted) {
        try {
            resp.getWriter().append(formatted);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
