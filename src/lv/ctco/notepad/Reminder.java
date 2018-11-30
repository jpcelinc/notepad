package lv.ctco.notepad;

import java.time.ZoneId;
import java.util.Date;

/**
 * Created by S3BNUS on 2018.11.28..
 */
public class Reminder
        extends StickNote {
  //  private String text;
    private Date date;


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
                ", Text='" + super.getText() + '\'' +
              //  ", Date='" + date.toString() + '\'' +
                ", Date='" + date.toInstant().atZone(ZoneId.systemDefault()).toString() + '\'' +
                '}';
    }

    @Override
    public boolean contains(String str) {
        return super.getText().toLowerCase().contains(str)
                || date.toString().contains(str);
    }

    @Override
    public void askData() {
       super.askData();
        date = Main.askDate("Enter date");

    }
}



