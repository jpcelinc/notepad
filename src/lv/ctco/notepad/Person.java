package lv.ctco.notepad;

import java.time.LocalDate;

/**
 * Created by yelena.pchelinceva on 11/16/2018.
 */
public class
Person extends Record implements WithBirthday {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String gender;
    private LocalDate birthday;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Person{" +
                "Id='" + getId() + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday='" + birthday.format(Main.DATE_FORMATTER) + '\'' +
                '}';
    }

    @Override
    public boolean contains(String str) {
        return firstName.toLowerCase().contains(str)
                || lastName.toLowerCase().contains(str)
                || gender.toLowerCase().contains(str)
                || email.toLowerCase().contains(str)
                || phone.toLowerCase().contains(str)
                || gender.toLowerCase().contains(str)
                || birthday.toString().contains(str);

    }

    @Override
    public void askData() {

         firstName = Main.askString("First Name");
         lastName = Main.askString("Last Name");
         gender = Main.askString("Gender");
         email = Main.askString("Email");
         phone = Main.askPhone("Phone");
         birthday = Main.askDate("Person birthday");
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



