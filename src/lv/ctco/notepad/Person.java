package lv.ctco.notepad;

/**
 * Created by yelena.pchelinceva on 11/16/2018.
 */
public class Person {
    private static int counter = 0;
    private int id;
    private String firstName;
    private String lastName;
    private String email;
 public Person() {
     counter++;
     id = counter;
 }
    public int getId() {
        return id;
    }


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

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", counter='" + counter + '\'' +
                '}';
    }
}
