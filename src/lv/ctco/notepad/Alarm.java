package lv.ctco.notepad;

import java.time.LocalTime;

/**
 * Created by yelena.pchelinceva on 11/30/2018.
 */
public class Alarm
        extends StickNote {
    //  private String text;
    private LocalTime time;


    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Alarm{" +
                "Id='" + getId() + '\'' +
                //   ", Date='" + date.toInstant().atZone(ZoneId.systemDefault()).toString() + '\'' +
                ", Time='" + time.format(Main.TIME_FORMATTER) + '\'' +
                ", Text='" + super.getText() + '\'' +
                '}';
    }

    @Override
    public boolean contains(String str) {
        return super.contains(str)
                || time.toString().contains(str);
    }

    @Override
    public void askData() {
        time = Main.askTime("Enter time");
        super.askData();

    }
}
