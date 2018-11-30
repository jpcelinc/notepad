package lv.ctco.notepad;

import java.util.Date;

/**
 * Created by S3BNUS on 2018.11.28..
 */
public class Reminder
        extends Record {
    private String text;
    private Date date;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Reminder{" +
                "Id='" + getId() + '\'' +
                ", Text='" + text + '\'' +
                ", Date='" + date.toString() + '\'' +
                '}';
    }

    @Override
    public boolean contains(String str) {
        return text.toLowerCase().contains(str)
                || date.toString().contains(str);
    }

    @Override
    public void askData() {
        text = Main.askString("Enter text");
        date = Main.askDate("Enter date");

    }
}



