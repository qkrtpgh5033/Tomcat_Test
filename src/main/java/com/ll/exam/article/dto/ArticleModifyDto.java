package com.ll.exam.article.dto;


public class ArticleModifyDto {
    String title;
    String body;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public ArticleModifyDto(String title, String body) {
        this.title = title;
        this.body = body;
    }
}
