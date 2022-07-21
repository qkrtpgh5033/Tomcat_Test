package com.ll.exam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Rq {
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

    public int getIntParam(String parm, int defaultValue){
        String value = req.getParameter(parm);
        if(value == null)
            return defaultValue;

        try {
            return Integer.parseInt(value);
        }catch (NumberFormatException e){
            System.out.println(e);
        }
        return defaultValue;
    }


    public void appendBody(String formatted) {
        try {
            resp.getWriter().append(formatted);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
