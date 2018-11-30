package lv.ctco.notepad;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;


/**
 * Created by S3BNUS on 2018.11.28..
 */
public class Reminder
        extends StickNote {
    //  private String text;
    private LocalDate date;


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Reminder{" +
                "Id='" + getId() + '\'' +
             //   ", Date='" + date.toInstant().atZone(ZoneId.systemDefault()).toString() + '\'' +
                ", Date='" + date.format(Main.DATE_FORMATTER) + '\'' +
                ", Text='" + super.getText() + '\'' +
                '}';
    }

    @Override
    public boolean contains(String str) {
        return super.contains(str)
                || date.toString().contains(str);
    }

    @Override
    public void askData() {
        date = Main.askDate("Enter date");
        super.askData();

    }
}



