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

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getComment_count() {
        return comment_count;
    }

    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
    }

    public int getLike_count() {
        return like_count;
    }

    public void setLike_count(int like_count) {
        this.like_count = like_count;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "BoardEntity{" +
                "n=" + n +
                ", num=" + num +
                ", title='" + title + '\'' +
                ", writer='" + writer + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                ", comment_count=" + comment_count +
                ", like_count=" + like_count +
                ", file='" + file + '\'' +
                '}';
    }
}
