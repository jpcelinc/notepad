package lv.ctco.notepad;

import java.time.LocalDate;

public interface WithBirthday {
    boolean hasBirthdayThisM();
      default void thisMonth(){
     System.out.println(LocalDate.now().getMonth().toString());
    };
}
