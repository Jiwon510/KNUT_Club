package entity;

public class WriteEntity {
    private String title;
    private String writer;
    private String content;
    private int like_count;

    /*공지사항_글쓰기*/
    public WriteEntity(String title, String writer, String content) {
        this.title = title;
        this.writer = writer;
        this.content = content;
    }

    /*자유게시판_글쓰기*/
    public WriteEntity(String title, String writer, String content, int like_count) {
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.like_count = like_count;
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

    public int getLike_count() {
        return like_count;
    }

    public void setLike_count(int like_count) {
        this.like_count = like_count;
    }

    @Override
    public String toString() {
        return "WriteEntity{" +
                "title='" + title + '\'' +
                ", writer='" + writer + '\'' +
                ", content='" + content + '\'' +
                ", like_count=" + like_count +
                '}';
    }
}
