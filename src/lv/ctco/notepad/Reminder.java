package lv.ctco.notepad;

import java.time.LocalDate;
import java.time.LocalDateTime;
//import java.time.ZoneId;
//import java.time.format.DateTimeFormatter;


/**
 * Created by S3BNUS on 2018.11.28..
 */
public class Reminder
        extends Alarm implements Expirable {
    //  private String text;
    private LocalDate date;
    private boolean dissmissed = false;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


    public void dissmiss() {
        dissmissed = true;
    }

    @Override
    public boolean isExpired() {
        if (dissmissed) {
            return false;
        }
        LocalDateTime now = LocalDateTime.now();
        return now.isAfter(LocalDateTime.of(date, super.getTime()));
    }

    @Override
    public String toString() {
        return "Reminder{" +
                "Id='" + getId() + '\'' +
                //   ", Date='" + date.toInstant().atZone(ZoneId.systemDefault()).toString() + '\'' +
                ", Date='" + date.format(Main.DATE_FORMATTER) + '\'' +
                ", Time='" + super.getTime().format(Main.TIME_FORMATTER) + '\'' +
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
        date = Main.askDate("Enter date. ");
        super.askData();

    }
}



