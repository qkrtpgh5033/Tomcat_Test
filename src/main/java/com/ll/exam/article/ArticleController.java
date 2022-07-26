package com.ll.exam.article;

import com.ll.exam.Rq;
import com.ll.exam.article.dto.ArticleDto;

import java.util.ArrayList;
import java.util.List;

public class ArticleController {
    public void showList(Rq rq){
        List<ArticleDto> lists = new ArrayList<>();
        lists.add(new ArticleDto(3L, "제목 3", "내용 3"));
        lists.add(new ArticleDto(2L, "제목 2", "내용 2"));
        lists.add(new ArticleDto(1L, "제목 1", "내용 1"));

        rq.setAttr("articles", lists);
        rq.view("/usr/article/list");
    }

    public void showWrite(Rq rq){

        rq.view("/usr/article/write");
    }

    public void doWrite(Rq rq) {
        String title = rq.getParam("title", "");
        String body = rq.getParam("body", "");

        rq.appendBody("<div>title : %s</div>".formatted(title));
        rq.appendBody("<div>body : %s</div>".formatted(body));
    }
}
