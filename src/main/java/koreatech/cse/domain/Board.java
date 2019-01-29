package koreatech.cse.domain;


import java.util.Date;

public class Board{
    private int id;
    private String subject;
    private String contents;
    private Date dateTime;
    private int hits;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    @Override
    public String toString() {
        return "Board{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", contents='" + contents + '\'' +
                ", dateTime=" + dateTime +
                ", hits=" + hits +
                '}';
    }
}
