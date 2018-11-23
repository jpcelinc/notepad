package lv.ctco.notepad;

/**
 * Created by yelena.pchelinceva on 11/16/2018.
 */
public class
Person extends Record {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String gender;


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

    @Override
    public String toString() {
        return "Person{" +
                ",Id='" + getId() + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    @Override
    public boolean contains(String str) {
        return firstName.toLowerCase().contains(str)
                || lastName.toLowerCase().contains(str)
                || gender.toLowerCase().contains(str)
                || email.toLowerCase().contains(str)
                || phone.toLowerCase().contains(str)
                ;
    }

    @Override
    public void askData() {

        Person p = new Person();
        String firstName = Main.askString("First Name");
        p.setFirstName(firstName);

        String lastName = Main.askString("Last Name");
        p.setLastName(lastName);
        String gendr = Main.askString("Gender");
        p.setGender(gender);

        String email = Main.askString("Email");
        p.setEmail(email);

        String phone = Main.askPhone("Phone");
        p.setPhone(phone);

    }
}



