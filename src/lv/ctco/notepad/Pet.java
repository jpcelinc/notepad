package lv.ctco.notepad;
import java.time.LocalDate;

public class Pet extends Record implements WithBirthday{
    private String petName;
    private LocalDate birthday;

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "Id='" + getId() + '\'' +
                ", petName='" + petName + '\'' +
                ", birthday='" + birthday.format(Main.DATE_FORMATTER) + '\'' +
                '}';
    }

    @Override
    public boolean contains(String str) {
        return petName.toLowerCase().contains(str)
               || birthday.toString().contains(str);

    }
    @Override
    public void askData() {

        petName = Main.askString("Pet name");
        birthday = Main.askDate("Pet birthday");

    }
    @Override
    public boolean hasBirthdayThisM() {
        LocalDate now = LocalDate.now();
        if (now.getMonth().getValue() == birthday.getMonth().getValue()) {
            return true;
        }
        return false;
    }
}
