package ai.kf.UdvashH;

public class Video {
    private String Title;
    private String url;
    private String Lecture;
    private String Subject;

    public Video(String title, String url, String lecture, String subject) {
        Title = title;
        this.url = url;
        Lecture = lecture;
        Subject = subject;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLecture() {
        return Lecture;
    }

    public void setLecture(String lecture) {
        Lecture = lecture;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }
}
