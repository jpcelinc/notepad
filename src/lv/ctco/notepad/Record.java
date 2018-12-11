package lv.ctco.notepad;

/**
 * Created by yelena.pchelinceva on 11/23/2018.
 */
public abstract class Record {
    private static int counter = 0;
    private int id;

    public Record() {
        counter++;
        id = counter;
    }

    public abstract boolean contains(String str);
    public abstract void askData();



    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Record record = (Record) o;

        return id == record.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
