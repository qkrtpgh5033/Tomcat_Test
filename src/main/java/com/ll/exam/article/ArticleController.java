package com.ll.exam.article;

import com.ll.exam.Rq;
import com.ll.exam.article.dto.ArticleDto;

import java.util.ArrayList;
import java.util.List;

public class ArticleController {

    private ArticleService articleService = new ArticleService();

    public void showWrite(Rq rq){

        rq.view("/usr/article/write");
    }

    public void doWrite(Rq rq) {
        String title = rq.getParam("title", "");
        String body = rq.getParam("body", "");

        long id = articleService.write(title, body);

        rq.appendBody("%d번 게시물이 생성 되었습니다.".formatted(id));
    }

    public void showList(Rq rq){
        List<ArticleDto> lists = articleService.getList();

        rq.setAttr("articles", lists);
        rq.view("/usr/article/list");
    }

    public void showDetail(Rq rq) {
        long id = 1;

        ArticleDto findArticle = articleService.findById(id);

        rq.setAttr("article", findArticle);
        rq.view("/usr/article/detail");
    }
}
