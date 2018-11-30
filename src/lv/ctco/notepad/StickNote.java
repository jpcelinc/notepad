package lv.ctco.notepad;

/**
 * Created by yelena.pchelinceva on 11/23/2018.
 */
public class StickNote
        extends Record {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "StickNote{" +
                "Id='" + getId() + '\'' +
                ", Text='" + text + '\'' +
                '}';
    }

    @Override
    public boolean contains(String str) {
        return text.toLowerCase().contains(str);
    }

    @Override
    public void askData() {
        text = Main.askString("Enter text");

    }
}
