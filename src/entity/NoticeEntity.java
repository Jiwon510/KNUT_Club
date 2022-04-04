package entity;

import java.util.Date;

public class NoticeEntity {
    private int n;
    private int num;
    private String title;
    private String writer;
    private Date date;
    private String content;
    private String file;

    /* 공지사항 */
    public NoticeEntity(int n, int num, String title, String writer, Date date) {
        this.n = n;
        this.num = num;
        this.title = title;
        this.writer = writer;
        this.date = date;
    }

    /* 공지사항_자세한 페이지 */
    public NoticeEntity(String title, String writer, Date date, String content, String file) {
        this.title = title;
        this.writer = writer;
        this.date = date;
        this.content = content;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "NoticeEntity{" +
                "n=" + n +
                ", num=" + num +
                ", title='" + title + '\'' +
                ", writer='" + writer + '\'' +
                ", date=" + date +
                ", content='" + content + '\'' +
                ", file='" + file + '\'' +
                '}';
    }
}
