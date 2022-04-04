package entity;

import java.util.Date;

public class BoardEntity {
    private int n;
    private int num;
    private String title;
    private String writer;
    private String content;
    private Date date;
    private int comment_count;
    private int like_count;
    private String file;

    /*자유게시판*/
    public BoardEntity(int n, int num, String title, String writer, Date date, int comment_count) {
        this.n = n;
        this.num = num;
        this.title = title;
        this.writer = writer;
        this.date = date;
        this.comment_count = comment_count;
    }

    /*자유게시판 자세한 페이지*/
    public BoardEntity(String title, String writer, Date date, String content, int like_count, String file) {
        this.title = title;
        this.writer = writer;
        this.date = date;
        this.content = content;
        this.like_count = like_count;
        this.file = file;
    }
}
